import { describe, expect, it } from "vitest";
import {
  applyCollisionRect,
  overlapsInclusive,
  resolveDirection,
  type InputSnapshot,
} from "../../src/core";

describe("input resolution", () => {
  it("uses the newest source and falls back when it is released", () => {
    const held: InputSnapshot = {
      heldDirections: [
        { sourceId: "keyboard:ArrowUp", direction: "up", pressedOrder: 4 },
        { sourceId: "pointer:7", direction: "right", pressedOrder: 8 },
      ],
    };
    expect(resolveDirection(held)).toBe("right");
    expect(resolveDirection({ heldDirections: held.heldDirections.slice(0, 1) })).toBe("up");
    expect(resolveDirection({ heldDirections: [] })).toBeNull();
  });
});

describe("collision rectangles", () => {
  it("counts exact edge contact as an overlap", () => {
    expect(
      overlapsInclusive(
        { x: 0, y: 0, width: 5, height: 5 },
        { x: 5, y: 2, width: 3, height: 3 },
      ),
    ).toBe(true);
    expect(
      overlapsInclusive(
        { x: 0, y: 0, width: 5, height: 5 },
        { x: 6, y: 2, width: 3, height: 3 },
      ),
    ).toBe(false);
  });

  it("translates a relative collision core", () => {
    expect(
      applyCollisionRect(
        { x: 120, y: 140 },
        { x: 10, y: 10, width: 5, height: 5 },
      ),
    ).toEqual({ x: 130, y: 150, width: 5, height: 5 });
  });
});
