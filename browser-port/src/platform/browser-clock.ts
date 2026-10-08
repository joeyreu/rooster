export interface FixedStepClockOptions {
  tickMs?: number;
  maxElapsedMs?: number;
  maxSteps?: number;
  onStep: () => void;
  onRender: () => void;
}

export class FixedStepClock {
  private readonly tickMs: number;
  private readonly maxElapsedMs: number;
  private readonly maxSteps: number;
  private readonly onStep: () => void;
  private readonly onRender: () => void;
  private frameHandle: number | null = null;
  private previousTime: number | null = null;
  private accumulator = 0;

  constructor(options: FixedStepClockOptions) {
    this.tickMs = options.tickMs ?? 60;
    this.maxElapsedMs = options.maxElapsedMs ?? 240;
    this.maxSteps = options.maxSteps ?? 4;
    this.onStep = options.onStep;
    this.onRender = options.onRender;
  }

  start(): void {
    if (this.frameHandle !== null) return;
    this.previousTime = null;
    this.frameHandle = requestAnimationFrame(this.frame);
  }

  stop(): void {
    if (this.frameHandle !== null) cancelAnimationFrame(this.frameHandle);
    this.frameHandle = null;
    this.clearElapsed();
  }

  clearElapsed(): void {
    this.previousTime = null;
    this.accumulator = 0;
  }

  private readonly frame = (now: number): void => {
    if (this.previousTime === null) this.previousTime = now;
    const elapsed = Math.min(Math.max(now - this.previousTime, 0), this.maxElapsedMs);
    this.previousTime = now;
    this.accumulator += elapsed;

    let steps = 0;
    while (this.accumulator >= this.tickMs && steps < this.maxSteps) {
      this.onStep();
      this.accumulator -= this.tickMs;
      steps += 1;
    }

    if (steps === this.maxSteps) this.accumulator = 0;
    this.onRender();
    this.frameHandle = requestAnimationFrame(this.frame);
  };
}
