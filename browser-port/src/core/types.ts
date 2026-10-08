export const GAME_STATE_VERSION = 1 as const;

export type Direction = "up" | "right" | "down" | "left";
export type RunPhase = "playing" | "dying" | "levelComplete" | "gameOver";
export type Route = "title" | "run" | "results" | "loadError";
export type SuspensionReason = "user" | "hidden" | "blur";
export type DeathCause = "traffic" | "counterZero";
export type PickupKind = "gray" | "orange" | "purple";

export interface Point {
  x: number;
  y: number;
}

export interface Size {
  width: number;
  height: number;
}

export interface Rect extends Point, Size {}

export interface CollisionRect extends Rect {}

export interface HeldDirection {
  /** Stable keyboard key or pointer identifier supplied by the input adapter. */
  sourceId: string;
  direction: Direction;
  /** Monotonically increasing press order. Larger values are more recent. */
  pressedOrder: number;
}

export interface InputSnapshot {
  heldDirections: readonly HeldDirection[];
}

export interface CoreLevelDefinition {
  id: string;
  displayNumber: number;
  tileRows: readonly number[];
  laneSpeeds: readonly number[];
  trafficSpawnPercent: number;
  obstaclePlacementAttempts: number;
  initialTrafficRemaining: number;
  drawObstaclesAboveActors: boolean;
}

export interface TrafficCollisionInsets {
  left: number;
  top: number;
  right: number;
  bottom: number;
}

export interface ObstacleFrameDefinition extends Size {
  type: number;
  collision: CollisionRect;
}

export interface PickupRuleDefinition {
  kind: PickupKind;
  presencePercent: number;
  frameCount: number;
  message: string;
}

export interface CoreRulesDefinition {
  tickMilliseconds: number;
  viewport: Size;
  rowHeight: number;
  camera: {
    followY: number;
  };
  player: {
    size: Size;
    collision: CollisionRect;
    spawnX: number;
    normalSpeed: number;
    boostedSpeed: number;
    initialSpareLives: number;
  };
  traffic: {
    poolSize: number;
    warmupTicks: number;
    height: number;
    collisionInsets: TrafficCollisionInsets;
  };
  obstacles: {
    maxPerRow: number;
    typeCycle: readonly number[];
    startCorridor: {
      minX: number;
      maxX: number;
      bottomRowCount: number;
    };
    yOffset: {
      min: number;
      max: number;
    };
  };
  pickups: {
    size: Size;
    rules: readonly PickupRuleDefinition[];
    placement: {
      minX: number;
      maxX: number;
      minY: number;
      bottomMargin: number;
    };
    animationAdvancesPerTick: number;
    initializationOrder: readonly PickupKind[];
    collectionOrder: readonly PickupKind[];
    purpleBonus: {
      min: number;
      max: number;
    };
  };
  transitions: {
    deathHoldTicks: number;
    terminalTicks: number;
    cameraPanPixelsPerTick: number;
    pickupMessageTicks: number;
    deathVibrationMilliseconds: number;
  };
  rng: {
    trafficXor: number;
    obstaclesXor: number;
    pickupsXor: number;
    zeroStateFallback: number;
  };
}

/**
 * Browser-independent, normalized data required by the rules engine.
 *
 * The data adapter is responsible for translating versioned JSON/atlas data to
 * this shape. Keeping the core on this small contract makes it usable by tests
 * and by future non-browser hosts.
 */
export interface GameDefinition {
  version: 1;
  level: CoreLevelDefinition;
  rules: CoreRulesDefinition;
  trafficFrameWidths: readonly number[];
  obstacleFrames: readonly ObstacleFrameDefinition[];
}

export interface RngStates {
  traffic: number;
  obstacles: number;
  pickups: number;
}

export interface PlayerState extends Point {
  width: number;
  height: number;
  speed: number;
  visible: boolean;
  facing: Direction;
  animationStep: number;
  /** Prevents an input held through death/pause from moving after control returns. */
  inputLockedUntilRelease: boolean;
}

export interface TrafficVehicleState extends Point {
  id: number;
  frameIndex: number;
  width: number;
  height: number;
  laneIndex: number;
  speed: number;
  active: boolean;
  /** Increasing value used to process newest vehicles first inside a lane. */
  spawnSequence: number;
}

export interface ObstacleState extends Point {
  id: number;
  rowIndex: number;
  type: number;
  width: number;
  height: number;
  collision: CollisionRect;
}

export interface PickupState extends Point {
  kind: PickupKind;
  width: number;
  height: number;
  present: boolean;
  consumed: boolean;
  animationFrame: number;
  frameCount: number;
  /** Non-zero only for a present purple pickup. */
  bonus: number;
}

export interface PickupMessageState extends Point {
  kind: PickupKind;
  text: string;
  ageTicks: number;
  durationTicks: number;
}

export interface DeadMarkerState extends Point {
  cause: DeathCause;
  tick: number;
}

export interface TransitionTimers {
  phaseElapsedTicks: number;
}

export interface GameResult {
  outcome: "win" | "loss";
  finalScore: number;
}

export interface GameState {
  version: 1;
  route: Route;
  phase: RunPhase | null;
  suspension: null | {
    reason: SuspensionReason;
    resumePhase: RunPhase;
  };
  tick: number;
  levelId: string;
  runSeed: number;
  rngStates: RngStates;
  player: PlayerState;
  traffic: TrafficVehicleState[];
  inactiveTrafficIds: number[];
  nextTrafficSpawnSequence: number;
  obstacles: ObstacleState[];
  pickups: PickupState[];
  pickupMessages: PickupMessageState[];
  deadMarkers: DeadMarkerState[];
  spareLives: number;
  trafficRemaining: number;
  score: number;
  cameraY: number;
  timers: TransitionTimers;
  lastDeathCause: DeathCause | null;
  result: GameResult | null;
}

export type GameEvent =
  | {
      type: "pickupCollected";
      kind: PickupKind;
      message: string;
      bonus: number;
    }
  | {
      type: "playerDied";
      cause: DeathCause;
      spareLives: number;
    }
  | { type: "vibrationRequested"; milliseconds: number }
  | { type: "clearInputRequested" }
  | { type: "playerRespawned" }
  | { type: "levelCompleted"; trafficRemaining: number }
  | {
      type: "scoreFinalized";
      outcome: "win" | "loss";
      finalScore: number;
    }
  | {
      type: "resultsReady";
      outcome: "win" | "loss";
      finalScore: number;
    }
  | { type: "suspended"; reason: SuspensionReason; resumePhase: RunPhase }
  | { type: "resumed"; phase: RunPhase };

export interface StepResult {
  state: GameState;
  events: GameEvent[];
}

export interface GameEngine {
  readonly definition: GameDefinition;
  createRun(runSeed: number): GameState;
  step(state: GameState, input: InputSnapshot): StepResult;
  suspend(state: GameState, reason: SuspensionReason): StepResult;
  resume(state: GameState): StepResult;
}
