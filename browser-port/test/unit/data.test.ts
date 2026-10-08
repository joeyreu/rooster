import Ajv2020 from "ajv/dist/2020.js";
import { describe, expect, it } from "vitest";

import schemaDocument from "../../game-data/v1/schema.json";
import {
  ASSET_CATALOG,
  ATLASES,
  GAME_DATA,
  LEVEL_ONE,
  validateGameData,
} from "../../src/data";

describe("portable game data", () => {
  it("loads as a valid version 1 bundle", () => {
    expect(validateGameData(GAME_DATA)).toEqual({ ok: true, issues: [] });
    expect(GAME_DATA.version).toBe(1);
  });

  it("conforms to the checked-in portable JSON Schema", () => {
    const validateSchema = new Ajv2020({ allErrors: true, strict: true }).compile(
      schemaDocument,
    );
    expect(validateSchema(GAME_DATA), JSON.stringify(validateSchema.errors)).toBe(true);
  });

  it("locks the recovered Level 1 configuration", () => {
    expect(LEVEL_ONE).toMatchObject({
      id: "level-1",
      displayNumber: 1,
      themeId: "grass",
      tileRows: [4, 4, 1, 3, 4, 4, 1, 3, 4, 4, 4],
      laneSpeeds: [0, 0, 1, -3, 0, 0, 3, -1, 0, 0, 0],
      trafficSpawnPercent: 6,
      obstaclePlacementAttempts: 20,
      initialTrafficRemaining: 60,
      drawObstaclesAboveActors: true,
    });
    expect(LEVEL_ONE.tileRows.length * GAME_DATA.rules.rowHeight).toBe(165);
  });

  it("locks player directions and the physical HUD digit ordering", () => {
    expect(ATLASES["player.rooster"]?.groups).toEqual({
      up: ["frame-1", "frame-0", "frame-2", "frame-0"],
      right: ["frame-4", "frame-3", "frame-5", "frame-3"],
      down: ["frame-7", "frame-6", "frame-8", "frame-6"],
      left: ["frame-10", "frame-9", "frame-11", "frame-9"],
    });

    const blackDigits = ATLASES["hud.digitsBlack"];
    expect(blackDigits?.frames.find((frame) => frame.id === "0")?.x).toBe(63);
    expect(blackDigits?.frames.find((frame) => frame.id === "1")?.x).toBe(0);
    expect(blackDigits?.frames.find((frame) => frame.id === "9")?.x).toBe(56);
    expect(ATLASES["traffic.cars"]?.directionalTransform).toEqual({
      positiveSpeed: "mirrorX",
      negativeSpeed: "source",
    });
  });

  it("locks the ten recovered Level 1 vehicle crops", () => {
    expect(
      ATLASES["traffic.cars"]?.frames.map(({ x, width }) => [x, width]),
    ).toEqual([
      [0, 34],
      [34, 35],
      [69, 26],
      [95, 27],
      [122, 25],
      [147, 27],
      [174, 27],
      [201, 28],
      [229, 67],
      [296, 63],
    ]);
  });

  it("resolves every atlas and Level 1 asset through the catalog", () => {
    for (const atlas of GAME_DATA.atlases) {
      const asset = ASSET_CATALOG[atlas.assetId as keyof typeof ASSET_CATALOG];
      expect(asset, atlas.assetId).toBeDefined();
      expect(asset?.width).toBe(atlas.sheet.width);
      expect(asset?.height).toBe(atlas.sheet.height);
    }

    expect(
      ASSET_CATALOG[
        LEVEL_ONE.assets.deadPlayerAssetId as keyof typeof ASSET_CATALOG
      ],
    ).toBeDefined();
  });

  it("rejects broken atlas references and out-of-sheet frames", () => {
    const invalid = JSON.parse(JSON.stringify(GAME_DATA));
    invalid.levels[0]!.assets.playerAtlasId = "missing.player";
    invalid.atlases[0]!.frames[0]!.width = 241;

    const result = validateGameData(invalid);
    expect(result.ok).toBe(false);
    if (!result.ok) {
      expect(result.issues).toEqual(
        expect.arrayContaining([
          expect.objectContaining({
            path: "/levels/0/assets/playerAtlasId",
          }),
          expect.objectContaining({ path: "/atlases/0/frames/0" }),
        ]),
      );
    }
  });

  it("rejects tile rows without frames and pickup assets from another atlas", () => {
    const invalid = JSON.parse(JSON.stringify(GAME_DATA));
    invalid.levels[0]!.tileRows[2] = 99;
    invalid.rules.pickups[0]!.assetId = "pickup.speed";

    const result = validateGameData(invalid);
    expect(result.ok).toBe(false);
    if (!result.ok) {
      expect(result.issues).toEqual(
        expect.arrayContaining([
          expect.objectContaining({
            path: "/levels/0/tileRows/2",
            message: "references missing background frame tile-99",
          }),
          expect.objectContaining({
            path: "/rules/pickups/0/assetId",
            message: "must match atlas pickup.life assetId pickup.life",
          }),
        ]),
      );
    }
  });

  it("rejects incomplete nested rules and invalid pickup discriminants", () => {
    const invalid = JSON.parse(JSON.stringify(GAME_DATA));
    invalid.rules.camera = {};
    invalid.rules.pickups[0]!.effect = "removeSpareLife";
    invalid.rules.rng.zeroReplacement = 0;

    const result = validateGameData(invalid);
    expect(result.ok).toBe(false);
    if (!result.ok) {
      expect(result.issues).toEqual(
        expect.arrayContaining([
          expect.objectContaining({ path: "/rules/camera/followY" }),
          expect.objectContaining({ path: "/rules/camera/respawnPanPixelsPerTick" }),
          expect.objectContaining({ path: "/rules/pickups/0/effect" }),
          expect.objectContaining({ path: "/rules/rng/zeroReplacement" }),
        ]),
      );
    }
  });

  it("allows preserved extra lane speeds but rejects a row without a speed", () => {
    const withHistoricalExtra = JSON.parse(JSON.stringify(GAME_DATA));
    withHistoricalExtra.levels[0]!.laneSpeeds.push(9);
    expect(validateGameData(withHistoricalExtra)).toEqual({ ok: true, issues: [] });

    const missingSpeed = JSON.parse(JSON.stringify(GAME_DATA));
    missingSpeed.levels[0]!.laneSpeeds.pop();
    const result = validateGameData(missingSpeed);
    expect(result.ok).toBe(false);
    if (!result.ok) {
      expect(result.issues).toEqual(
        expect.arrayContaining([
          expect.objectContaining({ path: "/levels/0/laneSpeeds" }),
        ]),
      );
    }
  });
});
