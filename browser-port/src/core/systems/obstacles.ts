import { randomInt } from "../rng";
import type { GameDefinition, ObstacleState, RngStates } from "../types";

export interface GeneratedObstacles {
  obstacles: ObstacleState[];
  rngStates: RngStates;
}

export function generateObstacles(
  definition: GameDefinition,
  rngStates: RngStates,
): GeneratedObstacles {
  const { level, rules } = definition;
  const rowCount = level.tileRows.length;
  const eligibleRows: number[] = [];
  for (let row = rowCount - 1; row >= 0; row -= 1) {
    if (level.laneSpeeds[row] === 0) {
      eligibleRows.push(row);
    }
  }

  let obstacleRng = rngStates.obstacles;
  let cycleIndex = 0;
  const rowCounts = new Map<number, number>();
  const obstacles: ObstacleState[] = [];

  for (let attempt = 0; attempt < level.obstaclePlacementAttempts; attempt += 1) {
    const rowRoll = randomInt(obstacleRng, eligibleRows.length);
    obstacleRng = rowRoll.state;
    const rowIndex = eligibleRows[rowRoll.value];
    if (rowIndex === undefined) {
      throw new Error("obstacle generation selected a missing row");
    }

    const xRoll = randomInt(obstacleRng, rules.viewport.width);
    obstacleRng = xRoll.state;
    const yRange = rules.obstacles.yOffset.max - rules.obstacles.yOffset.min + 1;
    const yRoll = randomInt(obstacleRng, yRange);
    obstacleRng = yRoll.state;

    const inBottomStartRows =
      rowIndex >= rowCount - rules.obstacles.startCorridor.bottomRowCount;
    const inStartCorridor =
      xRoll.value >= rules.obstacles.startCorridor.minX &&
      xRoll.value <= rules.obstacles.startCorridor.maxX;
    const rowFull = (rowCounts.get(rowIndex) ?? 0) >= rules.obstacles.maxPerRow;

    if (rowFull || (inBottomStartRows && inStartCorridor)) {
      continue;
    }

    const type = rules.obstacles.typeCycle[cycleIndex];
    if (type === undefined) {
      throw new Error("obstacle type cycle is empty");
    }
    const frame = definition.obstacleFrames.find((candidate) => candidate.type === type);
    if (frame === undefined) {
      throw new Error(`missing obstacle frame ${type}`);
    }

    obstacles.push({
      id: obstacles.length,
      rowIndex,
      type,
      x: xRoll.value,
      y: rowIndex * rules.rowHeight + rules.obstacles.yOffset.min + yRoll.value,
      width: frame.width,
      height: frame.height,
      collision: { ...frame.collision },
    });
    rowCounts.set(rowIndex, (rowCounts.get(rowIndex) ?? 0) + 1);
    cycleIndex = (cycleIndex + 1) % rules.obstacles.typeCycle.length;
  }

  return {
    obstacles,
    rngStates: { ...rngStates, obstacles: obstacleRng },
  };
}
