import type { GameDefinition, PickupKind } from "../../src/core";

interface DefinitionOptions {
  trafficSpawnPercent?: number;
  warmupTicks?: number;
  obstaclePlacementAttempts?: number;
  pickupPresence?: Partial<Record<PickupKind, number>>;
  laneSpeeds?: readonly number[];
  tileRows?: readonly number[];
  terminalTicks?: number;
  deathHoldTicks?: number;
}

export function makeDefinition(options: DefinitionOptions = {}): GameDefinition {
  const tileRows = options.tileRows ?? [4, 4, 1, 3, 4, 4, 1, 3, 4, 4, 4];
  const laneSpeeds = options.laneSpeeds ?? [0, 0, 1, -3, 0, 0, 3, -1, 0, 0, 0];
  const chance = (kind: PickupKind): number => options.pickupPresence?.[kind] ?? 0;

  return {
    version: 1,
    level: {
      id: "level-1",
      displayNumber: 1,
      tileRows,
      laneSpeeds,
      trafficSpawnPercent: options.trafficSpawnPercent ?? 0,
      obstaclePlacementAttempts: options.obstaclePlacementAttempts ?? 0,
      initialTrafficRemaining: 60,
      drawObstaclesAboveActors: true,
    },
    rules: {
      tickMilliseconds: 60,
      viewport: { width: 240, height: 160 },
      rowHeight: 15,
      camera: { followY: 80 },
      player: {
        size: { width: 25, height: 25 },
        collision: { x: 10, y: 10, width: 5, height: 5 },
        spawnX: 120,
        normalSpeed: 2,
        boostedSpeed: 4,
        initialSpareLives: 2,
      },
      traffic: {
        poolSize: 70,
        warmupTicks: options.warmupTicks ?? 0,
        height: 18,
        collisionInsets: { left: 1, top: 1, right: 2, bottom: 6 },
      },
      obstacles: {
        maxPerRow: 10,
        typeCycle: [1, 2, 0],
        startCorridor: { minX: 101, maxX: 139, bottomRowCount: 2 },
        yOffset: { min: -6, max: -1 },
      },
      pickups: {
        size: { width: 15, height: 15 },
        rules: [
          {
            kind: "gray",
            presencePercent: chance("gray"),
            frameCount: 9,
            message: "Free Bird",
          },
          {
            kind: "orange",
            presencePercent: chance("orange"),
            frameCount: 9,
            message: "Speed x2",
          },
          {
            kind: "purple",
            presencePercent: chance("purple"),
            frameCount: 9,
            message: "Countdown +NN",
          },
        ],
        placement: { minX: 20, maxX: 219, minY: 15, bottomMargin: 16 },
        animationAdvancesPerTick: 2,
        initializationOrder: ["gray", "orange", "purple"],
        collectionOrder: ["gray", "purple", "orange"],
        purpleBonus: { min: 10, max: 20 },
      },
      transitions: {
        deathHoldTicks: options.deathHoldTicks ?? 15,
        terminalTicks: options.terminalTicks ?? 50,
        cameraPanPixelsPerTick: 4,
        pickupMessageTicks: 20,
        deathVibrationMilliseconds: 500,
      },
      rng: {
        trafficXor: 0xa341316c,
        obstaclesXor: 0xc8013ea4,
        pickupsXor: 0xad90777d,
        zeroStateFallback: 0x6d2b79f5,
      },
    },
    trafficFrameWidths: [34, 35, 26, 27, 25, 27, 27, 28, 67, 63],
    obstacleFrames: [
      {
        type: 0,
        width: 15,
        height: 15,
        collision: { x: 3, y: 3, width: 8, height: 8 },
      },
      {
        type: 1,
        width: 15,
        height: 15,
        collision: { x: 3, y: 3, width: 8, height: 8 },
      },
      {
        type: 2,
        width: 30,
        height: 30,
        collision: { x: 9, y: 6, width: 11, height: 13 },
      },
    ],
  };
}
