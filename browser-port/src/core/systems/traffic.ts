import { overlapsInclusive } from "../collision";
import { randomInt } from "../rng";
import type { GameDefinition, GameState, Rect, TrafficVehicleState } from "../types";

function collisionRectAt(
  definition: GameDefinition,
  vehicle: Pick<TrafficVehicleState, "x" | "y" | "width" | "height">,
): Rect {
  const { left, top, right, bottom } = definition.rules.traffic.collisionInsets;
  return {
    x: vehicle.x + left,
    y: vehicle.y + top,
    width: vehicle.width - left - right,
    height: vehicle.height - top - bottom,
  };
}

function activeProcessingOrder(traffic: readonly TrafficVehicleState[]): TrafficVehicleState[] {
  return traffic
    .filter(({ active }) => active)
    .sort((left, right) => {
      if (left.laneIndex !== right.laneIndex) {
        return left.laneIndex - right.laneIndex;
      }
      return right.spawnSequence - left.spawnSequence;
    });
}

export function buildTrafficPool(definition: GameDefinition): TrafficVehicleState[] {
  const { poolSize, height } = definition.rules.traffic;
  return Array.from({ length: poolSize }, (_, id) => {
    const frameIndex = id % definition.trafficFrameWidths.length;
    const width = definition.trafficFrameWidths[frameIndex];
    if (width === undefined) {
      throw new Error("traffic frame list must not be empty");
    }
    return {
      id,
      frameIndex,
      width,
      height,
      x: 0,
      y: 0,
      laneIndex: -1,
      speed: 0,
      active: false,
      spawnSequence: -1,
    };
  });
}

function trafficLanesBottomToTop(definition: GameDefinition): number[] {
  const result: number[] = [];
  for (let lane = definition.level.tileRows.length - 1; lane >= 0; lane -= 1) {
    if (definition.level.laneSpeeds[lane] !== 0) {
      result.push(lane);
    }
  }
  return result;
}

function trySpawn(definition: GameDefinition, state: GameState): boolean {
  const densityRoll = randomInt(state.rngStates.traffic, 100);
  state.rngStates.traffic = densityRoll.state;
  if (
    densityRoll.value >= definition.level.trafficSpawnPercent ||
    state.inactiveTrafficIds.length === 0
  ) {
    return false;
  }

  const lanes = trafficLanesBottomToTop(definition);
  const laneRoll = randomInt(state.rngStates.traffic, lanes.length);
  state.rngStates.traffic = laneRoll.state;
  const laneIndex = lanes[laneRoll.value];
  const vehicleId = state.inactiveTrafficIds[0];
  if (laneIndex === undefined || vehicleId === undefined) {
    throw new Error("traffic spawn selected missing state");
  }

  const vehicle = state.traffic[vehicleId];
  const speed = definition.level.laneSpeeds[laneIndex];
  if (vehicle === undefined || speed === undefined || speed === 0) {
    throw new Error("traffic spawn selected an invalid vehicle or lane");
  }

  const candidate: Rect = {
    x: speed > 0 ? -vehicle.width : definition.rules.viewport.width,
    y: laneIndex * definition.rules.rowHeight,
    width: vehicle.width,
    height: vehicle.height,
  };
  const candidateCollision = collisionRectAt(definition, candidate);
  const overlapsEntry = state.traffic.some(
    (other) =>
      other.active &&
      overlapsInclusive(candidateCollision, collisionRectAt(definition, other)),
  );
  if (overlapsEntry) {
    return false;
  }

  state.inactiveTrafficIds.shift();
  vehicle.x = candidate.x;
  vehicle.y = candidate.y;
  vehicle.laneIndex = laneIndex;
  vehicle.speed = speed;
  vehicle.active = true;
  vehicle.spawnSequence = state.nextTrafficSpawnSequence;
  state.nextTrafficSpawnSequence += 1;
  return true;
}

function hasFullyExited(definition: GameDefinition, vehicle: TrafficVehicleState): boolean {
  return vehicle.speed > 0
    ? vehicle.x > definition.rules.viewport.width
    : vehicle.x + vehicle.width < 0;
}

/** Attempts one spawn and then advances all active vehicles exactly once. */
export function advanceTraffic(definition: GameDefinition, state: GameState): boolean {
  const spawned = trySpawn(definition, state);

  for (const orderedVehicle of activeProcessingOrder(state.traffic)) {
    const vehicle = state.traffic[orderedVehicle.id];
    if (vehicle === undefined || !vehicle.active) {
      continue;
    }
    vehicle.x += vehicle.speed;
    if (hasFullyExited(definition, vehicle)) {
      vehicle.active = false;
      vehicle.laneIndex = -1;
      vehicle.speed = 0;
      state.inactiveTrafficIds.push(vehicle.id);
    }
  }

  return spawned;
}

export function trafficCollisionRect(
  definition: GameDefinition,
  vehicle: TrafficVehicleState,
): Rect {
  return collisionRectAt(definition, vehicle);
}
