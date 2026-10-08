import type {
  AtlasDefinition,
  GameDataV1,
  Rectangle,
  ValidationIssue,
  ValidationResult,
} from "./types";

type UnknownRecord = Record<string, unknown>;

const isRecord = (value: unknown): value is UnknownRecord =>
  typeof value === "object" && value !== null && !Array.isArray(value);

const isInteger = (value: unknown): value is number =>
  typeof value === "number" && Number.isInteger(value);

function validatePositiveInteger(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
): value is number {
  if (!isInteger(value) || value <= 0) {
    issues.push({ path, message: "must be a positive integer" });
    return false;
  }
  return true;
}

function validateNonNegativeInteger(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
): value is number {
  if (!isInteger(value) || value < 0) {
    issues.push({ path, message: "must be a non-negative integer" });
    return false;
  }
  return true;
}

function validateInteger(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
): value is number {
  if (!isInteger(value)) {
    issues.push({ path, message: "must be an integer" });
    return false;
  }
  return true;
}

function validateUint32(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
  allowZero = true,
): value is number {
  if (!isInteger(value) || value < (allowZero ? 0 : 1) || value > 0xffff_ffff) {
    issues.push({
      path,
      message: allowZero ? "must be a uint32" : "must be a non-zero uint32",
    });
    return false;
  }
  return true;
}

function validateString(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
): value is string {
  if (typeof value !== "string" || value.length === 0) {
    issues.push({ path, message: "must be a non-empty string" });
    return false;
  }
  return true;
}

function validateRectangle(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
): value is Rectangle {
  if (!isRecord(value)) {
    issues.push({ path, message: "must be an object" });
    return false;
  }

  const xValid = validateNonNegativeInteger(value.x, `${path}/x`, issues);
  const yValid = validateNonNegativeInteger(value.y, `${path}/y`, issues);
  const widthValid = validatePositiveInteger(
    value.width,
    `${path}/width`,
    issues,
  );
  const heightValid = validatePositiveInteger(
    value.height,
    `${path}/height`,
    issues,
  );
  return xValid && yValid && widthValid && heightValid;
}

function validateAtlas(
  value: unknown,
  index: number,
  issues: ValidationIssue[],
): value is AtlasDefinition {
  const path = `/atlases/${index}`;
  if (!isRecord(value)) {
    issues.push({ path, message: "must be an object" });
    return false;
  }

  validateString(value.id, `${path}/id`, issues);
  validateString(value.assetId, `${path}/assetId`, issues);

  if (!isRecord(value.sheet)) {
    issues.push({ path: `${path}/sheet`, message: "must be an object" });
  } else {
    validatePositiveInteger(value.sheet.width, `${path}/sheet/width`, issues);
    validatePositiveInteger(value.sheet.height, `${path}/sheet/height`, issues);
  }

  if (!Array.isArray(value.frames) || value.frames.length === 0) {
    issues.push({ path: `${path}/frames`, message: "must be a non-empty array" });
  } else {
    const frameIds = new Set<string>();
    value.frames.forEach((frame, frameIndex) => {
      const framePath = `${path}/frames/${frameIndex}`;
      if (!isRecord(frame)) {
        issues.push({ path: framePath, message: "must be an object" });
        return;
      }
      if (validateString(frame.id, `${framePath}/id`, issues)) {
        if (frameIds.has(frame.id)) {
          issues.push({
            path: `${framePath}/id`,
            message: `duplicate frame id ${frame.id}`,
          });
        }
        frameIds.add(frame.id);
      }
      if (validateRectangle(frame, framePath, issues) && isRecord(value.sheet)) {
        const sheetWidth = value.sheet.width;
        const sheetHeight = value.sheet.height;
        if (
          typeof sheetWidth === "number" &&
          frame.x + frame.width > sheetWidth
        ) {
          issues.push({
            path: framePath,
            message: "frame extends beyond sheet width",
          });
        }
        if (
          typeof sheetHeight === "number" &&
          frame.y + frame.height > sheetHeight
        ) {
          issues.push({
            path: framePath,
            message: "frame extends beyond sheet height",
          });
        }
      }
    });

    if (!isRecord(value.groups)) {
      issues.push({ path: `${path}/groups`, message: "must be an object" });
    } else {
      Object.entries(value.groups).forEach(([groupId, members]) => {
        if (!Array.isArray(members)) {
          issues.push({
            path: `${path}/groups/${groupId}`,
            message: "must be an array",
          });
          return;
        }
        members.forEach((member, memberIndex) => {
          if (typeof member !== "string" || !frameIds.has(member)) {
            issues.push({
              path: `${path}/groups/${groupId}/${memberIndex}`,
              message: `must reference a frame in ${String(value.id)}`,
            });
          }
        });
      });
    }
  }

  if (value.directionalTransform !== undefined) {
    const transformPath = `${path}/directionalTransform`;
    if (!isRecord(value.directionalTransform)) {
      issues.push({ path: transformPath, message: "must be an object" });
    } else {
      if (value.directionalTransform.positiveSpeed !== "mirrorX") {
        issues.push({
          path: `${transformPath}/positiveSpeed`,
          message: "must equal mirrorX",
        });
      }
      if (value.directionalTransform.negativeSpeed !== "source") {
        issues.push({
          path: `${transformPath}/negativeSpeed`,
          message: "must equal source",
        });
      }
    }
  }

  return true;
}

const PICKUP_IDS = ["life", "speed", "counter"] as const;
const PICKUP_EFFECTS = {
  life: "addSpareLife",
  speed: "setBoostedSpeed",
  counter: "addTrafficRemaining",
} as const;

function validatePickupOrder(
  value: unknown,
  path: string,
  issues: ValidationIssue[],
): void {
  if (!Array.isArray(value) || value.length !== PICKUP_IDS.length) {
    issues.push({ path, message: "must contain every pickup id exactly once" });
    return;
  }

  for (const id of PICKUP_IDS) {
    if (value.filter((candidate) => candidate === id).length !== 1) {
      issues.push({ path, message: "must contain every pickup id exactly once" });
      return;
    }
  }
}

function validateRules(value: unknown, issues: ValidationIssue[]): void {
  const path = "/rules";
  if (!isRecord(value)) {
    issues.push({ path, message: "must be an object" });
    return;
  }

  validatePositiveInteger(
    value.tickMilliseconds,
    `${path}/tickMilliseconds`,
    issues,
  );
  validatePositiveInteger(value.rowHeight, `${path}/rowHeight`, issues);

  if (!isRecord(value.viewport)) {
    issues.push({ path: `${path}/viewport`, message: "must be an object" });
  } else {
    validatePositiveInteger(
      value.viewport.width,
      `${path}/viewport/width`,
      issues,
    );
    validatePositiveInteger(
      value.viewport.height,
      `${path}/viewport/height`,
      issues,
    );
  }

  if (!isRecord(value.player)) {
    issues.push({ path: `${path}/player`, message: "must be an object" });
  } else {
    for (const key of [
      "width",
      "height",
      "normalSpeed",
      "boostedSpeed",
    ] as const) {
      validatePositiveInteger(value.player[key], `${path}/player/${key}`, issues);
    }
    validateNonNegativeInteger(
      value.player.spawnX,
      `${path}/player/spawnX`,
      issues,
    );
    validateNonNegativeInteger(
      value.player.initialSpareLives,
      `${path}/player/initialSpareLives`,
      issues,
    );
    validateRectangle(value.player.collision, `${path}/player/collision`, issues);
  }

  if (!isRecord(value.camera)) {
    issues.push({ path: `${path}/camera`, message: "must be an object" });
  } else {
    validateNonNegativeInteger(value.camera.followY, `${path}/camera/followY`, issues);
    validatePositiveInteger(
      value.camera.respawnPanPixelsPerTick,
      `${path}/camera/respawnPanPixelsPerTick`,
      issues,
    );
  }

  if (!isRecord(value.traffic)) {
    issues.push({ path: `${path}/traffic`, message: "must be an object" });
  } else {
    validatePositiveInteger(value.traffic.poolSize, `${path}/traffic/poolSize`, issues);
    validateNonNegativeInteger(
      value.traffic.warmupTicks,
      `${path}/traffic/warmupTicks`,
      issues,
    );
    validatePositiveInteger(value.traffic.height, `${path}/traffic/height`, issues);
    if (!isRecord(value.traffic.collisionInsets)) {
      issues.push({
        path: `${path}/traffic/collisionInsets`,
        message: "must be an object",
      });
    } else {
      for (const inset of ["left", "top", "right", "bottom"] as const) {
        validateNonNegativeInteger(
          value.traffic.collisionInsets[inset],
          `${path}/traffic/collisionInsets/${inset}`,
          issues,
        );
      }
    }
  }

  if (!isRecord(value.obstacles)) {
    issues.push({ path: `${path}/obstacles`, message: "must be an object" });
  } else {
    validatePositiveInteger(
      value.obstacles.maxPerRow,
      `${path}/obstacles/maxPerRow`,
      issues,
    );
    if (!Array.isArray(value.obstacles.typeCycle) || value.obstacles.typeCycle.length === 0) {
      issues.push({
        path: `${path}/obstacles/typeCycle`,
        message: "must be a non-empty array of non-negative integers",
      });
    } else {
      value.obstacles.typeCycle.forEach((type, index) =>
        validateNonNegativeInteger(type, `${path}/obstacles/typeCycle/${index}`, issues),
      );
    }
    validateRectangle(
      value.obstacles.smallCollision,
      `${path}/obstacles/smallCollision`,
      issues,
    );
    validateRectangle(
      value.obstacles.largeCollision,
      `${path}/obstacles/largeCollision`,
      issues,
    );

    if (!isRecord(value.obstacles.startCorridor)) {
      issues.push({
        path: `${path}/obstacles/startCorridor`,
        message: "must be an object",
      });
    } else {
      const corridorMinX = value.obstacles.startCorridor.minX;
      const corridorMaxX = value.obstacles.startCorridor.maxX;
      const minValid = validateNonNegativeInteger(
        corridorMinX,
        `${path}/obstacles/startCorridor/minX`,
        issues,
      );
      const maxValid = validateNonNegativeInteger(
        corridorMaxX,
        `${path}/obstacles/startCorridor/maxX`,
        issues,
      );
      validatePositiveInteger(
        value.obstacles.startCorridor.bottomRowCount,
        `${path}/obstacles/startCorridor/bottomRowCount`,
        issues,
      );
      if (
        minValid &&
        maxValid &&
        corridorMaxX < corridorMinX
      ) {
        issues.push({
          path: `${path}/obstacles/startCorridor/maxX`,
          message: "must be at least minX",
        });
      }
    }

    if (!isRecord(value.obstacles.yOffset)) {
      issues.push({ path: `${path}/obstacles/yOffset`, message: "must be an object" });
    } else {
      const offsetMin = value.obstacles.yOffset.min;
      const offsetMax = value.obstacles.yOffset.max;
      const minValid = validateInteger(
        offsetMin,
        `${path}/obstacles/yOffset/min`,
        issues,
      );
      const maxValid = validateInteger(
        offsetMax,
        `${path}/obstacles/yOffset/max`,
        issues,
      );
      if (minValid && maxValid && offsetMax < offsetMin) {
        issues.push({
          path: `${path}/obstacles/yOffset/max`,
          message: "must be at least min",
        });
      }
    }
  }

  if (!Array.isArray(value.pickups) || value.pickups.length !== 3) {
    issues.push({
      path: `${path}/pickups`,
      message: "must contain the life, speed, and counter definitions",
    });
  } else {
    const pickupIds = new Set<string>();
    value.pickups.forEach((pickup, pickupIndex) => {
      const pickupPath = `${path}/pickups/${pickupIndex}`;
      if (!isRecord(pickup)) {
        issues.push({ path: pickupPath, message: "must be an object" });
        return;
      }
      let pickupId: (typeof PICKUP_IDS)[number] | undefined;
      if (validateString(pickup.id, `${pickupPath}/id`, issues)) {
        if (!PICKUP_IDS.includes(pickup.id as (typeof PICKUP_IDS)[number])) {
          issues.push({ path: `${pickupPath}/id`, message: "must be life, speed, or counter" });
        } else {
          pickupId = pickup.id as (typeof PICKUP_IDS)[number];
          if (pickupIds.has(pickupId)) {
            issues.push({ path: `${pickupPath}/id`, message: `duplicate pickup id ${pickupId}` });
          }
          pickupIds.add(pickupId);
        }
      }
      validateString(pickup.assetId, `${pickupPath}/assetId`, issues);
      validateString(pickup.atlasId, `${pickupPath}/atlasId`, issues);
      if (validateString(pickup.effect, `${pickupPath}/effect`, issues) && pickupId !== undefined) {
        if (pickup.effect !== PICKUP_EFFECTS[pickupId]) {
          issues.push({
            path: `${pickupPath}/effect`,
            message: `must equal ${PICKUP_EFFECTS[pickupId]} for ${pickupId}`,
          });
        }
      }
      validateString(pickup.message, `${pickupPath}/message`, issues);
      if (
        !isInteger(pickup.presencePercent) ||
        pickup.presencePercent < 0 ||
        pickup.presencePercent > 100
      ) {
        issues.push({
          path: `${pickupPath}/presencePercent`,
          message: "must be an integer from 0 through 100",
        });
      }

      if (pickupId === "counter" || pickup.bonus !== undefined) {
        if (!isRecord(pickup.bonus)) {
          issues.push({ path: `${pickupPath}/bonus`, message: "must be an object" });
        } else {
          const bonusMin = pickup.bonus.min;
          const bonusMax = pickup.bonus.max;
          const minValid = validateNonNegativeInteger(
            bonusMin,
            `${pickupPath}/bonus/min`,
            issues,
          );
          const maxValid = validateNonNegativeInteger(
            bonusMax,
            `${pickupPath}/bonus/max`,
            issues,
          );
          if (minValid && maxValid && bonusMax < bonusMin) {
            issues.push({ path: `${pickupPath}/bonus/max`, message: "must be at least min" });
          }
        }
      }
    });
    for (const requiredId of ["life", "speed", "counter"]) {
      if (!pickupIds.has(requiredId)) {
        issues.push({
          path: `${path}/pickups`,
          message: `missing ${requiredId} pickup`,
        });
      }
    }
  }

  if (!isRecord(value.pickupPlacement)) {
    issues.push({ path: `${path}/pickupPlacement`, message: "must be an object" });
  } else {
    const placementMinX = value.pickupPlacement.minX;
    const placementMaxX = value.pickupPlacement.maxX;
    validatePositiveInteger(
      value.pickupPlacement.width,
      `${path}/pickupPlacement/width`,
      issues,
    );
    validatePositiveInteger(
      value.pickupPlacement.height,
      `${path}/pickupPlacement/height`,
      issues,
    );
    const minXValid = validateNonNegativeInteger(
      placementMinX,
      `${path}/pickupPlacement/minX`,
      issues,
    );
    const maxXValid = validateNonNegativeInteger(
      placementMaxX,
      `${path}/pickupPlacement/maxX`,
      issues,
    );
    for (const key of [
      "minY",
      "bottomMargin",
      "messageTicks",
      "animationAdvancesPerTick",
    ] as const) {
      validateNonNegativeInteger(
        value.pickupPlacement[key],
        `${path}/pickupPlacement/${key}`,
        issues,
      );
    }
    if (minXValid && maxXValid && placementMaxX < placementMinX) {
      issues.push({
        path: `${path}/pickupPlacement/maxX`,
        message: "must be at least minX",
      });
    }
    validatePickupOrder(
      value.pickupPlacement.initializationOrder,
      `${path}/pickupPlacement/initializationOrder`,
      issues,
    );
    validatePickupOrder(
      value.pickupPlacement.collectionOrder,
      `${path}/pickupPlacement/collectionOrder`,
      issues,
    );
  }

  if (!isRecord(value.transitions)) {
    issues.push({ path: `${path}/transitions`, message: "must be an object" });
  } else {
    for (const key of [
      "dyingHoldTicks",
      "terminalHoldTicks",
      "deathVibrationMilliseconds",
    ] as const) {
      validateNonNegativeInteger(value.transitions[key], `${path}/transitions/${key}`, issues);
    }
  }

  if (!isRecord(value.rng)) {
    issues.push({ path: `${path}/rng`, message: "must be an object" });
  } else {
    if (value.rng.algorithm !== "xorshift32") {
      issues.push({ path: `${path}/rng/algorithm`, message: "must equal xorshift32" });
    }
    validateUint32(value.rng.zeroReplacement, `${path}/rng/zeroReplacement`, issues, false);
    if (!isRecord(value.rng.streamXor)) {
      issues.push({ path: `${path}/rng/streamXor`, message: "must be an object" });
    } else {
      for (const key of ["traffic", "obstacles", "pickups"] as const) {
        validateUint32(value.rng.streamXor[key], `${path}/rng/streamXor/${key}`, issues);
      }
    }
  }
}

export function validateGameData(value: unknown): ValidationResult {
  const issues: ValidationIssue[] = [];
  if (!isRecord(value)) {
    return {
      ok: false,
      issues: [{ path: "/", message: "game data must be an object" }],
    };
  }

  if (value.version !== 1) {
    issues.push({ path: "/version", message: "must equal 1" });
  }
  validateRules(value.rules, issues);

  const atlasIds = new Set<string>();
  const atlasAssetIds = new Set<string>();
  const atlasesById = new Map<string, UnknownRecord>();
  if (!Array.isArray(value.atlases) || value.atlases.length === 0) {
    issues.push({ path: "/atlases", message: "must be a non-empty array" });
  } else {
    value.atlases.forEach((atlas, index) => {
      validateAtlas(atlas, index, issues);
      if (isRecord(atlas) && typeof atlas.id === "string") {
        if (atlasIds.has(atlas.id)) {
          issues.push({
            path: `/atlases/${index}/id`,
            message: `duplicate atlas id ${atlas.id}`,
          });
        }
        atlasIds.add(atlas.id);
        atlasesById.set(atlas.id, atlas);
      }
      if (isRecord(atlas) && typeof atlas.assetId === "string") {
        atlasAssetIds.add(atlas.assetId);
      }
    });
  }

  const levelIds = new Set<string>();
  if (!Array.isArray(value.levels) || value.levels.length === 0) {
    issues.push({ path: "/levels", message: "must be a non-empty array" });
  } else {
    value.levels.forEach((level, index) => {
      const path = `/levels/${index}`;
      if (!isRecord(level)) {
        issues.push({ path, message: "must be an object" });
        return;
      }
      if (validateString(level.id, `${path}/id`, issues)) {
        if (levelIds.has(level.id)) {
          issues.push({
            path: `${path}/id`,
            message: `duplicate level id ${level.id}`,
          });
        }
        levelIds.add(level.id);
      }
      validatePositiveInteger(
        level.displayNumber,
        `${path}/displayNumber`,
        issues,
      );
      validateString(level.themeId, `${path}/themeId`, issues);
      validateNonNegativeInteger(
        level.obstaclePlacementAttempts,
        `${path}/obstaclePlacementAttempts`,
        issues,
      );
      validateNonNegativeInteger(
        level.initialTrafficRemaining,
        `${path}/initialTrafficRemaining`,
        issues,
      );
      if (
        !isInteger(level.trafficSpawnPercent) ||
        level.trafficSpawnPercent < 0 ||
        level.trafficSpawnPercent > 100
      ) {
        issues.push({
          path: `${path}/trafficSpawnPercent`,
          message: "must be an integer from 0 through 100",
        });
      }
      if (typeof level.drawObstaclesAboveActors !== "boolean") {
        issues.push({
          path: `${path}/drawObstaclesAboveActors`,
          message: "must be a boolean",
        });
      }

      const rowsValid =
        Array.isArray(level.tileRows) &&
        level.tileRows.length > 0 &&
        level.tileRows.every((row) => isInteger(row) && row > 0);
      const speedsValid =
        Array.isArray(level.laneSpeeds) &&
        level.laneSpeeds.every((speed) => isInteger(speed));
      if (!rowsValid) {
        issues.push({
          path: `${path}/tileRows`,
          message: "must be a non-empty array of positive integers",
        });
      }
      if (!speedsValid) {
        issues.push({
          path: `${path}/laneSpeeds`,
          message: "must be an array of integers",
        });
      }
      if (
        rowsValid &&
        speedsValid &&
        Array.isArray(level.tileRows) &&
        Array.isArray(level.laneSpeeds) &&
        level.laneSpeeds.length < level.tileRows.length
      ) {
        issues.push({
          path: `${path}/laneSpeeds`,
          message: "must have at least one speed for every tile row",
        });
      }

      if (!isRecord(level.assets)) {
        issues.push({ path: `${path}/assets`, message: "must be an object" });
      } else {
        for (const key of [
          "backgroundAtlasId",
          "playerAtlasId",
          "trafficAtlasId",
          "obstacleAtlasId",
          "hudDigitsAtlasId",
        ] as const) {
          const atlasId = level.assets[key];
          if (!validateString(atlasId, `${path}/assets/${key}`, issues)) {
            continue;
          }
          if (!atlasIds.has(atlasId)) {
            issues.push({
              path: `${path}/assets/${key}`,
              message: `references unknown atlas ${atlasId}`,
            });
          }
        }
        validateString(
          level.assets.deadPlayerAssetId,
          `${path}/assets/deadPlayerAssetId`,
          issues,
        );

        const backgroundAtlas =
          typeof level.assets.backgroundAtlasId === "string"
            ? atlasesById.get(level.assets.backgroundAtlasId)
            : undefined;
        if (
          rowsValid &&
          Array.isArray(level.tileRows) &&
          backgroundAtlas !== undefined &&
          Array.isArray(backgroundAtlas.frames)
        ) {
          const frameIds = new Set(
            backgroundAtlas.frames.flatMap((frame) =>
              isRecord(frame) && typeof frame.id === "string" ? [frame.id] : [],
            ),
          );
          level.tileRows.forEach((tileRow, rowIndex) => {
            if (!frameIds.has(`tile-${tileRow}`)) {
              issues.push({
                path: `${path}/tileRows/${rowIndex}`,
                message: `references missing background frame tile-${tileRow}`,
              });
            }
          });
        }
      }
    });
  }

  if (isRecord(value.rules) && Array.isArray(value.rules.pickups)) {
    value.rules.pickups.forEach((pickup, index) => {
      if (
        isRecord(pickup) &&
        typeof pickup.atlasId === "string" &&
        !atlasIds.has(pickup.atlasId)
      ) {
        issues.push({
          path: `/rules/pickups/${index}/atlasId`,
          message: `references unknown atlas ${pickup.atlasId}`,
        });
      }
      if (
        isRecord(pickup) &&
        typeof pickup.assetId === "string" &&
        !atlasAssetIds.has(pickup.assetId)
      ) {
        issues.push({
          path: `/rules/pickups/${index}/assetId`,
          message: `references unknown atlas asset ${pickup.assetId}`,
        });
      }
      if (
        isRecord(pickup) &&
        typeof pickup.atlasId === "string" &&
        typeof pickup.assetId === "string"
      ) {
        const atlas = atlasesById.get(pickup.atlasId);
        if (
          atlas !== undefined &&
          typeof atlas.assetId === "string" &&
          atlas.assetId !== pickup.assetId
        ) {
          issues.push({
            path: `/rules/pickups/${index}/assetId`,
            message: `must match atlas ${pickup.atlasId} assetId ${atlas.assetId}`,
          });
        }
      }
    });
  }

  return issues.length === 0
    ? { ok: true, issues: [] }
    : { ok: false, issues };
}

export function assertValidGameData(
  value: unknown,
): asserts value is GameDataV1 {
  const result = validateGameData(value);
  if (!result.ok) {
    const detail = result.issues
      .map((issue) => `${issue.path}: ${issue.message}`)
      .join("\n");
    throw new Error(`Invalid Rooster game data:\n${detail}`);
  }
}
