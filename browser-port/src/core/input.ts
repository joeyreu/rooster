import type { Direction, HeldDirection, InputSnapshot } from "./types";

export const EMPTY_INPUT: InputSnapshot = Object.freeze({ heldDirections: Object.freeze([]) });

export function directionInput(direction: Direction): InputSnapshot {
  return {
    heldDirections: [{ sourceId: `direct:${direction}`, direction, pressedOrder: 0 }],
  };
}

/**
 * Chooses the most recently pressed active source. Array order is a stable
 * tie-breaker, so a later source wins if an adapter supplies equal counters.
 */
export function resolveDirection(input: InputSnapshot): Direction | null {
  let winner: HeldDirection | null = null;

  for (const candidate of input.heldDirections) {
    if (winner === null || candidate.pressedOrder >= winner.pressedOrder) {
      winner = candidate;
    }
  }

  return winner?.direction ?? null;
}
