import { cloneGameState } from "./clone";
import { overlapsInclusive } from "./collision";
import { assertValidGameDefinition } from "./config";
import { createInitialState } from "./initialization";
import { resolveDirection } from "./input";
import {
  movePlayer,
  panCameraTowardStart,
  playerCollisionRect,
  startingCameraY,
  updatePlayingCamera,
} from "./systems/movement";
import {
  advancePickupAnimation,
  advancePickupMessages,
  collectOverlappingPickups,
} from "./systems/pickups";
import { advanceTraffic, trafficCollisionRect } from "./systems/traffic";
import type {
  DeathCause,
  GameDefinition,
  GameEngine,
  GameEvent,
  GameState,
  InputSnapshot,
  RunContinuation,
  StepResult,
  SuspensionReason,
} from "./types";

function hasTrafficCollision(definition: GameDefinition, state: GameState): boolean {
  if (!state.player.visible) {
    return false;
  }
  const playerRect = playerCollisionRect(definition, state.player);
  return state.traffic.some(
    (vehicle) =>
      vehicle.active &&
      overlapsInclusive(playerRect, trafficCollisionRect(definition, vehicle)),
  );
}

function enterDeath(
  definition: GameDefinition,
  state: GameState,
  cause: DeathCause,
  events: GameEvent[],
): void {
  state.deadMarkers.push({
    x: state.player.x,
    y: state.player.y,
    cause,
    tick: state.tick,
  });
  state.player.visible = false;
  state.player.speed = definition.rules.player.normalSpeed;
  state.player.inputLockedUntilRelease = true;
  state.spareLives -= 1;
  state.trafficRemaining = definition.level.initialTrafficRemaining;
  state.lastDeathCause = cause;
  state.phase = state.spareLives < 0 ? "gameOver" : "dying";
  state.timers.phaseElapsedTicks = 0;

  events.push({ type: "playerDied", cause, spareLives: state.spareLives });
  events.push({
    type: "vibrationRequested",
    milliseconds: definition.rules.transitions.deathVibrationMilliseconds,
  });
  events.push({ type: "clearInputRequested" });
}

function resetPlayerForRespawn(definition: GameDefinition, state: GameState): void {
  const worldHeight = definition.level.tileRows.length * definition.rules.rowHeight;
  state.player.x = definition.rules.player.spawnX;
  state.player.y = worldHeight - definition.rules.player.size.height;
  state.player.speed = definition.rules.player.normalSpeed;
  state.player.visible = true;
  state.player.facing = "up";
  state.player.animationStep = 0;
  state.player.inputLockedUntilRelease = true;
  state.cameraY = startingCameraY(definition);
  state.phase = "playing";
  state.timers.phaseElapsedTicks = 0;
  state.lastDeathCause = null;
}

function finishRun(
  state: GameState,
  outcome: "win" | "loss",
  events: GameEvent[],
): void {
  if (outcome === "win") {
    state.score += state.trafficRemaining;
  }
  state.result = { outcome, finalScore: state.score };
  state.route = "results";
  state.phase = null;
  state.suspension = null;
  events.push({ type: "scoreFinalized", outcome, finalScore: state.score });
  events.push({ type: "resultsReady", outcome, finalScore: state.score });
}

function progressExistingPhase(
  definition: GameDefinition,
  state: GameState,
  phaseAtStart: GameState["phase"],
  events: GameEvent[],
): void {
  if (state.phase !== phaseAtStart) {
    return;
  }

  switch (phaseAtStart) {
    case "playing":
    case null:
      return;
    case "dying": {
      const holdTicks = definition.rules.transitions.deathHoldTicks;
      if (state.timers.phaseElapsedTicks < holdTicks) {
        state.timers.phaseElapsedTicks += 1;
      }
      if (state.timers.phaseElapsedTicks < holdTicks) {
        return;
      }
      if (panCameraTowardStart(definition, state)) {
        resetPlayerForRespawn(definition, state);
        events.push({ type: "playerRespawned" });
        events.push({ type: "clearInputRequested" });
      }
      return;
    }
    case "levelComplete":
    case "gameOver":
      state.timers.phaseElapsedTicks += 1;
      if (state.timers.phaseElapsedTicks >= definition.rules.transitions.terminalTicks) {
        finishRun(state, phaseAtStart === "levelComplete" ? "win" : "loss", events);
      }
  }
}

export function stepGame(
  definition: GameDefinition,
  previousState: GameState,
  input: InputSnapshot,
): StepResult {
  if (
    previousState.route !== "run" ||
    previousState.phase === null ||
    previousState.suspension !== null
  ) {
    return { state: previousState, events: [] };
  }

  const state = cloneGameState(previousState);
  const events: GameEvent[] = [];
  const phaseAtStart = state.phase;
  let direction = resolveDirection(input);
  if (state.player.inputLockedUntilRelease) {
    if (direction === null) {
      state.player.inputLockedUntilRelease = false;
    } else {
      direction = null;
    }
  }

  advancePickupAnimation(
    state.pickups,
    definition.rules.pickups.animationAdvancesPerTick,
  );
  if (phaseAtStart === "playing") {
    collectOverlappingPickups(definition, state, events);
    movePlayer(definition, state, direction);
  }

  const spawned = advanceTraffic(definition, state);
  if (phaseAtStart === "playing" && spawned) {
    state.trafficRemaining -= 1;
  }

  if (phaseAtStart === "playing") {
    const deathCause =
      state.trafficRemaining <= 0
        ? "counterZero"
        : hasTrafficCollision(definition, state)
          ? "traffic"
          : null;
    if (deathCause !== null) {
      enterDeath(definition, state, deathCause, events);
    } else if (state.player.y <= 0) {
      state.phase = "levelComplete";
      state.timers.phaseElapsedTicks = 0;
      events.push({ type: "levelCompleted", trafficRemaining: state.trafficRemaining });
    }
  }

  progressExistingPhase(definition, state, phaseAtStart, events);
  if (state.phase === "playing") {
    updatePlayingCamera(definition, state);
  }
  state.pickupMessages = advancePickupMessages(state.pickupMessages);
  state.tick += 1;
  return { state, events };
}

export function suspendGame(
  previousState: GameState,
  reason: SuspensionReason,
): StepResult {
  if (
    previousState.route !== "run" ||
    previousState.phase === null ||
    previousState.suspension !== null
  ) {
    return { state: previousState, events: [] };
  }

  const resumePhase = previousState.phase;
  const state = cloneGameState(previousState);
  state.suspension = { reason, resumePhase };
  state.player.inputLockedUntilRelease = true;
  return {
    state,
    events: [
      { type: "suspended", reason, resumePhase },
      { type: "clearInputRequested" },
    ],
  };
}

export function resumeGame(previousState: GameState): StepResult {
  if (previousState.suspension === null) {
    return { state: previousState, events: [] };
  }

  const state = cloneGameState(previousState);
  const phase = state.suspension?.resumePhase;
  if (phase === undefined) {
    return { state: previousState, events: [] };
  }
  state.phase = phase;
  state.suspension = null;
  state.player.inputLockedUntilRelease = true;
  return {
    state,
    events: [{ type: "resumed", phase }, { type: "clearInputRequested" }],
  };
}

export function createGameEngine(definition: GameDefinition): GameEngine {
  assertValidGameDefinition(definition);
  return Object.freeze({
    definition,
    createRun: (runSeed: number, continuation?: RunContinuation) =>
      createInitialState(definition, runSeed, continuation),
    step: (state: GameState, input: InputSnapshot) => stepGame(definition, state, input),
    suspend: (state: GameState, reason: SuspensionReason) => suspendGame(state, reason),
    resume: (state: GameState) => resumeGame(state),
  });
}
