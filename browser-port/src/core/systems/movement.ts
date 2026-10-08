import { applyCollisionRect, overlapsInclusive } from "../collision";
import type { Direction, GameDefinition, GameState, PlayerState } from "../types";

function clamp(value: number, minimum: number, maximum: number): number {
  return Math.max(minimum, Math.min(maximum, value));
}

function directionDelta(direction: Direction, speed: number): { x: number; y: number } {
  switch (direction) {
    case "up":
      return { x: 0, y: -speed };
    case "right":
      return { x: speed, y: 0 };
    case "down":
      return { x: 0, y: speed };
    case "left":
      return { x: -speed, y: 0 };
  }
}

export function playerCollisionRect(
  definition: GameDefinition,
  player: PlayerState,
) {
  return applyCollisionRect(player, definition.rules.player.collision);
}

function collidesWithObstacle(definition: GameDefinition, state: GameState): boolean {
  const playerRect = playerCollisionRect(definition, state.player);
  return state.obstacles.some((obstacle) =>
    overlapsInclusive(playerRect, applyCollisionRect(obstacle, obstacle.collision)),
  );
}

export function movePlayer(
  definition: GameDefinition,
  state: GameState,
  direction: Direction | null,
): void {
  if (direction === null || !state.player.visible) {
    return;
  }

  const previousX = state.player.x;
  const previousY = state.player.y;
  const delta = directionDelta(direction, state.player.speed);
  const worldHeight = definition.level.tileRows.length * definition.rules.rowHeight;

  state.player.x = clamp(
    previousX + delta.x,
    0,
    definition.rules.viewport.width - state.player.width,
  );
  state.player.y = clamp(previousY + delta.y, 0, worldHeight - state.player.height);
  state.player.facing = direction;
  state.player.animationStep = (state.player.animationStep + 1) % 4;

  if (collidesWithObstacle(definition, state)) {
    state.player.x = previousX;
    state.player.y = previousY;
  }
}

export function updatePlayingCamera(definition: GameDefinition, state: GameState): void {
  const worldHeight = definition.level.tileRows.length * definition.rules.rowHeight;
  const halfViewport = definition.rules.camera.followY;
  if (
    state.player.y - halfViewport > 0 &&
    state.player.y + halfViewport < worldHeight
  ) {
    state.cameraY = state.player.y - halfViewport;
  }
}

export function startingCameraY(definition: GameDefinition): number {
  const worldHeight = definition.level.tileRows.length * definition.rules.rowHeight;
  return Math.max(0, worldHeight - definition.rules.viewport.height);
}

export function panCameraTowardStart(definition: GameDefinition, state: GameState): boolean {
  const target = startingCameraY(definition);
  const amount = definition.rules.transitions.cameraPanPixelsPerTick;
  if (state.cameraY < target) {
    state.cameraY = Math.min(target, state.cameraY + amount);
  } else if (state.cameraY > target) {
    state.cameraY = Math.max(target, state.cameraY - amount);
  }
  return state.cameraY === target;
}
