import { describe, expect, it } from "vitest";

import { BrowserSaveStore } from "../../src/platform/browser-storage";

class MemoryStorage implements Storage {
  private readonly values = new Map<string, string>();
  failReads = false;
  failWrites = false;

  get length(): number {
    return this.values.size;
  }

  clear(): void {
    this.values.clear();
  }

  getItem(key: string): string | null {
    if (this.failReads) throw new Error("storage unavailable");
    return this.values.get(key) ?? null;
  }

  key(index: number): string | null {
    return [...this.values.keys()][index] ?? null;
  }

  removeItem(key: string): void {
    this.values.delete(key);
  }

  setItem(key: string, value: string): void {
    if (this.failWrites) throw new Error("quota exceeded");
    this.values.set(key, value);
  }
}

describe("browser save storage", () => {
  it("falls back for corrupt, unsupported, and unavailable records", () => {
    for (const stored of ["not json", JSON.stringify({ version: 2, bestScore: 99 })]) {
      const storage = new MemoryStorage();
      storage.setItem("rooster.save.v1", stored);
      expect(new BrowserSaveStore(storage).value).toEqual({
        version: 1,
        bestScore: 0,
        settings: { vibration: true },
      });
    }

    const unavailable = new MemoryStorage();
    unavailable.failReads = true;
    expect(new BrowserSaveStore(unavailable).value.bestScore).toBe(0);
  });

  it("retains safe in-memory state when persistent writes fail", () => {
    const storage = new MemoryStorage();
    storage.failWrites = true;
    const save = new BrowserSaveStore(storage);

    expect(save.recordScore(42).bestScore).toBe(42);
    expect(save.recordScore(12).bestScore).toBe(42);
    expect(save.setVibration(false).settings.vibration).toBe(false);
  });
});
