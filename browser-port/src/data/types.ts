export interface Size {
  readonly width: number;
  readonly height: number;
}

export interface Rectangle extends Size {
  readonly x: number;
  readonly y: number;
}

export interface PlayerRules extends Size {
  readonly spawnX: number;
  readonly normalSpeed: number;
  readonly boostedSpeed: number;
  readonly initialSpareLives: number;
  readonly collision: Rectangle;
}

export interface PickupDefinition {
  readonly id: "life" | "speed" | "counter";
  readonly assetId: string;
  readonly atlasId: string;
  readonly presencePercent: number;
  readonly effect:
    | "addSpareLife"
    | "setBoostedSpeed"
    | "addTrafficRemaining";
  readonly message: string;
  readonly bonus?: {
    readonly min: number;
    readonly max: number;
  };
}

export interface GameRules {
  readonly tickMilliseconds: number;
  readonly viewport: Size;
  readonly rowHeight: number;
  readonly camera: {
    readonly followY: number;
    readonly respawnPanPixelsPerTick: number;
  };
  readonly player: PlayerRules;
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
    readonly smallCollision: Rectangle;
    readonly largeCollision: Rectangle;
    readonly startCorridor: {
      readonly minX: number;
      readonly maxX: number;
      readonly bottomRowCount: number;
    };
    readonly yOffset: {
      readonly min: number;
      readonly max: number;
    };
  };
  readonly pickups: readonly PickupDefinition[];
  readonly pickupPlacement: Size & {
    readonly minX: number;
    readonly maxX: number;
    readonly minY: number;
    readonly bottomMargin: number;
    readonly messageTicks: number;
    readonly animationAdvancesPerTick: number;
    readonly initializationOrder: readonly PickupDefinition["id"][];
    readonly collectionOrder: readonly PickupDefinition["id"][];
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

export interface LevelDefinition {
  readonly id: string;
  readonly displayNumber: number;
  readonly themeId: string;
  readonly tileRows: readonly number[];
  readonly laneSpeeds: readonly number[];
  readonly trafficSpawnPercent: number;
  readonly obstaclePlacementAttempts: number;
  readonly initialTrafficRemaining: number;
  readonly drawObstaclesAboveActors: boolean;
  readonly assets: {
    readonly backgroundAtlasId: string;
    readonly playerAtlasId: string;
    readonly deadPlayerAssetId: string;
    readonly trafficAtlasId: string;
    readonly obstacleAtlasId: string;
    readonly hudDigitsAtlasId: string;
  };
}

export interface AtlasFrame extends Rectangle {
  readonly id: string;
}

export interface AtlasDefinition {
  readonly id: string;
  readonly assetId: string;
  readonly sheet: Size;
  readonly frames: readonly AtlasFrame[];
  readonly groups: Readonly<Record<string, readonly string[]>>;
  readonly directionalTransform?: {
    readonly positiveSpeed: "mirrorX";
    readonly negativeSpeed: "source";
  };
}

export interface GameDataV1 {
  readonly version: 1;
  readonly rules: GameRules;
  readonly levels: readonly LevelDefinition[];
  readonly atlases: readonly AtlasDefinition[];
}

export interface ValidationIssue {
  readonly path: string;
  readonly message: string;
}

export type ValidationResult =
  | { readonly ok: true; readonly issues: readonly [] }
  | { readonly ok: false; readonly issues: readonly ValidationIssue[] };
