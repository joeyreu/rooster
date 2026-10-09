import "./styles/game.css";

import {
  createGameEngine,
  createGameDefinition,
  EMPTY_INPUT,
  type GameEngine,
  type GameEvent,
  type GameState,
  type RunContinuation,
  type StepResult,
  type SuspensionReason,
} from "./core";
import { StatusView } from "./app/status-view";
import { ATLASES, GAME_DATA, LEVELS, type AssetId, type LevelDefinition } from "./data";
import { FixedStepClock } from "./platform/browser-clock";
import { BrowserHaptics } from "./platform/browser-haptics";
import { BrowserInput } from "./platform/browser-input";
import { BrowserSaveStore } from "./platform/browser-storage";
import { AssetLoadError, loadFirstPassAssets } from "./render/asset-loader";
import { CanvasRenderer, renderBoot } from "./render/canvas-renderer";
import { requiredElement, ScreenView, type ScreenAction } from "./screens/screen-view";

type AppRoute =
  | "loading"
  | "loadError"
  | "title"
  | "run"
  | "nextLevel"
  | "finale"
  | "results";

interface PlaytestSnapshot {
  route: AppRoute;
  level: number;
  score: number;
  spareLives: number;
  trafficRemaining: number;
  phase: GameState["phase"] | null;
}

interface RoosterPlaytestApi {
  completeLevel(): PlaytestSnapshot;
  continue(): PlaytestSnapshot;
  setCampaignTotals(score: number, spareLives: number): PlaytestSnapshot;
  snapshot(): PlaytestSnapshot;
}

declare global {
  interface Window {
    __ROOSTER_PLAYTEST__?: RoosterPlaytestApi;
  }
}

const NEXT_LEVEL_CAPTIONS = Object.freeze([
  "What are ya, Chicken?!",
  "Time to take it up a notch",
  "The grass is always greener...",
  "Operation desert chicken.",
  "Rooster of Arabia",
  "Hasta la vista, chicken!!",
  "Never travel alone",
  "Avast ye cowardly squab!!",
  "Mmmm... Eau de toilet!",
  "How's da wetter??",
  "In the creek.",
  "Heavy Metal Baby!!!!",
  "Tanks for the memories",
  "What are those things?",
  "I'm scared mommy.",
  "The final frontier.",
  "Fast-forwarding, Sir!",
  "Is that your UFO????",
  "THE BIG KAHOONA!!!",
] as const);

const canvas = requiredElement("game-canvas", HTMLCanvasElement);
const gameWrapper = requiredElement("game-wrapper");
const gameObjective = requiredElement("game-objective");
const sceneTitle = requiredElement("scene-title");
const pauseButton = requiredElement("pause-button", HTMLButtonElement);
const controls = requiredElement("game-controls");
const vibrationToggle = requiredElement("vibration-toggle", HTMLInputElement);
const confirmDialog = requiredElement("confirm-dialog", HTMLDialogElement);
const directionButtons = [...document.querySelectorAll<HTMLButtonElement>("[data-direction]")];

const saveStore = new BrowserSaveStore();
const haptics = new BrowserHaptics(saveStore.value.settings.vibration);
const statusView = new StatusView();
const firstLevelIndex = requestedStartLevelIndex();

let currentLevelIndex = firstLevelIndex;
let engine = engineFor(LEVELS[currentLevelIndex]!);
let route: AppRoute = "loading";
let gameState: GameState | null = null;
let renderer: CanvasRenderer | null = null;
let loadingProgress = { loaded: 0, total: 0 };
let loadingAssets = new Map<AssetId, HTMLImageElement>();
let scoreWasNewBest = false;
let assetLoadAttempt = 0;
let campaignSeed = 0;
let screenFrame = 0;

const screenView = new ScreenView(handleScreenAction);
const input = new BrowserInput({
  wrapper: gameWrapper,
  directionButtons,
  hasRun: () => hasRun() && !confirmDialog.open,
  isMovementActive: () => isMovementActive(),
  onPauseToggle: () => togglePause(),
  onConfirm: () => activateDefaultAction(),
  onFocusConfirm: () => pauseButton.focus(),
  isAnyKeyConfirmActive: () => route === "finale",
});

const clock = new FixedStepClock({
  tickMs: GAME_DATA.rules.tickMilliseconds,
  onStep: step,
  onRender: render,
});

pauseButton.addEventListener("click", () => {
  if (route === "nextLevel" || route === "finale") activateDefaultAction();
  else togglePause();
});
canvas.addEventListener("pointerdown", () => {
  if (route === "nextLevel" || route === "finale") activateDefaultAction();
  else if (hasRun()) gameWrapper.focus({ preventScroll: true });
});
vibrationToggle.checked = saveStore.value.settings.vibration;
vibrationToggle.addEventListener("change", () => {
  const saved = saveStore.setVibration(vibrationToggle.checked);
  haptics.setEnabled(saved.settings.vibration);
});
document.addEventListener("visibilitychange", () => {
  if (document.visibilityState === "hidden") suspendRun("hidden");
});
window.addEventListener("blur", () => suspendRun("blur"));

screenView.showLoading(0, 0);
updateStatus();
syncControls();
clock.start();
installPlaytestApi();
void beginLoading();

async function beginLoading(): Promise<void> {
  const attempt = ++assetLoadAttempt;
  const focusLoadingStatus = route === "loadError";
  route = "loading";
  loadingProgress = { loaded: 0, total: 0 };
  loadingAssets = new Map<AssetId, HTMLImageElement>();
  screenView.showLoading(0, 0, focusLoadingStatus);
  syncControls();

  try {
    const assets = await loadFirstPassAssets(
      (loaded, total) => {
        if (attempt !== assetLoadAttempt || route !== "loading") return;
        loadingProgress = { loaded, total };
        screenView.showLoading(loaded, total);
      },
      (assetId, image) => {
        if (attempt !== assetLoadAttempt || route !== "loading") return;
        loadingAssets.set(assetId, image);
      },
    );
    if (attempt !== assetLoadAttempt) return;
    loadingAssets = new Map(assets);
    configureLevel(firstLevelIndex);
    route = "title";
    screenView.showTitle();
    statusView.announce("Rooster is ready. Start the 20-level campaign.");
  } catch (error) {
    if (attempt !== assetLoadAttempt) return;
    route = "loadError";
    const label = error instanceof AssetLoadError ? error.asset.id : "unknown asset";
    screenView.showLoadError(label);
    console.error(error);
  }
  updateStatus();
  syncControls();
}

function handleScreenAction(action: ScreenAction): void {
  switch (action) {
    case "retry":
      void beginLoading();
      return;
    case "start":
    case "newGame":
    case "replay":
      startCampaign();
      return;
    case "resume":
      resumeRun();
      return;
    case "quit":
    case "title":
      showTitle();
      return;
  }
}

function activateDefaultAction(): void {
  if (route === "title") startCampaign();
  else if (route === "loadError") void beginLoading();
  else if (route === "nextLevel") continueCampaign();
  else if (route === "finale") showCampaignResults();
  else if (route === "results") startCampaign();
}

function startCampaign(): void {
  if (renderer === null) return;
  input.clear();
  scoreWasNewBest = false;
  campaignSeed = createRunSeed();
  configureLevel(firstLevelIndex);
  gameState = engine.createRun(campaignSeed);
  route = "run";
  screenFrame = 0;
  screenView.hide();
  clock.clearElapsed();
  updateStatus();
  syncControls();
  gameWrapper.focus();
  statusView.announce(`Level ${currentLevelNumber()} started. Reach the top.`);
}

function continueCampaign(): void {
  if (route !== "nextLevel" || gameState === null) return;
  const continuation: RunContinuation = {
    score: gameState.score,
    spareLives: gameState.spareLives,
    rngStates: { ...gameState.rngStates },
  };
  configureLevel(currentLevelIndex + 1);
  gameState = engine.createRun(campaignSeed, continuation);
  route = "run";
  screenFrame = 0;
  clock.clearElapsed();
  updateStatus();
  syncControls();
  gameWrapper.focus();
  statusView.announce(`Level ${currentLevelNumber()} started. Score and lives carried forward.`);
}

function showTitle(): void {
  input.clear();
  gameState = null;
  configureLevel(firstLevelIndex);
  route = "title";
  scoreWasNewBest = false;
  screenFrame = 0;
  screenView.showTitle();
  clock.clearElapsed();
  updateStatus();
  syncControls();
}

function togglePause(): void {
  if (!hasRun() || gameState === null) return;
  if (gameState.suspension === null) suspendRun("user");
  else resumeRun();
}

function suspendRun(reason: SuspensionReason): void {
  if (!hasRun() || gameState === null || gameState.suspension !== null) return;
  applyResult(engine.suspend(gameState, reason));
  screenView.showPause();
  clock.clearElapsed();
  updateStatus();
  syncControls();
}

function resumeRun(): void {
  if (!hasRun() || gameState === null || gameState.suspension === null) return;
  applyResult(engine.resume(gameState));
  screenView.hide();
  clock.clearElapsed();
  updateStatus();
  syncControls();
  gameWrapper.focus();
}

function step(): void {
  if (route === "nextLevel" || route === "finale") {
    screenFrame += 1;
    syncScreenFrame();
    return;
  }
  if (!hasRun() || gameState === null || gameState.suspension !== null) return;
  applyResult(engine.step(gameState, input.snapshot()));
  updateStatus();
  syncControls();
}

function applyResult(result: StepResult): void {
  gameState = result.state;
  dispatchEvents(result.events);
}

function dispatchEvents(events: readonly GameEvent[]): void {
  const announcements: string[] = [];
  for (const event of events) {
    switch (event.type) {
      case "clearInputRequested":
        input.clear();
        break;
      case "vibrationRequested":
        haptics.deathBuzz(event.milliseconds);
        break;
      case "pickupCollected":
        announcements.push(pickupAnnouncement(event));
        break;
      case "playerDied": {
        const cause = event.cause === "counterZero" ? "Traffic counter reached zero" : "Hit by traffic";
        const attempts = Math.max(0, event.spareLives + 1);
        announcements.push(
          `${cause}. ${attempts} ${attempts === 1 ? "attempt" : "attempts"} remaining.`,
        );
        break;
      }
      case "playerRespawned":
        announcements.push("Back on the road.");
        break;
      case "levelCompleted":
        announcements.push(`Level ${currentLevelNumber()} completed.`);
        break;
      case "scoreFinalized":
        break;
      case "resultsReady":
        handleRunResult(event.outcome, event.finalScore, announcements);
        break;
      case "suspended":
        announcements.push("Game paused.");
        break;
      case "resumed":
        announcements.push("Game resumed.");
        break;
    }
  }
  if (announcements.length > 0) statusView.announce(announcements.join(" "));
}

function handleRunResult(
  outcome: "win" | "loss",
  finalScore: number,
  announcements: string[],
): void {
  input.clear();
  screenView.hide();
  screenFrame = 0;

  if (outcome === "win" && currentLevelIndex < LEVELS.length - 1) {
    route = "nextLevel";
    announcements.push(`Score ${finalScore}. Continue to level ${currentLevelNumber() + 1}.`);
    gameWrapper.focus();
    return;
  }

  recordCampaignScore(finalScore);
  if (outcome === "win") {
    route = "finale";
    announcements.push(`Campaign complete. Final score ${finalScore}.`);
    gameWrapper.focus();
    return;
  }

  route = "results";
  screenView.showResults({
    outcome,
    score: finalScore,
    bestScore: saveStore.value.bestScore,
    isNewBest: scoreWasNewBest,
    level: currentLevelNumber(),
    totalLevels: LEVELS.length,
    campaignComplete: false,
  });
  announcements.push(`Game over on level ${currentLevelNumber()}. Score ${finalScore}.`);
}

function recordCampaignScore(score: number): void {
  const previousBest = saveStore.value.bestScore;
  const saved = saveStore.recordScore(score);
  scoreWasNewBest = score > previousBest && saved.bestScore === score;
}

function showCampaignResults(): void {
  if (route !== "finale" || gameState === null) return;
  route = "results";
  screenView.showResults({
    outcome: "win",
    score: gameState.score,
    bestScore: saveStore.value.bestScore,
    isNewBest: scoreWasNewBest,
    level: currentLevelNumber(),
    totalLevels: LEVELS.length,
    campaignComplete: true,
  });
  updateStatus();
  syncControls();
  statusView.announce(`All ${LEVELS.length} levels complete. Final score ${gameState.score}.`);
}

function pickupAnnouncement(
  event: Extract<GameEvent, { type: "pickupCollected" }>,
): string {
  switch (event.kind) {
    case "gray":
      return "Extra life collected. One spare life added.";
    case "orange":
      return "Speed boost collected. Movement speed doubled.";
    case "purple":
      return `Traffic bonus collected. ${event.bonus} added to the traffic counter.`;
  }
}

function render(): void {
  if (renderer === null) {
    renderBoot(canvas, loadingProgress.loaded, loadingProgress.total, loadingAssets);
    return;
  }

  if (route === "title" || route === "loadError" || route === "loading") {
    renderer.renderTitle();
    return;
  }
  if (route === "nextLevel" && gameState !== null) {
    renderer.renderNextLevel(currentLevelNumber() + 1, gameState.score, screenFrame);
    return;
  }
  if (route === "finale") {
    renderer.renderFinale(screenFrame);
    return;
  }
  if (gameState !== null) renderer.renderGame(gameState, gameState.suspension !== null);
}

function updateStatus(): void {
  const save = saveStore.value;
  const state = gameState;
  const objective = objectiveForCurrentState();
  statusView.update({
    level: currentLevelNumber(),
    totalLevels: LEVELS.length,
    score: state?.score ?? 0,
    trafficRemaining: state?.trafficRemaining ?? engine.definition.level.initialTrafficRemaining,
    spareLives: state?.spareLives ?? engine.definition.rules.player.initialSpareLives,
    bestScore: save.bestScore,
    objective,
  });
  gameObjective.textContent = objective;
  sceneTitle.textContent = sceneTitleForCurrentRoute();
  canvas.setAttribute("aria-label", `${sceneTitle.textContent}. ${objective}`);
}

function objectiveForCurrentState(): string {
  if (route === "loading") return "Loading the recovered campaign.";
  if (route === "loadError") return "Retry loading the recovered artwork.";
  if (route === "title") return "Objective: cross all 20 levels and claim the Golden Rooster.";
  if (route === "nextLevel") {
    return `Level ${currentLevelNumber()} complete. Next: Level ${currentLevelNumber() + 1}, ${nextLevelCaption()}. Press Continue, Enter, Space, or tap the scene.`;
  }
  if (route === "finale") {
    return "Golden Rooster finale. The rooster crossed the road, the sea, space, and time itself. Press Finish, Enter, Space, or tap the scene for results.";
  }
  if (route === "results") return "Campaign ended. Start a new campaign or return to the title.";
  if (gameState?.suspension !== null) return "Run paused.";
  if (gameState?.phase === "dying") return "Preparing another attempt.";
  if (gameState?.phase === "levelComplete") return "Level complete.";
  if (gameState?.phase === "gameOver") return "Game over.";
  return `Objective: cross level ${currentLevelNumber()} and reach the top.`;
}

function syncControls(): void {
  const hasActiveRun = hasRun();
  const hasCampaignAction = route === "nextLevel" || route === "finale";
  const movementActive = isMovementActive();
  const suspended = gameState?.suspension !== null && gameState !== null;
  pauseButton.disabled = !hasActiveRun && !hasCampaignAction;
  pauseButton.hidden = suspended;
  pauseButton.textContent = route === "nextLevel" ? "Continue" : route === "finale" ? "Finish" : "Pause";
  controls.dataset.runActive = String(hasActiveRun || hasCampaignAction);
  for (const button of directionButtons) button.disabled = !movementActive;
  gameWrapper.dataset.route = route;
  gameWrapper.dataset.level = String(currentLevelNumber());
  gameWrapper.dataset.phase = gameState?.phase ?? "none";
  gameWrapper.dataset.suspended = String(suspended);
  gameWrapper.dataset.tick = String(gameState?.tick ?? 0);
  gameWrapper.dataset.playerX = String(gameState?.player.x ?? 0);
  gameWrapper.dataset.playerY = String(gameState?.player.y ?? 0);
  gameWrapper.dataset.score = String(gameState?.score ?? 0);
  gameWrapper.dataset.spareLives = String(gameState?.spareLives ?? 0);
  gameWrapper.dataset.trafficRemaining = String(gameState?.trafficRemaining ?? 0);
  syncScreenFrame();
  if (gameState === null) delete gameWrapper.dataset.runSeed;
  else gameWrapper.dataset.runSeed = String(gameState.runSeed);
}

function syncScreenFrame(): void {
  gameWrapper.dataset.screenFrame = String(screenFrame);
}

function hasRun(): boolean {
  return route === "run" && gameState?.route === "run";
}

function isMovementActive(): boolean {
  return hasRun() && gameState?.suspension === null && gameState.phase === "playing";
}

function configureLevel(index: number): void {
  const level = LEVELS[index];
  if (level === undefined) throw new RangeError(`Missing campaign level ${index + 1}.`);
  currentLevelIndex = index;
  engine = engineFor(level);
  if (loadingAssets.size > 0) {
    renderer = new CanvasRenderer(canvas, loadingAssets, GAME_DATA.rules, level, ATLASES);
  }
}

function engineFor(level: LevelDefinition): GameEngine {
  return createGameEngine(createGameDefinition(GAME_DATA.rules, level, ATLASES));
}

function currentLevelNumber(): number {
  return currentLevelIndex + 1;
}

function nextLevelCaption(): string {
  return NEXT_LEVEL_CAPTIONS[currentLevelIndex] ?? `Level ${currentLevelNumber() + 1}`;
}

function sceneTitleForCurrentRoute(): string {
  if (route === "title") return "Rooster title screen";
  if (route === "loading") return "Loading Rooster";
  if (route === "loadError") return "Rooster loading error";
  if (route === "nextLevel") return `Level ${currentLevelNumber()} complete`;
  if (route === "finale") return "Golden Rooster finale";
  if (route === "results") return "Campaign results";
  if (gameState?.suspension !== null) return `Level ${currentLevelNumber()} paused`;
  return `Rooster gameplay, level ${currentLevelNumber()} of ${LEVELS.length}`;
}

function requestedStartLevelIndex(): number {
  const value = new URLSearchParams(window.location.search).get("level");
  if (value === null || !/^\d+$/.test(value)) return 0;
  const level = Number(value);
  return Number.isInteger(level) && level >= 1 && level <= LEVELS.length ? level - 1 : 0;
}

function createRunSeed(): number {
  const requestedSeed = new URLSearchParams(window.location.search).get("seed");
  if (requestedSeed !== null && /^(?:0x[\da-f]+|\d+)$/i.test(requestedSeed)) {
    const parsed = Number(requestedSeed);
    if (Number.isSafeInteger(parsed)) {
      const normalized = parsed >>> 0;
      if (normalized !== 0) return normalized;
    }
  }

  const value = new Uint32Array(1);
  crypto.getRandomValues(value);
  return value[0] === 0 || value[0] === undefined ? 0x6d2b79f5 : value[0];
}

function playtestSnapshot(): PlaytestSnapshot {
  return {
    route,
    level: currentLevelNumber(),
    score: gameState?.score ?? 0,
    spareLives: gameState?.spareLives ?? 0,
    trafficRemaining: gameState?.trafficRemaining ?? 0,
    phase: gameState?.phase ?? null,
  };
}

function installPlaytestApi(): void {
  if (!import.meta.env.DEV) return;
  window.__ROOSTER_PLAYTEST__ = Object.freeze({
    completeLevel: () => {
      if (route !== "run" || gameState === null) return playtestSnapshot();
      gameState.player.y = 0;
      for (const vehicle of gameState.traffic) vehicle.active = false;
      applyResult(engine.step(gameState, EMPTY_INPUT));
      for (
        let tick = 0;
        tick < engine.definition.rules.transitions.terminalTicks && route === "run";
        tick += 1
      ) {
        if (gameState === null) break;
        applyResult(engine.step(gameState, EMPTY_INPUT));
      }
      updateStatus();
      syncControls();
      return playtestSnapshot();
    },
    continue: () => {
      activateDefaultAction();
      return playtestSnapshot();
    },
    setCampaignTotals: (score: number, spareLives: number) => {
      if (gameState !== null) {
        gameState.score = Math.max(0, Math.trunc(score));
        gameState.spareLives = Math.max(-1, Math.trunc(spareLives));
        updateStatus();
        syncControls();
      }
      return playtestSnapshot();
    },
    snapshot: playtestSnapshot,
  });
}
