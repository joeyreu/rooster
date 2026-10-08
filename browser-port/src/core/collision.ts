import type { CollisionRect, Rect } from "./types";

/** Edge contact counts as overlap, as it did in the recovered sprite checks. */
export function overlapsInclusive(a: Rect, b: Rect): boolean {
  return (
    a.x <= b.x + b.width &&
    a.x + a.width >= b.x &&
    a.y <= b.y + b.height &&
    a.y + a.height >= b.y
  );
}

export function applyCollisionRect(
  position: { x: number; y: number },
  collision: CollisionRect,
): Rect {
  return {
    x: position.x + collision.x,
    y: position.y + collision.y,
    width: collision.width,
    height: collision.height,
  };
}
