import type { GameDefinition, RngStates } from "./types";

export const UINT32_RANGE = 4_294_967_296;

export interface RandomResult {
  value: number;
  state: number;
}

/** One portable xorshift32 step, with every operation forced to uint32. */
export function nextU32(state: number): number {
  let next = state >>> 0;
  next ^= next << 13;
  next ^= next >>> 17;
  next ^= next << 5;
  return next >>> 0;
}

export function randomInt(state: number, maxExclusive: number): RandomResult {
  if (!Number.isSafeInteger(maxExclusive) || maxExclusive <= 0) {
    throw new RangeError("maxExclusive must be a positive safe integer");
  }

  const nextState = nextU32(state);
  return {
    value: Math.floor((nextState / UINT32_RANGE) * maxExclusive),
    state: nextState,
  };
}

export function randomIntInclusive(
  state: number,
  minInclusive: number,
  maxInclusive: number,
): RandomResult {
  if (!Number.isSafeInteger(minInclusive) || !Number.isSafeInteger(maxInclusive)) {
    throw new RangeError("random integer bounds must be safe integers");
  }
  if (maxInclusive < minInclusive) {
    throw new RangeError("maxInclusive must be at least minInclusive");
  }

  const result = randomInt(state, maxInclusive - minInclusive + 1);
  return { value: minInclusive + result.value, state: result.state };
}

function deriveStream(runSeed: number, xorConstant: number, fallback: number): number {
  const derived = ((runSeed >>> 0) ^ (xorConstant >>> 0)) >>> 0;
  return derived === 0 ? fallback >>> 0 : derived;
}

export function deriveRngStates(
  runSeed: number,
  rules: GameDefinition["rules"],
): RngStates {
  if (!Number.isSafeInteger(runSeed) || runSeed < 0 || runSeed > 0xffff_ffff) {
    throw new RangeError("runSeed must be an unsigned 32-bit integer");
  }
  if (runSeed === 0) {
    throw new RangeError("runSeed must be nonzero");
  }

  const { rng } = rules;
  return {
    traffic: deriveStream(runSeed, rng.trafficXor, rng.zeroStateFallback),
    obstacles: deriveStream(runSeed, rng.obstaclesXor, rng.zeroStateFallback),
    pickups: deriveStream(runSeed, rng.pickupsXor, rng.zeroStateFallback),
  };
}
