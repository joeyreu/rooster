import { describe, expect, it } from "vitest";

import {
  getFinaleFrameLayout,
  isNextLevelPromptVisible,
} from "../../src/render/canvas-renderer";

describe("recovered campaign screen timing", () => {
  it("uses the next-level screen's increment-then-blink cadence", () => {
    expect(isNextLevelPromptVisible(0)).toBe(false);
    expect(isNextLevelPromptVisible(2)).toBe(false);
    expect(isNextLevelPromptVisible(3)).toBe(true);
    expect(isNextLevelPromptVisible(10)).toBe(true);
    expect(isNextLevelPromptVisible(11)).toBe(false);
    expect(isNextLevelPromptVisible(12)).toBe(false);
    expect(isNextLevelPromptVisible(0, true)).toBe(true);
  });

  it("holds, scrolls, and blinks the finale on the recovered frames", () => {
    expect(getFinaleFrameLayout(0)).toEqual({ storyY: 10, promptVisible: false });
    expect(getFinaleFrameLayout(60)).toEqual({ storyY: 10, promptVisible: false });
    expect(getFinaleFrameLayout(61)).toEqual({ storyY: 9, promptVisible: false });
    expect(getFinaleFrameLayout(284)).toEqual({ storyY: -214, promptVisible: false });
    expect(getFinaleFrameLayout(285)).toEqual({ storyY: -215, promptVisible: false });
    expect(getFinaleFrameLayout(288)).toEqual({ storyY: -215, promptVisible: true });
    expect(getFinaleFrameLayout(295)).toEqual({ storyY: -215, promptVisible: true });
    expect(getFinaleFrameLayout(296)).toEqual({ storyY: -215, promptVisible: false });
    expect(getFinaleFrameLayout(285, true)).toEqual({ storyY: -215, promptVisible: true });
  });
});
