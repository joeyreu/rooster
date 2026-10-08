import { afterEach, describe, expect, it, vi } from "vitest";

import { FixedStepClock } from "../../src/platform/browser-clock";

describe("fixed-step browser clock", () => {
  afterEach(() => vi.unstubAllGlobals());

  it("runs 60ms simulation steps independently of render cadence", () => {
    let pending: FrameRequestCallback | undefined;
    let handle = 0;
    vi.stubGlobal("requestAnimationFrame", (callback: FrameRequestCallback) => {
      pending = callback;
      return ++handle;
    });
    vi.stubGlobal("cancelAnimationFrame", vi.fn());

    const onStep = vi.fn();
    const onRender = vi.fn();
    const clock = new FixedStepClock({ tickMs: 60, onStep, onRender });
    const frame = (time: number): void => {
      const callback = pending;
      if (callback === undefined) throw new Error("no animation frame is queued");
      pending = undefined;
      callback(time);
    };

    clock.start();
    frame(100);
    frame(159);
    expect(onStep).not.toHaveBeenCalled();
    frame(160);
    expect(onStep).toHaveBeenCalledTimes(1);
    expect(onRender).toHaveBeenCalledTimes(3);
  });

  it("caps catch-up at four steps and clears elapsed time on suspension", () => {
    let pending: FrameRequestCallback | undefined;
    vi.stubGlobal("requestAnimationFrame", (callback: FrameRequestCallback) => {
      pending = callback;
      return 1;
    });
    vi.stubGlobal("cancelAnimationFrame", vi.fn());

    const onStep = vi.fn();
    const clock = new FixedStepClock({ onStep, onRender: vi.fn() });
    const frame = (time: number): void => {
      const callback = pending;
      if (callback === undefined) throw new Error("no animation frame is queued");
      pending = undefined;
      callback(time);
    };

    clock.start();
    frame(0);
    frame(1_000);
    expect(onStep).toHaveBeenCalledTimes(4);

    clock.clearElapsed();
    frame(50_000);
    expect(onStep).toHaveBeenCalledTimes(4);
  });
});
