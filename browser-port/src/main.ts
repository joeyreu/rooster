import "./styles/game.css";

import {
  createGameEngine,
  createGameDefinition,
  type GameEvent,
  type GameState,
  type StepResult,
  type SuspensionReason,
} from "./core";
import { StatusView } from "./app/status-view";
import { ATLASES, GAME_DATA, LEVEL_ONE, type AssetId } from "./data";
import { FixedStepClock } from "./platform/browser-clock";
import { BrowserHaptics } from "./platform/browser-haptics";
import { BrowserInput } from "./platform/browser-input";
import { BrowserSaveStore } from "./platform/browser-storage";
import { AssetLoadError, loadFirstPassAssets } from "./render/asset-loader";
import { CanvasRenderer, renderBoot } from "./render/canvas-renderer";
import { requiredElement, ScreenView, type ScreenAction } from "./screens/screen-view";

type AppRoute = "loading" | "loadError" | "title" | "run" | "results";

const canvas = requiredElement("game-canvas", HTMLCanvasElement);
const gameWrapper = requiredElement("game-wrapper");
const pauseButton = requiredElement("pause-button", HTMLButtonElement);
const controls = requiredElement("game-controls");
const vibrationToggle = requiredElement("vibration-toggle", HTMLInputElement);
const confirmDialog = requiredElement("confirm-dialog", HTMLDialogElement);
const directionButtons = [...document.querySelectorAll<HTMLButtonElement>("[data-direction]")];

const saveStore = new BrowserSaveStore();
const haptics = new BrowserHaptics(saveStore.value.settings.vibration);
const statusView = new StatusView();
const engine = createGameEngine(createGameDefinition(GAME_DATA.rules, LEVEL_ONE, ATLASES));

let route: AppRoute = "loading";
let gameState: GameState | null = null;
let renderer: CanvasRenderer | null = null;
let loadingProgress = { loaded: 0, total: 0 };
let loadingAssets = new Map<AssetId, HTMLImageElement>();
let scoreWasNewBest = false;
let assetLoadAttempt = 0;

const screenView = new ScreenView(handleScreenAction);
const input = new BrowserInput({
  wrapper: gameWrapper,
  directionButtons,
  hasRun: () => hasRun() && !confirmDialog.open,
  isMovementActive: () => isMovementActive(),
  onPauseToggle: () => togglePause(),
  onConfirm: () => activateDefaultAction(),
});

const clock = new FixedStepClock({
  tickMs: engine.definition.rules.tickMilliseconds,
  onStep: step,
  onRender: render,
});

pauseButton.addEventListener("click", togglePause);
canvas.addEventListener("pointerdown", () => {
  if (hasRun()) gameWrapper.focus({ preventScroll: true });
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
    renderer = new CanvasRenderer(canvas, assets, GAME_DATA.rules, LEVEL_ONE, ATLASES);
    route = "title";
    screenView.showTitle();
    statusView.announce("Rooster is ready. Start game.");
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
      startRun();
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
  if (route === "title") startRun();
  else if (route === "loadError") void beginLoading();
  else if (route === "results") startRun();
}

function startRun(): void {
  if (renderer === null) return;
  input.clear();
  scoreWasNewBest = false;
  gameState = engine.createRun(createRunSeed());
  route = "run";
  screenView.hide();
  clock.clearElapsed();
  updateStatus();
  syncControls();
  gameWrapper.focus();
  statusView.announce("Level 1 started. Reach the top.");
}

function showTitle(): void {
  input.clear();
  gameState = null;
  route = "title";
  scoreWasNewBest = false;
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
        announcements.push("Level completed.");
        break;
      case "scoreFinalized": {
        const previousBest = saveStore.value.bestScore;
        const saved = saveStore.recordScore(event.finalScore);
        scoreWasNewBest = event.finalScore > previousBest && saved.bestScore === event.finalScore;
        break;
      }
      case "resultsReady":
        route = "results";
        screenView.showResults({
          outcome: event.outcome,
          score: event.finalScore,
          bestScore: saveStore.value.bestScore,
          isNewBest: scoreWasNewBest,
        });
        announcements.push(
          event.outcome === "win"
            ? `Level complete. Score ${event.finalScore}.`
            : `Game over. Score ${event.finalScore}.`,
        );
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

  if (gameState !== null) {
    renderer.renderGame(gameState, gameState.suspension !== null);
  }
}

function updateStatus(): void {
  const save = saveStore.value;
  const state = gameState;
  statusView.update({
    score: state?.score ?? 0,
    trafficRemaining: state?.trafficRemaining ?? engine.definition.level.initialTrafficRemaining,
    spareLives: state?.spareLives ?? engine.definition.rules.player.initialSpareLives,
    bestScore: save.bestScore,
    objective: objectiveForCurrentState(),
  });
}

function objectiveForCurrentState(): string {
  if (route === "loading") return "Loading the recovered game.";
  if (route === "loadError") return "Retry loading the recovered artwork.";
  if (route === "title") return "Objective: cross every lane and reach the top.";
  if (route === "results") return "Run complete. Replay or return to the title.";
  if (gameState?.suspension !== null) return "Run paused.";
  if (gameState?.phase === "dying") return "Preparing another attempt.";
  if (gameState?.phase === "levelComplete") return "Level complete.";
  if (gameState?.phase === "gameOver") return "Game over.";
  return "Objective: cross every lane and reach the top.";
}

function syncControls(): void {
  const hasActiveRun = hasRun();
  const movementActive = isMovementActive();
  const suspended = gameState?.suspension !== null && gameState !== null;
  pauseButton.disabled = !hasActiveRun;
  pauseButton.hidden = suspended;
  pauseButton.textContent = "Pause";
  controls.dataset.runActive = String(hasActiveRun);
  for (const button of directionButtons) button.disabled = !movementActive;
  gameWrapper.dataset.route = route;
  gameWrapper.dataset.phase = gameState?.phase ?? "none";
  gameWrapper.dataset.suspended = String(suspended);
  gameWrapper.dataset.tick = String(gameState?.tick ?? 0);
  gameWrapper.dataset.playerX = String(gameState?.player.x ?? 0);
  gameWrapper.dataset.playerY = String(gameState?.player.y ?? 0);
  if (gameState === null) delete gameWrapper.dataset.runSeed;
  else gameWrapper.dataset.runSeed = String(gameState.runSeed);
}

function hasRun(): boolean {
  return route === "run" && gameState?.route === "run";
}

function isMovementActive(): boolean {
  return hasRun() && gameState?.suspension === null && gameState.phase === "playing";
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
