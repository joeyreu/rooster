import type { GameState } from "./types";

/** Explicit clone keeps the core portable and makes step free of caller-visible mutation. */
export function cloneGameState(state: GameState): GameState {
  return {
    ...state,
    rngStates: { ...state.rngStates },
    player: { ...state.player },
    traffic: state.traffic.map((vehicle) => ({ ...vehicle })),
    inactiveTrafficIds: [...state.inactiveTrafficIds],
    obstacles: state.obstacles.map((obstacle) => ({
      ...obstacle,
      collision: { ...obstacle.collision },
    })),
    pickups: state.pickups.map((pickup) => ({ ...pickup })),
    pickupMessages: state.pickupMessages.map((message) => ({ ...message })),
    deadMarkers: state.deadMarkers.map((marker) => ({ ...marker })),
    timers: { ...state.timers },
    suspension: state.suspension === null ? null : { ...state.suspension },
    result: state.result === null ? null : { ...state.result },
  };
}
