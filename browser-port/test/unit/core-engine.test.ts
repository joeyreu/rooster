import { describe, expect, it } from "vitest";
import {
  createGameEngine,
  directionInput,
  EMPTY_INPUT,
  nextU32,
  type GameEngine,
  type GameEvent,
  type GameState,
  type PickupKind,
} from "../../src/core";
import { makeDefinition } from "./core-test-support";

function stepTimes(engine: GameEngine, initial: GameState, count: number): GameState {
  let state = initial;
  for (let index = 0; index < count; index += 1) {
    state = engine.step(state, EMPTY_INPUT).state;
  }
  return state;
}

function overlapPickup(state: GameState, kind: PickupKind, bonus = 0): void {
  const pickup = state.pickups.find((candidate) => candidate.kind === kind);
  if (pickup === undefined) {
    throw new Error(`missing ${kind} pickup`);
  }
  pickup.present = true;
  pickup.consumed = false;
  pickup.x = state.player.x + 10;
  pickup.y = state.player.y + 10;
  pickup.bonus = bonus;
}

function forceTrafficCollision(state: GameState): void {
  const vehicle = state.traffic[0];
  if (vehicle === undefined) {
    throw new Error("missing traffic vehicle");
  }
  vehicle.active = true;
  vehicle.x = state.player.x + 9;
  vehicle.y = state.player.y + 9;
  vehicle.laneIndex = 2;
  vehicle.speed = 0;
  vehicle.spawnSequence = state.nextTrafficSpawnSequence;
  state.nextTrafficSpawnSequence += 1;
  state.inactiveTrafficIds = state.inactiveTrafficIds.filter((id) => id !== vehicle.id);
}

function eventTypes(events: readonly GameEvent[]): string[] {
  return events.map(({ type }) => type);
}

describe("authoritative game step", () => {
  it("moves exactly 20 pixels in ten normal-speed ticks without mutating prior states", () => {
    const engine = createGameEngine(makeDefinition());
    const initial = engine.createRun(1);
    let state = initial;
    for (let tick = 0; tick < 10; tick += 1) {
      state = engine.step(state, directionInput("up")).state;
    }

    expect(initial.player.y).toBe(140);
    expect(state.player.y).toBe(120);
    expect(state.player.x).toBe(120);
  });

  it("chooses one cardinal direction and clamps the sprite to world bounds", () => {
    const engine = createGameEngine(makeDefinition());
    let state = engine.createRun(2);
    state.player.x = 214;
    state.player.y = 1;
    state = engine.step(
      state,
      {
        heldDirections: [
          { sourceId: "up", direction: "up", pressedOrder: 1 },
          { sourceId: "right", direction: "right", pressedOrder: 2 },
        ],
      },
    ).state;
    expect({ x: state.player.x, y: state.player.y }).toEqual({ x: 215, y: 1 });
  });

  it("rolls back the complete attempted movement on an obstacle", () => {
    const engine = createGameEngine(makeDefinition());
    const state = engine.createRun(3);
    state.obstacles = [
      {
        id: 0,
        rowIndex: 10,
        type: 0,
        x: 127,
        y: 145,
        width: 15,
        height: 15,
        collision: { x: 3, y: 3, width: 8, height: 8 },
      },
    ];
    const result = engine.step(state, directionInput("up"));
    expect(result.state.player.y).toBe(140);
    expect(result.state.phase).toBe("playing");
  });

  it("decrements the counter only for an accepted spawn and moves it immediately", () => {
    const definition = makeDefinition({ trafficSpawnPercent: 100 });
    const engine = createGameEngine(definition);
    const state = engine.createRun(4);
    const result = engine.step(state, EMPTY_INPUT);
    const vehicle = result.state.traffic.find(({ active }) => active);

    expect(result.state.trafficRemaining).toBe(59);
    expect(vehicle).toBeDefined();
    if (vehicle === undefined) {
      throw new Error("expected a spawned vehicle");
    }
    expect(vehicle.x).toBe(
      vehicle.speed > 0 ? -vehicle.width + vehicle.speed : 240 + vehicle.speed,
    );
  });

  it("consumes density and lane rolls but keeps the FIFO head on a rejected spawn", () => {
    const definition = makeDefinition({ trafficSpawnPercent: 100 });
    const engine = createGameEngine(definition);
    const state = engine.createRun(5);
    const head = state.inactiveTrafficIds[0];
    if (head === undefined) {
      throw new Error("missing inactive traffic");
    }

    // A wide blocker in every traffic lane covers both possible entry sides.
    for (const [id, lane] of [
      [66, 2],
      [67, 3],
      [68, 6],
      [69, 7],
    ] as const) {
      const blocker = state.traffic[id];
      if (blocker === undefined) {
        throw new Error("missing blocker");
      }
      blocker.active = true;
      blocker.x = -34;
      blocker.y = lane * 15;
      blocker.width = 300;
      blocker.laneIndex = lane;
      blocker.speed = 0;
      blocker.spawnSequence = id;
      state.inactiveTrafficIds = state.inactiveTrafficIds.filter((candidate) => candidate !== id);
    }

    const rngBefore = state.rngStates.traffic;
    const result = engine.step(state, EMPTY_INPUT).state;
    expect(result.inactiveTrafficIds[0]).toBe(head);
    expect(result.trafficRemaining).toBe(60);
    expect(result.rngStates.traffic).toBe(nextU32(nextU32(rngBefore)));
  });

  it("collects simultaneous pickups in gray, purple, orange order", () => {
    const engine = createGameEngine(makeDefinition());
    const state = engine.createRun(6);
    overlapPickup(state, "gray");
    overlapPickup(state, "purple", 17);
    overlapPickup(state, "orange");
    const pickupRng = state.rngStates.pickups;
    const result = engine.step(state, EMPTY_INPUT);
    const pickupEvents = result.events.filter(({ type }) => type === "pickupCollected");

    expect(pickupEvents.map((event) => (event.type === "pickupCollected" ? event.kind : null))).toEqual([
      "gray",
      "purple",
      "orange",
    ]);
    expect(result.state.spareLives).toBe(3);
    expect(result.state.trafficRemaining).toBe(77);
    expect(result.state.player.speed).toBe(4);
    expect(result.state.rngStates.pickups).toBe(pickupRng);
  });

  it("applies counter-zero death before traffic death and resets immediately", () => {
    const definition = makeDefinition({ trafficSpawnPercent: 100 });
    const engine = createGameEngine(definition);
    const state = engine.createRun(7);
    state.trafficRemaining = 1;
    forceTrafficCollision(state);
    const result = engine.step(state, EMPTY_INPUT);

    expect(result.state.phase).toBe("dying");
    expect(result.state.lastDeathCause).toBe("counterZero");
    expect(result.state.trafficRemaining).toBe(60);
    expect(result.state.spareLives).toBe(1);
    expect(eventTypes(result.events)).toEqual([
      "playerDied",
      "vibrationRequested",
      "clearInputRequested",
    ]);
  });

  it("keeps markers, traffic, score, and consumed pickups across respawn", () => {
    const engine = createGameEngine(makeDefinition());
    const state = engine.createRun(8);
    state.score = 9;
    overlapPickup(state, "orange");
    state.trafficRemaining = 0;
    const death = engine.step(state, EMPTY_INPUT).state;
    const activeBefore = death.traffic.filter(({ active }) => active).map(({ id }) => id);
    const respawned = stepTimes(engine, death, 15);

    expect(respawned.phase).toBe("playing");
    expect(respawned.player).toMatchObject({ x: 120, y: 140, speed: 2, visible: true });
    expect(respawned.deadMarkers).toHaveLength(1);
    expect(respawned.score).toBe(9);
    expect(respawned.pickups.find(({ kind }) => kind === "orange")?.consumed).toBe(true);
    expect(respawned.traffic.filter(({ active }) => active).map(({ id }) => id)).toEqual(activeBefore);
  });

  it("requires a neutral snapshot before movement resumes", () => {
    const engine = createGameEngine(makeDefinition());
    const state = engine.createRun(9);
    state.trafficRemaining = 0;
    let current = engine.step(state, EMPTY_INPUT).state;
    current = stepTimes(engine, current, 15);
    expect(current.phase).toBe("playing");

    current = engine.step(current, directionInput("up")).state;
    expect(current.player.y).toBe(140);
    current = engine.step(current, EMPTY_INPUT).state;
    current = engine.step(current, directionInput("up")).state;
    expect(current.player.y).toBe(138);
  });

  it("ends the third baseline attempt and finalizes loss after 50 later ticks", () => {
    const engine = createGameEngine(makeDefinition());
    let state = engine.createRun(10);
    for (let death = 0; death < 3; death += 1) {
      state.trafficRemaining = 0;
      const result = engine.step(state, EMPTY_INPUT);
      state = result.state;
      if (death < 2) {
        state = stepTimes(engine, state, 15);
      }
    }
    expect(state.phase).toBe("gameOver");
    expect(state.spareLives).toBe(-1);
    expect(state.trafficRemaining).toBe(60);
    expect(state.deadMarkers).toHaveLength(3);

    state = stepTimes(engine, state, 49);
    expect(state.route).toBe("run");
    const final = engine.step(state, EMPTY_INPUT);
    expect(final.state.route).toBe("results");
    expect(final.state.result).toEqual({ outcome: "loss", finalScore: 0 });
    expect(eventTypes(final.events).slice(-2)).toEqual(["scoreFinalized", "resultsReady"]);
  });

  it("lets a gray pickup add one complete extra attempt", () => {
    const engine = createGameEngine(makeDefinition());
    let state = engine.createRun(11);
    overlapPickup(state, "gray");
    state = engine.step(state, EMPTY_INPUT).state;
    expect(state.spareLives).toBe(3);

    for (let death = 0; death < 3; death += 1) {
      state.trafficRemaining = 0;
      state = engine.step(state, EMPTY_INPUT).state;
      state = stepTimes(engine, state, 15);
      expect(state.phase).toBe("playing");
    }
    state.trafficRemaining = 0;
    state = engine.step(state, EMPTY_INPUT).state;
    expect(state.phase).toBe("gameOver");
  });

  it("gives lethal traffic precedence over completion on the goal tick", () => {
    const engine = createGameEngine(makeDefinition());
    const state = engine.createRun(12);
    state.player.y = 2;
    forceTrafficCollision(state);
    const result = engine.step(state, directionInput("up"));
    expect(result.state.player.y).toBe(0);
    expect(result.state.phase).toBe("dying");
    expect(eventTypes(result.events)).not.toContain("levelCompleted");
  });

  it("holds completion for 50 subsequent ticks before awarding the remaining counter", () => {
    const engine = createGameEngine(makeDefinition());
    const state = engine.createRun(13);
    state.player.y = 2;
    state.trafficRemaining = 37;
    const completed = engine.step(state, directionInput("up"));
    expect(completed.state.phase).toBe("levelComplete");
    expect(completed.state.timers.phaseElapsedTicks).toBe(0);
    expect(eventTypes(completed.events)).toContain("levelCompleted");

    const after49 = stepTimes(engine, completed.state, 49);
    expect(after49.route).toBe("run");
    expect(after49.score).toBe(0);
    const finalized = engine.step(after49, EMPTY_INPUT);
    expect(finalized.state.route).toBe("results");
    expect(finalized.state.score).toBe(37);
    expect(finalized.state.result).toEqual({ outcome: "win", finalScore: 37 });
  });

  it("advances traffic in Dying without decrementing the reset counter", () => {
    const definition = makeDefinition({ trafficSpawnPercent: 100 });
    const engine = createGameEngine(definition);
    const state = engine.createRun(14);
    state.trafficRemaining = 0;
    const death = engine.step(state, EMPTY_INPUT).state;
    const next = engine.step(death, EMPTY_INPUT).state;
    expect(next.trafficRemaining).toBe(60);
    expect(next.rngStates.traffic).not.toBe(death.rngStates.traffic);
  });

  it("freezes every value while suspended and resumes the saved phase", () => {
    const engine = createGameEngine(makeDefinition());
    const initial = engine.createRun(15);
    const suspended = engine.suspend(initial, "hidden");
    expect(suspended.state.suspension).toEqual({ reason: "hidden", resumePhase: "playing" });
    expect(eventTypes(suspended.events)).toEqual(["suspended", "clearInputRequested"]);

    const attempted = engine.step(suspended.state, directionInput("up"));
    expect(attempted.state).toBe(suspended.state);
    expect(attempted.events).toEqual([]);
    const resumed = engine.resume(attempted.state);
    expect(resumed.state.phase).toBe("playing");
    expect(resumed.state.suspension).toBeNull();
  });
});
