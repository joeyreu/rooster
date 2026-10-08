export class BrowserHaptics {
  constructor(private enabled = true) {}

  setEnabled(enabled: boolean): void {
    this.enabled = enabled;
  }

  deathBuzz(milliseconds = 500): void {
    if (!this.enabled || typeof navigator.vibrate !== "function") return;
    try {
      navigator.vibrate(milliseconds);
    } catch {
      // Vibration is an optional enhancement and may be blocked by the browser.
    }
  }
}
