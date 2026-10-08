import { deriveRngStates } from "./rng";
import { startingCameraY } from "./systems/movement";
import { generateObstacles } from "./systems/obstacles";
import { generatePickups } from "./systems/pickups";
import { advanceTraffic, buildTrafficPool } from "./systems/traffic";
import type { GameDefinition, GameState } from "./types";

export function createInitialState(definition: GameDefinition, runSeed: number): GameState {
  let rngStates = deriveRngStates(runSeed, definition.rules);
  const generatedObstacles = generateObstacles(definition, rngStates);
  rngStates = generatedObstacles.rngStates;

  const { level, rules } = definition;
  const worldHeight = level.tileRows.length * rules.rowHeight;
  const traffic = buildTrafficPool(definition);
  const state: GameState = {
    version: 1,
    route: "run",
    phase: "playing",
    suspension: null,
    tick: 0,
    levelId: level.id,
    runSeed: runSeed >>> 0,
    rngStates,
    player: {
      x: rules.player.spawnX,
      y: worldHeight - rules.player.size.height,
      width: rules.player.size.width,
      height: rules.player.size.height,
      speed: rules.player.normalSpeed,
      visible: true,
      facing: "up",
      animationStep: 0,
      inputLockedUntilRelease: false,
    },
    traffic,
    inactiveTrafficIds: traffic.map(({ id }) => id),
    nextTrafficSpawnSequence: 0,
    obstacles: generatedObstacles.obstacles,
    pickups: [],
    pickupMessages: [],
    deadMarkers: [],
    spareLives: rules.player.initialSpareLives,
    trafficRemaining: level.initialTrafficRemaining,
    score: 0,
    cameraY: startingCameraY(definition),
    timers: { phaseElapsedTicks: 0 },
    lastDeathCause: null,
    result: null,
  };

  for (let tick = 0; tick < rules.traffic.warmupTicks; tick += 1) {
    advanceTraffic(definition, state);
  }
  state.trafficRemaining = level.initialTrafficRemaining;

  const generatedPickups = generatePickups(definition, state.rngStates);
  state.pickups = generatedPickups.pickups;
  state.rngStates = generatedPickups.rngStates;
  return state;
}
