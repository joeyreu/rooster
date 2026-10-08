import { describe, expect, it } from "vitest";
import { createGameDefinition, createGameEngine } from "../../src/core";
import { ATLASES, GAME_DATA, LEVEL_ONE } from "../../src/data";

describe("portable data adapter", () => {
  it("builds the Level 1 core definition entirely from checked-in data", () => {
    const definition = createGameDefinition(GAME_DATA.rules, LEVEL_ONE, ATLASES);

    expect(definition.level.tileRows).toEqual([4, 4, 1, 3, 4, 4, 1, 3, 4, 4, 4]);
    expect(definition.trafficFrameWidths).toEqual([34, 35, 26, 27, 25, 27, 27, 28, 67, 63]);
    expect(definition.obstacleFrames.map(({ type, width, height }) => ({ type, width, height }))).toEqual([
      { type: 0, width: 15, height: 15 },
      { type: 1, width: 15, height: 15 },
      { type: 2, width: 30, height: 30 },
    ]);
    expect(definition.rules.pickups.initializationOrder).toEqual(["gray", "orange", "purple"]);
    expect(definition.rules.pickups.collectionOrder).toEqual(["gray", "purple", "orange"]);
  });

  it("creates a deterministic, playable run from the portable data", () => {
    const definition = createGameDefinition(GAME_DATA.rules, LEVEL_ONE, ATLASES);
    const engine = createGameEngine(definition);
    const first = engine.createRun(0x12345678);
    const second = engine.createRun(0x12345678);

    expect(second).toEqual(first);
    expect(first.traffic).toHaveLength(70);
    expect(first.obstacles.length).toBeLessThanOrEqual(20);
    expect(first.trafficRemaining).toBe(60);
  });
});
