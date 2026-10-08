import type { GameDefinition, PickupKind } from "./types";

const PICKUP_KINDS: readonly PickupKind[] = ["gray", "orange", "purple"];

function assertInteger(value: number, label: string, min = 0): void {
  if (!Number.isSafeInteger(value) || value < min) {
    throw new TypeError(`${label} must be a safe integer >= ${min}`);
  }
}

function assertSafeInteger(value: number, label: string): void {
  if (!Number.isSafeInteger(value)) {
    throw new TypeError(`${label} must be a safe integer`);
  }
}

function assertPercent(value: number, label: string): void {
  assertInteger(value, label);
  if (value > 100) {
    throw new RangeError(`${label} must be <= 100`);
  }
}

export function assertValidGameDefinition(definition: GameDefinition): void {
  if (definition.version !== 1) {
    throw new TypeError("unsupported game definition version");
  }

  const { level, rules } = definition;
  if (level.id.length === 0) {
    throw new TypeError("level.id must not be empty");
  }
  if (level.tileRows.length === 0) {
    throw new TypeError("level.tileRows must not be empty");
  }
  if (level.laneSpeeds.length < level.tileRows.length) {
    throw new TypeError("level.laneSpeeds must cover every world row");
  }
  if (!level.laneSpeeds.slice(0, level.tileRows.length).some((speed) => speed !== 0)) {
    throw new TypeError("level must contain at least one traffic lane");
  }
  if (!level.laneSpeeds.slice(0, level.tileRows.length).some((speed) => speed === 0)) {
    throw new TypeError("level must contain at least one obstacle-eligible row");
  }
  assertPercent(level.trafficSpawnPercent, "level.trafficSpawnPercent");
  assertInteger(level.obstaclePlacementAttempts, "level.obstaclePlacementAttempts");
  assertInteger(level.initialTrafficRemaining, "level.initialTrafficRemaining", 1);

  assertInteger(rules.tickMilliseconds, "rules.tickMilliseconds", 1);
  assertInteger(rules.viewport.width, "rules.viewport.width", 1);
  assertInteger(rules.viewport.height, "rules.viewport.height", 1);
  assertInteger(rules.rowHeight, "rules.rowHeight", 1);
  assertInteger(rules.camera.followY, "rules.camera.followY");
  assertInteger(rules.player.size.width, "rules.player.size.width", 1);
  assertInteger(rules.player.size.height, "rules.player.size.height", 1);
  assertInteger(rules.player.spawnX, "rules.player.spawnX");
  assertInteger(rules.player.normalSpeed, "rules.player.normalSpeed", 1);
  assertInteger(rules.player.boostedSpeed, "rules.player.boostedSpeed", 1);
  assertInteger(rules.player.initialSpareLives, "rules.player.initialSpareLives");

  assertInteger(rules.traffic.poolSize, "rules.traffic.poolSize", 1);
  assertInteger(rules.traffic.warmupTicks, "rules.traffic.warmupTicks");
  assertInteger(rules.traffic.height, "rules.traffic.height", 1);
  if (definition.trafficFrameWidths.length === 0) {
    throw new TypeError("trafficFrameWidths must not be empty");
  }
  definition.trafficFrameWidths.forEach((width, index) =>
    assertInteger(width, `trafficFrameWidths[${index}]`, 1),
  );

  assertInteger(rules.obstacles.maxPerRow, "rules.obstacles.maxPerRow", 1);
  assertInteger(
    rules.obstacles.startCorridor.bottomRowCount,
    "rules.obstacles.startCorridor.bottomRowCount",
    1,
  );
  assertSafeInteger(rules.obstacles.yOffset.min, "rules.obstacles.yOffset.min");
  assertSafeInteger(rules.obstacles.yOffset.max, "rules.obstacles.yOffset.max");
  if (rules.obstacles.yOffset.max < rules.obstacles.yOffset.min) {
    throw new RangeError("obstacle yOffset maximum must be at least its minimum");
  }
  if (rules.obstacles.typeCycle.length === 0) {
    throw new TypeError("rules.obstacles.typeCycle must not be empty");
  }
  for (const type of rules.obstacles.typeCycle) {
    if (!definition.obstacleFrames.some((frame) => frame.type === type)) {
      throw new TypeError(`missing obstacle frame for type ${type}`);
    }
  }

  const kinds = rules.pickups.rules.map(({ kind }) => kind);
  if (
    kinds.length !== PICKUP_KINDS.length ||
    PICKUP_KINDS.some((kind) => kinds.filter((candidate) => candidate === kind).length !== 1)
  ) {
    throw new TypeError("rules.pickups.rules must contain gray, orange, and purple once each");
  }
  for (const pickup of rules.pickups.rules) {
    assertPercent(pickup.presencePercent, `${pickup.kind}.presencePercent`);
    assertInteger(pickup.frameCount, `${pickup.kind}.frameCount`, 1);
    if (pickup.message.length === 0) {
      throw new TypeError(`${pickup.kind}.message must not be empty`);
    }
  }
  assertInteger(rules.pickups.size.width, "rules.pickups.size.width", 1);
  assertInteger(rules.pickups.size.height, "rules.pickups.size.height", 1);
  assertInteger(rules.pickups.placement.minX, "rules.pickups.placement.minX");
  assertInteger(rules.pickups.placement.maxX, "rules.pickups.placement.maxX");
  assertInteger(rules.pickups.placement.minY, "rules.pickups.placement.minY");
  assertInteger(rules.pickups.placement.bottomMargin, "rules.pickups.placement.bottomMargin");
  assertInteger(
    rules.pickups.animationAdvancesPerTick,
    "rules.pickups.animationAdvancesPerTick",
    1,
  );
  if (rules.pickups.placement.maxX < rules.pickups.placement.minX) {
    throw new RangeError("pickup placement maxX must be at least minX");
  }
  for (const orderName of ["initializationOrder", "collectionOrder"] as const) {
    const order = rules.pickups[orderName];
    if (
      order.length !== PICKUP_KINDS.length ||
      PICKUP_KINDS.some((kind) => order.filter((candidate) => candidate === kind).length !== 1)
    ) {
      throw new TypeError(`rules.pickups.${orderName} must contain every pickup kind once`);
    }
  }
  if (rules.pickups.purpleBonus.max < rules.pickups.purpleBonus.min) {
    throw new RangeError("purple bonus maximum must be at least its minimum");
  }

  assertInteger(rules.transitions.deathHoldTicks, "deathHoldTicks", 1);
  assertInteger(rules.transitions.terminalTicks, "terminalTicks", 1);
  assertInteger(rules.transitions.cameraPanPixelsPerTick, "cameraPanPixelsPerTick", 1);
  assertInteger(rules.transitions.pickupMessageTicks, "pickupMessageTicks", 1);
  assertInteger(
    rules.transitions.deathVibrationMilliseconds,
    "deathVibrationMilliseconds",
    1,
  );

  for (const [key, value] of Object.entries(rules.rng)) {
    assertInteger(value, `rules.rng.${key}`);
    if (value > 0xffff_ffff) {
      throw new RangeError(`rules.rng.${key} must fit uint32`);
    }
  }
  if (rules.rng.zeroStateFallback === 0) {
    throw new RangeError("rules.rng.zeroStateFallback must be nonzero");
  }
}
