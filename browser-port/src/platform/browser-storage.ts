export interface SaveData {
  version: 1;
  bestScore: number;
  settings: {
    vibration: boolean;
  };
}

const STORAGE_KEY = "rooster.save.v1";

const DEFAULT_SAVE: SaveData = {
  version: 1,
  bestScore: 0,
  settings: { vibration: true },
};

function isSaveData(value: unknown): value is SaveData {
  if (typeof value !== "object" || value === null) return false;

  const candidate = value as Partial<SaveData>;
  return (
    candidate.version === 1 &&
    Number.isSafeInteger(candidate.bestScore) &&
    (candidate.bestScore ?? -1) >= 0 &&
    typeof candidate.settings === "object" &&
    candidate.settings !== null &&
    typeof candidate.settings.vibration === "boolean"
  );
}

function cloneSave(save: SaveData): SaveData {
  return {
    version: 1,
    bestScore: save.bestScore,
    settings: { vibration: save.settings.vibration },
  };
}

export class BrowserSaveStore {
  private current = cloneSave(DEFAULT_SAVE);

  constructor(private readonly storage: Storage | null = BrowserSaveStore.findStorage()) {
    this.current = this.read();
  }

  get value(): SaveData {
    return cloneSave(this.current);
  }

  setVibration(enabled: boolean): SaveData {
    return this.commit({
      ...this.current,
      settings: { ...this.current.settings, vibration: enabled },
    });
  }

  recordScore(score: number): SaveData {
    const validScore = Number.isSafeInteger(score) && score >= 0 ? score : 0;
    if (validScore <= this.current.bestScore) return this.value;
    return this.commit({ ...this.current, bestScore: validScore });
  }

  private read(): SaveData {
    if (this.storage === null) return cloneSave(DEFAULT_SAVE);

    try {
      const raw = this.storage.getItem(STORAGE_KEY);
      if (raw === null) return cloneSave(DEFAULT_SAVE);
      const parsed: unknown = JSON.parse(raw);
      return isSaveData(parsed) ? cloneSave(parsed) : cloneSave(DEFAULT_SAVE);
    } catch {
      return cloneSave(DEFAULT_SAVE);
    }
  }

  private commit(next: SaveData): SaveData {
    this.current = cloneSave(next);
    try {
      this.storage?.setItem(STORAGE_KEY, JSON.stringify(this.current));
    } catch {
      // Persistence must never prevent play (private mode and quotas can throw).
    }
    return this.value;
  }

  private static findStorage(): Storage | null {
    try {
      return window.localStorage;
    } catch {
      return null;
    }
  }
}
