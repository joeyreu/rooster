import { describe, expect, it } from "vitest";
import { deriveRngStates, nextU32, randomInt } from "../../src/core";
import { makeDefinition } from "./core-test-support";

describe("portable xorshift32", () => {
  it("matches the specified unsigned sequence", () => {
    let state = 1;
    const values: number[] = [];
    for (let index = 0; index < 5; index += 1) {
      state = nextU32(state);
      values.push(state);
    }
    expect(values).toEqual([270369, 67634689, 2647435461, 307599695, 2398689233]);
  });

  it("derives isolated nonzero streams", () => {
    const definition = makeDefinition();
    const seed = 0xa341316c;
    expect(deriveRngStates(seed, definition.rules)).toEqual({
      traffic: 0x6d2b79f5,
      obstacles: (seed ^ 0xc8013ea4) >>> 0,
      pickups: (seed ^ 0xad90777d) >>> 0,
    });
  });

  it("returns values inside the requested half-open interval", () => {
    let state = 0x12345678;
    for (let iteration = 0; iteration < 1_000; iteration += 1) {
      const result = randomInt(state, 7);
      expect(result.value).toBeGreaterThanOrEqual(0);
      expect(result.value).toBeLessThan(7);
      state = result.state;
    }
  });

  it("rejects a zero or out-of-range seed", () => {
    const definition = makeDefinition();
    expect(() => deriveRngStates(0, definition.rules)).toThrow(/nonzero/);
    expect(() => deriveRngStates(0x1_0000_0000, definition.rules)).toThrow(/32-bit/);
  });
});
