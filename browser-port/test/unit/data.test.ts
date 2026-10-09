import Ajv2020 from "ajv/dist/2020.js";
import { describe, expect, it } from "vitest";

import schemaDocument from "../../game-data/v1/schema.json";
import {
  ASSET_CATALOG,
  ATLASES,
  GAME_DATA,
  LEVELS,
  LEVELS_BY_NUMBER,
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

  it("locks all twenty recovered row and lane definitions", () => {
    const tileRows = [
      [4, 4, 1, 3, 4, 4, 1, 3, 4, 4, 4],
      [4, 4, 1, 2, 3, 4, 4, 1, 2, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 4, 1, 2, 2, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 4, 1, 2, 2, 2, 3, 4, 4],
      [4, 4, 1, 3, 4, 1, 3, 4, 1, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 1, 3, 4, 1, 2, 2, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 1, 2, 2, 2, 2, 3, 4, 4],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4],
      [4, 4, 1, 3, 4, 1, 3, 4, 1, 3, 4, 1, 3, 4, 1, 3, 4, 4],
      [4, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 4],
      [4, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 1, 2, 2, 3, 4, 4],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1],
      [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2],
    ];
    const laneSpeeds = [
      [0, 0, 1, -3, 0, 0, 3, -1, 0, 0, 0],
      [0, 0, -1, -2, -3, 0, 0, 1, 3, 2, 0, 0, 0],
      [0, 0, -3, -1, -3, -1, 0, 0, 3, 1, 3, 1, 0, 0],
      [0, 0, -3, -2, -2, -3, 0, 0, 3, 3, 4, 3, 3, 0, 0],
      [0, 0, -2, 3, 0, 1, -3, 0, 4, -4, 0, 0],
      [0, 0, -1, -2, 3, 4, 0, -1, 2, 0, -1, -2, 3, 4, 0, 0],
      [0, 0, -2, -3, 4, 3, 0, -1, -3, 4, 1, 0, -4, -3, 4, 2, 0, 0],
      [0, 0, -2, -3, 4, 3, 0, -1, -3, 4, 1, 0, -4, -3, 4, -3, 4, 2, 0, 0],
      [0, 0, 4, -4, 1, -4, 0, -4, 3, 0, 4, -3, 4, 0, 0],
      [0, 0, 5, -4, 3, -3, 0, -1, 1, -1, 1, 0, 3, -4, 5, 0, 0],
      [0, 0, 5, -4, 4, -3, 2, -1, 0, -1, 1, 0, 1, -2, 3, 4, -5, 0, 0],
      [0, 0, 5, -4, 4, -3, 2, -1, 0, -1, 1, 6, 0, 1, -2, 3, 4, -5, 0, 0],
      [0, 0, -5, 5, 0, 5, -5, 0, 5, -5, 0, 5, -5, 0, 5, -5, 0, 0],
      [0, 0, -5, -6, 5, 0, -5, 6, 5, 0, -6, -1, 6, 0, -6, -1, 6, 0, 0],
      [0, 0, -6, -4, 4, 6, 0, -4, -6, 6, 4, 0, -4, -6, 4, 5, 0, -4, -6, 4, 5, 0, 0],
      [0, 0, -6, -4, 4, 6, 0, -4, -6, 6, 4, 0, -4, -6, 4, 5, 0, -4, -6, 4, 5, 0, 0],
      [0, 0, 7, -7, 3, -7, -7, 7, 0, 7, -7, 3, -7, -7, 7, 0, 0],
      [0, 0, 8, -6, 7, -5, -7, 8, 0, 3, -8, 7, -6, -3, 4, 0, 3, -8, 3, -6, -3, 4, 0, 0],
      [0, 0, 10, -9, 8, -7, 6, -6, 7, -8, 9, -10, 0, 10, -9, 8, -7, 6, -6, 7, -8, 9, -10, 0, 0],
      [0, 0, 10, -9, 10, -9, 10, -9, 10, -9, 10, -9, 0, 10, -9, 10, -9, 10, -9, 10, -9, 10, -9, 0, 12, -12, 12, -12, 12, 0],
    ];

    expect(LEVELS).toHaveLength(20);
    expect(LEVELS.map((level) => level.tileRows)).toEqual(tileRows);
    expect(LEVELS.map((level) => level.laneSpeeds)).toEqual(laneSpeeds);
    expect(LEVELS.map((level) => level.displayNumber)).toEqual(
      Array.from({ length: 20 }, (_, index) => index + 1),
    );
    expect(LEVELS.map((level) => level.id)).toEqual(
      Array.from({ length: 20 }, (_, index) => `level-${index + 1}`),
    );
    expect(LEVELS_BY_NUMBER[13]).toBe(LEVELS[12]);
    expect(LEVELS[1]?.laneSpeeds).toHaveLength(13);
    expect(LEVELS[1]?.tileRows).toHaveLength(12);
  });

  it("locks recovered campaign tuning and theme asset selection", () => {
    expect(LEVELS.map((level) => level.trafficSpawnPercent)).toEqual([
      6, 12, 13, 14, 15, 20, 25, 30, 25, 25, 25, 30, 30, 30, 35, 40, 40, 40, 50, 70,
    ]);
    expect(LEVELS.map((level) => level.obstaclePlacementAttempts)).toEqual([
      20, 20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 30, 30, 30, 30, 35, 35, 40, 40,
    ]);
    expect(LEVELS.map((level) => level.initialTrafficRemaining)).toEqual([
      60, 60, 70, 80, 80, 80, 100, 150, 110, 110, 120, 160, 120, 140, 150, 160, 160, 170, 180, 240,
    ]);
    expect(LEVELS.map((level) => level.drawObstaclesAboveActors)).toEqual([
      true, true, true, true, true, true, true, true,
      false, false, false, false,
      true, true, true, true,
      false, false, false, false,
    ]);
    expect(LEVELS.map((level) => level.themeId)).toEqual([
      ...Array(4).fill("grass"),
      ...Array(4).fill("desert"),
      ...Array(4).fill("water"),
      ...Array(4).fill("steel"),
      ...Array(4).fill("space"),
    ]);

    for (const level of LEVELS.slice(0, 4)) {
      expect(level.assets).toMatchObject({
        backgroundAtlasId: "background.grass",
        playerAtlasId: "player.rooster",
        deadPlayerAssetId: "player.roosterDead",
        trafficAtlasId: "traffic.cars",
        obstacleAtlasId: "obstacle.grass",
        hudDigitsAtlasId: "hud.digitsBlack",
      });
    }
    for (const level of LEVELS.slice(4, 8)) {
      expect(level.assets).toMatchObject({
        backgroundAtlasId: "background.desert",
        playerAtlasId: "player.rooster",
        deadPlayerAssetId: "player.roosterDead",
        trafficAtlasId: "traffic.cars",
        obstacleAtlasId: "obstacle.desert",
        hudDigitsAtlasId: "hud.digitsBlack",
      });
    }
    for (const level of LEVELS.slice(8, 12)) {
      expect(level.assets).toMatchObject({
        backgroundAtlasId: "background.water",
        playerAtlasId: "player.roosterBoat",
        deadPlayerAssetId: "player.roosterBoatDead",
        trafficAtlasId: "traffic.boats",
        obstacleAtlasId: "obstacle.water",
        hudDigitsAtlasId: "hud.digitsBlack",
      });
    }
    for (const [index, level] of LEVELS.slice(12, 16).entries()) {
      expect(level.assets).toMatchObject({
        backgroundAtlasId: "background.steel",
        playerAtlasId: "player.roosterTank",
        deadPlayerAssetId: "player.roosterTankDead",
        trafficAtlasId: index === 0 ? "traffic.mercLevel13" : "traffic.merc",
        obstacleAtlasId: "obstacle.metal",
        hudDigitsAtlasId: "hud.digitsBlack",
      });
    }
    for (const level of LEVELS.slice(16, 20)) {
      expect(level.assets).toMatchObject({
        backgroundAtlasId: "background.space",
        playerAtlasId: "player.roosterSpace",
        deadPlayerAssetId: "player.roosterSpaceDead",
        trafficAtlasId: "traffic.ships",
        obstacleAtlasId: "obstacle.space",
        hudDigitsAtlasId: "hud.digitsWhite",
      });
    }
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

  it("locks every recovered theme and traffic atlas", () => {
    for (const id of ["grass", "desert", "water", "steel", "space"]) {
      expect(ATLASES[`background.${id}`]?.frames).toEqual([
        { id: "tile-1", x: 0, y: 0, width: 240, height: 15 },
        { id: "tile-2", x: 0, y: 15, width: 240, height: 15 },
        { id: "tile-3", x: 0, y: 30, width: 240, height: 15 },
        { id: "tile-4", x: 0, y: 45, width: 240, height: 15 },
      ]);
    }

    for (const id of ["rooster", "roosterBoat", "roosterTank", "roosterSpace"]) {
      expect(ATLASES[`player.${id}`]?.frames).toHaveLength(12);
      expect(ATLASES[`player.${id}`]?.groups).toEqual({
        up: ["frame-1", "frame-0", "frame-2", "frame-0"],
        right: ["frame-4", "frame-3", "frame-5", "frame-3"],
        down: ["frame-7", "frame-6", "frame-8", "frame-6"],
        left: ["frame-10", "frame-9", "frame-11", "frame-9"],
      });
      expect(ATLASES[`player.${id}Dead`]?.frames).toEqual([
        { id: "dead", x: 0, y: 0, width: 25, height: 25 },
      ]);
    }

    const recoveredTrafficCrops: Record<string, readonly (readonly [number, number])[]> = {
      "traffic.cars": [
        [0, 34], [34, 35], [69, 26], [95, 27], [122, 25],
        [147, 27], [174, 27], [201, 28], [229, 67], [296, 63],
      ],
      "traffic.boats": [
        [0, 54], [54, 48], [102, 46], [148, 74], [222, 37], [259, 36], [295, 85],
      ],
      "traffic.mercLevel13": [
        [0, 45], [45, 32], [77, 18], [95, 24], [119, 20], [139, 15], [154, 61],
      ],
      "traffic.merc": [
        [0, 45], [45, 32], [77, 18], [95, 24], [119, 20], [139, 14], [153, 62],
      ],
      "traffic.ships": [
        [0, 25], [25, 24], [49, 25], [74, 45], [119, 18],
      ],
    };
    for (const [id, crops] of Object.entries(recoveredTrafficCrops)) {
      expect(ATLASES[id]?.frames.map(({ x, width }) => [x, width])).toEqual(crops);
      expect(ATLASES[id]?.directionalTransform).toEqual({
        positiveSpeed: "mirrorX",
        negativeSpeed: "source",
      });
    }

    for (const id of ["grass", "desert", "water", "metal", "space"]) {
      expect(ATLASES[`obstacle.${id}`]?.frames).toEqual([
        { id: "small-0", x: 0, y: 0, width: 15, height: 15 },
        { id: "small-1", x: 15, y: 0, width: 15, height: 15 },
        { id: "large-2", x: 0, y: 15, width: 30, height: 30 },
      ]);
    }
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
