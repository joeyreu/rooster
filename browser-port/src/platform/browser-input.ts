import type { Direction, HeldDirection, InputSnapshot } from "../core/types";

interface ActiveSource extends HeldDirection {
  button?: HTMLButtonElement;
  oneShot?: boolean;
  sampled?: boolean;
}

export interface BrowserInputOptions {
  wrapper: HTMLElement;
  directionButtons: readonly HTMLButtonElement[];
  hasRun: () => boolean;
  isMovementActive: () => boolean;
  onPauseToggle: () => void;
  onConfirm: () => void;
}

const KEY_DIRECTIONS: Readonly<Record<string, Direction>> = {
  ArrowUp: "up",
  KeyW: "up",
  ArrowRight: "right",
  KeyD: "right",
  KeyL: "right",
  ArrowDown: "down",
  KeyS: "down",
  ArrowLeft: "left",
  KeyA: "left",
  KeyK: "left",
};

function isTextEntry(target: EventTarget | null): boolean {
  if (target instanceof HTMLTextAreaElement) return true;
  if (target instanceof HTMLElement && target.isContentEditable) return true;
  if (!(target instanceof HTMLInputElement)) return false;

  return !new Set([
    "button",
    "checkbox",
    "color",
    "file",
    "hidden",
    "image",
    "radio",
    "range",
    "reset",
    "submit",
  ]).has(target.type);
}

export class BrowserInput {
  private readonly sources = new Map<string, ActiveSource>();
  private order = 0;

  constructor(private readonly options: BrowserInputOptions) {
    window.addEventListener("keydown", this.onKeyDown);
    window.addEventListener("keyup", this.onKeyUp);
    window.addEventListener("blur", this.clear);
    for (const button of options.directionButtons) {
      button.addEventListener("pointerdown", this.onPointerDown);
      button.addEventListener("pointerup", this.onPointerUp);
      button.addEventListener("pointercancel", this.onPointerCancel);
      button.addEventListener("lostpointercapture", this.onPointerCancel);
      button.addEventListener("click", this.onButtonClick);
      button.addEventListener("contextmenu", this.preventContextMenu);
    }
  }

  snapshot(): InputSnapshot {
    const activeSources = [...this.sources.values()];
    const snapshot = {
      heldDirections: activeSources.map(
        ({ sourceId, direction, pressedOrder }): HeldDirection => ({
          sourceId,
          direction,
          pressedOrder,
        }),
      ),
    };
    for (const source of activeSources) {
      if (source.oneShot === true) this.sources.delete(source.sourceId);
      else source.sampled = true;
    }
    return snapshot;
  }

  readonly clear = (): void => {
    for (const source of this.sources.values()) source.button?.removeAttribute("data-active");
    this.sources.clear();
  };

  destroy(): void {
    this.clear();
    window.removeEventListener("keydown", this.onKeyDown);
    window.removeEventListener("keyup", this.onKeyUp);
    window.removeEventListener("blur", this.clear);
    for (const button of this.options.directionButtons) {
      button.removeEventListener("pointerdown", this.onPointerDown);
      button.removeEventListener("pointerup", this.onPointerUp);
      button.removeEventListener("pointercancel", this.onPointerCancel);
      button.removeEventListener("lostpointercapture", this.onPointerCancel);
      button.removeEventListener("click", this.onButtonClick);
      button.removeEventListener("contextmenu", this.preventContextMenu);
    }
  }

  private readonly onKeyDown = (event: KeyboardEvent): void => {
    if ((event.code === "Escape" || event.code === "KeyP") && !event.repeat) {
      if (this.options.hasRun() && !isTextEntry(event.target)) {
        event.preventDefault();
        this.options.onPauseToggle();
      }
      return;
    }

    if (isTextEntry(event.target) || event.target instanceof HTMLButtonElement) return;

    if ((event.code === "Enter" || event.code === "Space") && !event.repeat) {
      const ownsFocus =
        event.target === document.body || event.target === this.options.wrapper;
      if (!this.options.hasRun() && ownsFocus) {
        event.preventDefault();
        this.options.onConfirm();
      }
      return;
    }

    const direction = KEY_DIRECTIONS[event.code];
    if (
      direction === undefined ||
      !this.options.isMovementActive() ||
      document.activeElement !== this.options.wrapper
    ) {
      return;
    }
    event.preventDefault();

    const sourceId = `key:${event.code}`;
    if (!this.sources.has(sourceId)) {
      this.sources.set(sourceId, {
        sourceId,
        direction,
        pressedOrder: ++this.order,
      });
    }
  };

  private readonly onKeyUp = (event: KeyboardEvent): void => {
    const direction = KEY_DIRECTIONS[event.code];
    if (direction === undefined) return;
    this.sources.delete(`key:${event.code}`);
  };

  private readonly onPointerDown = (event: PointerEvent): void => {
    if (!this.options.isMovementActive()) return;
    const button = event.currentTarget as HTMLButtonElement;
    const direction = button.dataset.direction as Direction | undefined;
    if (direction === undefined) return;

    event.preventDefault();
    button.setPointerCapture(event.pointerId);
    button.dataset.active = "true";
    this.sources.set(`pointer:${event.pointerId}`, {
      sourceId: `pointer:${event.pointerId}`,
      direction,
      pressedOrder: ++this.order,
      button,
      sampled: false,
    });
  };

  private readonly onPointerUp = (event: PointerEvent): void => {
    const sourceId = `pointer:${event.pointerId}`;
    const source = this.sources.get(sourceId);
    source?.button?.removeAttribute("data-active");
    if (source?.sampled === true) {
      this.sources.delete(sourceId);
    } else if (source !== undefined) {
      delete source.button;
      source.oneShot = true;
    }
    if (this.options.isMovementActive()) this.options.wrapper.focus({ preventScroll: true });
  };

  private readonly onPointerCancel = (event: PointerEvent): void => {
    const sourceId = `pointer:${event.pointerId}`;
    const source = this.sources.get(sourceId);
    if (source?.oneShot === true) return;
    source?.button?.removeAttribute("data-active");
    this.sources.delete(sourceId);
  };

  private readonly onButtonClick = (event: MouseEvent): void => {
    if (event.detail !== 0 || !this.options.isMovementActive()) return;
    const button = event.currentTarget as HTMLButtonElement;
    const direction = button.dataset.direction as Direction | undefined;
    if (direction === undefined) return;

    const sourceId = `activation:${direction}`;
    this.sources.set(sourceId, {
      sourceId,
      direction,
      pressedOrder: ++this.order,
      oneShot: true,
    });
  };

  private readonly preventContextMenu = (event: Event): void => event.preventDefault();
}
