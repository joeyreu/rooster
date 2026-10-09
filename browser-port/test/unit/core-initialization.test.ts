import { describe, expect, it } from "vitest";
import {
  createGameEngine,
  deriveRngStates,
  nextU32,
  type RunContinuation,
} from "../../src/core";
import { makeDefinition } from "./core-test-support";

describe("run initialization", () => {
  it("performs exactly 240 traffic warm-up updates and then restores the counter", () => {
    const definition = makeDefinition({ warmupTicks: 240, trafficSpawnPercent: 0 });
    const seed = 0x12345678;
    const initialTrafficRng = deriveRngStates(seed, definition.rules).traffic;
    let expectedTrafficRng = initialTrafficRng;
    for (let tick = 0; tick < 240; tick += 1) {
      expectedTrafficRng = nextU32(expectedTrafficRng);
    }

    const state = createGameEngine(definition).createRun(seed);
    expect(state.rngStates.traffic).toBe(expectedTrafficRng);
    expect(state.trafficRemaining).toBe(60);
    expect(state.tick).toBe(0);
  });

  it("creates a 70-item FIFO pool with cycling recovered frame widths", () => {
    const state = createGameEngine(makeDefinition()).createRun(7);
    expect(state.traffic).toHaveLength(70);
    expect(state.inactiveTrafficIds).toEqual(Array.from({ length: 70 }, (_, id) => id));
    expect(state.traffic.slice(0, 12).map(({ width }) => width)).toEqual([
      34, 35, 26, 27, 25, 27, 27, 28, 67, 63, 34, 35,
    ]);
  });

  it("uses three obstacle RNG calls per attempt and cycles types only on success", () => {
    const definition = makeDefinition({ obstaclePlacementAttempts: 20 });
    const seed = 0x98765432;
    let expected = deriveRngStates(seed, definition.rules).obstacles;
    for (let call = 0; call < 60; call += 1) {
      expected = nextU32(expected);
    }
    const state = createGameEngine(definition).createRun(seed);

    expect(state.rngStates.obstacles).toBe(expected);
    expect(state.obstacles.length).toBeLessThanOrEqual(20);
    expect(state.obstacles.map(({ type }) => type)).toEqual(
      state.obstacles.map((_, index) => [1, 2, 0][index % 3]),
    );
    for (const obstacle of state.obstacles) {
      expect(definition.level.laneSpeeds[obstacle.rowIndex]).toBe(0);
      if (obstacle.rowIndex >= definition.level.tileRows.length - 2) {
        expect(obstacle.x < 101 || obstacle.x > 139).toBe(true);
      }
    }
  });

  it("initializes pickup streams independently in gray, orange, purple order", () => {
    const definition = makeDefinition({
      pickupPresence: { gray: 100, orange: 100, purple: 100 },
    });
    const state = createGameEngine(definition).createRun(42);
    expect(state.pickups.map(({ kind }) => kind)).toEqual(["gray", "orange", "purple"]);
    expect(state.pickups.every(({ present }) => present)).toBe(true);
    const purple = state.pickups.find(({ kind }) => kind === "purple");
    expect(purple?.bonus).toBeGreaterThanOrEqual(10);
    expect(purple?.bonus).toBeLessThanOrEqual(20);
  });

  it("carries cumulative score, spare lives, and RNG streams into a new level", () => {
    const definition = makeDefinition({
      warmupTicks: 2,
      obstaclePlacementAttempts: 1,
    });
    const continuation: RunContinuation = {
      score: 137,
      spareLives: 4,
      rngStates: {
        traffic: 0x1020_3040,
        obstacles: 0x5060_7080,
        pickups: 0x90a0_b0c0,
      },
    };

    const state = createGameEngine(definition).createRun(99, continuation);

    expect(state.score).toBe(137);
    expect(state.spareLives).toBe(4);
    expect(state.rngStates).toEqual({
      traffic: nextU32(nextU32(continuation.rngStates.traffic)),
      obstacles: nextU32(nextU32(nextU32(continuation.rngStates.obstacles))),
      pickups: nextU32(nextU32(nextU32(continuation.rngStates.pickups))),
    });
    expect(state.rngStates).not.toBe(continuation.rngStates);
  });

  it("resets level-local state and boosted speed when continuing", () => {
    const definition = makeDefinition({ trafficSpawnPercent: 100 });
    const continuation: RunContinuation = {
      score: 25,
      spareLives: 0,
      rngStates: deriveRngStates(123, definition.rules),
    };

    const state = createGameEngine(definition).createRun(123, continuation);

    expect(state).toMatchObject({
      route: "run",
      phase: "playing",
      tick: 0,
      score: 25,
      spareLives: 0,
      trafficRemaining: definition.level.initialTrafficRemaining,
      pickupMessages: [],
      deadMarkers: [],
      result: null,
      timers: { phaseElapsedTicks: 0 },
    });
    expect(state.player).toMatchObject({
      x: definition.rules.player.spawnX,
      speed: definition.rules.player.normalSpeed,
      visible: true,
      facing: "up",
      animationStep: 0,
      inputLockedUntilRelease: false,
    });
  });
});
