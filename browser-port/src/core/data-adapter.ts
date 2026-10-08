import { assertValidGameDefinition } from "./config";
import type {
  CollisionRect,
  GameDefinition,
  PickupKind,
  Size,
} from "./types";

interface PortablePickupDefinition {
  readonly id: "life" | "speed" | "counter";
  readonly atlasId: string;
  readonly presencePercent: number;
  readonly message: string;
  readonly bonus?: { readonly min: number; readonly max: number };
}

export interface PortableRulesDefinition {
  readonly tickMilliseconds: number;
  readonly viewport: Size;
  readonly rowHeight: number;
  readonly camera: {
    readonly followY: number;
    readonly respawnPanPixelsPerTick: number;
  };
  readonly player: Size & {
    readonly spawnX: number;
    readonly normalSpeed: number;
    readonly boostedSpeed: number;
    readonly initialSpareLives: number;
    readonly collision: CollisionRect;
  };
  readonly traffic: {
    readonly poolSize: number;
    readonly warmupTicks: number;
    readonly height: number;
    readonly collisionInsets: {
      readonly left: number;
      readonly top: number;
      readonly right: number;
      readonly bottom: number;
    };
  };
  readonly obstacles: {
    readonly maxPerRow: number;
    readonly typeCycle: readonly number[];
    readonly smallCollision: CollisionRect;
    readonly largeCollision: CollisionRect;
    readonly startCorridor: {
      readonly minX: number;
      readonly maxX: number;
      readonly bottomRowCount: number;
    };
    readonly yOffset: { readonly min: number; readonly max: number };
  };
  readonly pickups: readonly PortablePickupDefinition[];
  readonly pickupPlacement: Size & {
    readonly minX: number;
    readonly maxX: number;
    readonly minY: number;
    readonly bottomMargin: number;
    readonly messageTicks: number;
    readonly animationAdvancesPerTick: number;
    readonly initializationOrder: readonly PortablePickupDefinition["id"][];
    readonly collectionOrder: readonly PortablePickupDefinition["id"][];
  };
  readonly transitions: {
    readonly dyingHoldTicks: number;
    readonly terminalHoldTicks: number;
    readonly deathVibrationMilliseconds: number;
  };
  readonly rng: {
    readonly algorithm: "xorshift32";
    readonly zeroReplacement: number;
    readonly streamXor: {
      readonly traffic: number;
      readonly obstacles: number;
      readonly pickups: number;
    };
  };
}

export interface PortableLevelDefinition {
  readonly id: string;
  readonly displayNumber: number;
  readonly tileRows: readonly number[];
  readonly laneSpeeds: readonly number[];
  readonly trafficSpawnPercent: number;
  readonly obstaclePlacementAttempts: number;
  readonly initialTrafficRemaining: number;
  readonly drawObstaclesAboveActors: boolean;
  readonly assets: {
    readonly trafficAtlasId: string;
    readonly obstacleAtlasId: string;
  };
}

interface PortableAtlasFrame extends Size {
  readonly id: string;
}

export interface PortableAtlasDefinition {
  readonly id: string;
  readonly frames: readonly PortableAtlasFrame[];
  readonly groups: Readonly<Record<string, readonly string[]>>;
}

export type PortableAtlasCollection =
  | readonly PortableAtlasDefinition[]
  | Readonly<Record<string, PortableAtlasDefinition>>;

function atlasFrom(
  atlases: PortableAtlasCollection,
  atlasId: string,
): PortableAtlasDefinition {
  const atlas = Array.isArray(atlases)
    ? atlases.find((candidate) => candidate.id === atlasId)
    : (atlases as Readonly<Record<string, PortableAtlasDefinition>>)[atlasId];
  if (atlas === undefined) {
    throw new TypeError(`missing atlas ${atlasId}`);
  }
  return atlas;
}

function orderedFrames(
  atlas: PortableAtlasDefinition,
  groupName: string,
): PortableAtlasFrame[] {
  const group = atlas.groups[groupName];
  if (group === undefined || group.length === 0) {
    throw new TypeError(`atlas ${atlas.id} is missing nonempty group ${groupName}`);
  }
  return group.map((frameId) => {
    const frame = atlas.frames.find(({ id }) => id === frameId);
    if (frame === undefined) {
      throw new TypeError(`atlas ${atlas.id} group ${groupName} refers to ${frameId}`);
    }
    return frame;
  });
}

function pickupKind(id: PortablePickupDefinition["id"]): PickupKind {
  switch (id) {
    case "life":
      return "gray";
    case "speed":
      return "orange";
    case "counter":
      return "purple";
  }
}

/** Convert validated portable JSON and atlas metadata to the compact core contract. */
export function createGameDefinition(
  rules: PortableRulesDefinition,
  level: PortableLevelDefinition,
  atlases: PortableAtlasCollection,
): GameDefinition {
  if (rules.rng.algorithm !== "xorshift32") {
    throw new TypeError(`unsupported RNG algorithm ${String(rules.rng.algorithm)}`);
  }

  const trafficAtlas = atlasFrom(atlases, level.assets.trafficAtlasId);
  const obstacleAtlas = atlasFrom(atlases, level.assets.obstacleAtlasId);
  const trafficFrames = orderedFrames(trafficAtlas, "poolCycle");
  const obstacleFrames = orderedFrames(obstacleAtlas, "typeIndex");
  const purple = rules.pickups.find(({ id }) => id === "counter");
  if (purple?.bonus === undefined) {
    throw new TypeError("counter pickup must define its bonus range");
  }

  const definition: GameDefinition = {
    version: 1,
    level: {
      id: level.id,
      displayNumber: level.displayNumber,
      tileRows: [...level.tileRows],
      laneSpeeds: [...level.laneSpeeds],
      trafficSpawnPercent: level.trafficSpawnPercent,
      obstaclePlacementAttempts: level.obstaclePlacementAttempts,
      initialTrafficRemaining: level.initialTrafficRemaining,
      drawObstaclesAboveActors: level.drawObstaclesAboveActors,
    },
    rules: {
      tickMilliseconds: rules.tickMilliseconds,
      viewport: { ...rules.viewport },
      rowHeight: rules.rowHeight,
      camera: { followY: rules.camera.followY },
      player: {
        size: { width: rules.player.width, height: rules.player.height },
        collision: { ...rules.player.collision },
        spawnX: rules.player.spawnX,
        normalSpeed: rules.player.normalSpeed,
        boostedSpeed: rules.player.boostedSpeed,
        initialSpareLives: rules.player.initialSpareLives,
      },
      traffic: {
        poolSize: rules.traffic.poolSize,
        warmupTicks: rules.traffic.warmupTicks,
        height: rules.traffic.height,
        collisionInsets: { ...rules.traffic.collisionInsets },
      },
      obstacles: {
        maxPerRow: rules.obstacles.maxPerRow,
        typeCycle: [...rules.obstacles.typeCycle],
        startCorridor: { ...rules.obstacles.startCorridor },
        yOffset: { ...rules.obstacles.yOffset },
      },
      pickups: {
        size: {
          width: rules.pickupPlacement.width,
          height: rules.pickupPlacement.height,
        },
        rules: rules.pickups.map((pickup) => ({
          kind: pickupKind(pickup.id),
          presencePercent: pickup.presencePercent,
          frameCount: orderedFrames(atlasFrom(atlases, pickup.atlasId), "animation").length,
          message: pickup.message,
        })),
        placement: {
          minX: rules.pickupPlacement.minX,
          maxX: rules.pickupPlacement.maxX,
          minY: rules.pickupPlacement.minY,
          bottomMargin: rules.pickupPlacement.bottomMargin,
        },
        animationAdvancesPerTick: rules.pickupPlacement.animationAdvancesPerTick,
        initializationOrder: rules.pickupPlacement.initializationOrder.map(pickupKind),
        collectionOrder: rules.pickupPlacement.collectionOrder.map(pickupKind),
        purpleBonus: { ...purple.bonus },
      },
      transitions: {
        deathHoldTicks: rules.transitions.dyingHoldTicks,
        terminalTicks: rules.transitions.terminalHoldTicks,
        cameraPanPixelsPerTick: rules.camera.respawnPanPixelsPerTick,
        pickupMessageTicks: rules.pickupPlacement.messageTicks,
        deathVibrationMilliseconds: rules.transitions.deathVibrationMilliseconds,
      },
      rng: {
        trafficXor: rules.rng.streamXor.traffic,
        obstaclesXor: rules.rng.streamXor.obstacles,
        pickupsXor: rules.rng.streamXor.pickups,
        zeroStateFallback: rules.rng.zeroReplacement,
      },
    },
    trafficFrameWidths: trafficFrames.map(({ width }) => width),
    obstacleFrames: obstacleFrames.map((frame, type) => ({
      type,
      width: frame.width,
      height: frame.height,
      collision: {
        ...(type === 2 ? rules.obstacles.largeCollision : rules.obstacles.smallCollision),
      },
    })),
  };

  assertValidGameDefinition(definition);
  return definition;
}
