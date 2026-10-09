import type { Direction, HeldDirection, InputSnapshot } from "../core/types";

interface ActiveSource extends HeldDirection {
  button?: HTMLButtonElement;
  oneShot?: boolean;
  sampled?: boolean;
}

export interface BrowserInputOptions {
  wrapper: HTMLElement;
  directionPad: HTMLElement;
  directionButtons: readonly HTMLButtonElement[];
  hasRun: () => boolean;
  isMovementActive: () => boolean;
  onPauseToggle: () => void;
  onConfirm: () => void;
  onFocusConfirm?: () => void;
  isAnyKeyConfirmActive?: () => boolean;
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

function isUnmodifiedConfirmationKey(event: KeyboardEvent): boolean {
  return (
    event.key !== "Tab" &&
    event.key !== "Shift" &&
    event.key !== "Control" &&
    event.key !== "Alt" &&
    event.key !== "Meta" &&
    !event.shiftKey &&
    !event.ctrlKey &&
    !event.altKey &&
    !event.metaKey
  );
}

export class BrowserInput {
  private readonly sources = new Map<string, ActiveSource>();
  private readonly activePointerIds = new Set<number>();
  private readonly buttonsByDirection = new Map<Direction, HTMLButtonElement>();
  private order = 0;

  constructor(private readonly options: BrowserInputOptions) {
    window.addEventListener("keydown", this.onKeyDown);
    window.addEventListener("keyup", this.onKeyUp);
    window.addEventListener("blur", this.clear);
    options.directionPad.addEventListener("pointerdown", this.onPointerDown);
    options.directionPad.addEventListener("pointermove", this.onPointerMove);
    options.directionPad.addEventListener("pointerup", this.onPointerUp);
    options.directionPad.addEventListener("pointercancel", this.onPointerCancel);
    options.directionPad.addEventListener("lostpointercapture", this.onPointerCancel);
    options.directionPad.addEventListener("contextmenu", this.preventContextMenu);
    for (const button of options.directionButtons) {
      const direction = button.dataset.direction as Direction | undefined;
      if (direction !== undefined) this.buttonsByDirection.set(direction, button);
      button.addEventListener("click", this.onButtonClick);
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
    const capturedPointers = [...this.activePointerIds];
    this.activePointerIds.clear();
    this.sources.clear();
    this.syncPointerButtonStates();
    for (const pointerId of capturedPointers) {
      if (this.options.directionPad.hasPointerCapture(pointerId)) {
        this.options.directionPad.releasePointerCapture(pointerId);
      }
    }
  };

  destroy(): void {
    this.clear();
    window.removeEventListener("keydown", this.onKeyDown);
    window.removeEventListener("keyup", this.onKeyUp);
    window.removeEventListener("blur", this.clear);
    this.options.directionPad.removeEventListener("pointerdown", this.onPointerDown);
    this.options.directionPad.removeEventListener("pointermove", this.onPointerMove);
    this.options.directionPad.removeEventListener("pointerup", this.onPointerUp);
    this.options.directionPad.removeEventListener("pointercancel", this.onPointerCancel);
    this.options.directionPad.removeEventListener("lostpointercapture", this.onPointerCancel);
    this.options.directionPad.removeEventListener("contextmenu", this.preventContextMenu);
    for (const button of this.options.directionButtons) {
      button.removeEventListener("click", this.onButtonClick);
    }
  }

  private readonly onKeyDown = (event: KeyboardEvent): void => {
    const ownsFocus =
      event.target === document.body || event.target === this.options.wrapper;
    const anyKeyConfirmActive = this.options.isAnyKeyConfirmActive?.() === true;
    if (
      !event.repeat &&
      event.code === "Tab" &&
      !event.shiftKey &&
      !event.ctrlKey &&
      !event.altKey &&
      !event.metaKey &&
      ownsFocus &&
      anyKeyConfirmActive
    ) {
      event.preventDefault();
      this.options.onFocusConfirm?.();
      return;
    }
    if (
      !event.repeat &&
      ownsFocus &&
      !isTextEntry(event.target) &&
      !(event.target instanceof HTMLButtonElement) &&
      isUnmodifiedConfirmationKey(event) &&
      anyKeyConfirmActive
    ) {
      event.preventDefault();
      this.options.onConfirm();
      return;
    }

    if ((event.code === "Escape" || event.code === "KeyP") && !event.repeat) {
      if (this.options.hasRun() && !isTextEntry(event.target)) {
        event.preventDefault();
        this.options.onPauseToggle();
      }
      return;
    }

    if (isTextEntry(event.target) || event.target instanceof HTMLButtonElement) return;

    if (
      (event.code === "Enter" || event.code === "Space" || event.code === "Digit0") &&
      !event.repeat
    ) {
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
    if (event.button !== 0 || !this.options.isMovementActive()) return;

    event.preventDefault();
    this.activePointerIds.add(event.pointerId);
    this.options.directionPad.setPointerCapture(event.pointerId);
    this.updatePointerDirection(event.pointerId, this.directionAt(event.clientX, event.clientY));
  };

  private readonly onPointerMove = (event: PointerEvent): void => {
    if (!this.activePointerIds.has(event.pointerId)) return;
    event.preventDefault();
    this.updatePointerDirection(event.pointerId, this.directionAt(event.clientX, event.clientY));
  };

  private readonly onPointerUp = (event: PointerEvent): void => {
    if (!this.activePointerIds.delete(event.pointerId)) return;
    this.updatePointerDirection(event.pointerId, this.directionAt(event.clientX, event.clientY));
    const sourceId = `pointer:${event.pointerId}`;
    const source = this.sources.get(sourceId);
    if (source?.sampled === true) {
      this.sources.delete(sourceId);
    } else if (source !== undefined) {
      delete source.button;
      source.oneShot = true;
    }
    this.syncPointerButtonStates();
    if (this.options.isMovementActive()) this.options.wrapper.focus({ preventScroll: true });
  };

  private readonly onPointerCancel = (event: PointerEvent): void => {
    if (!this.activePointerIds.delete(event.pointerId)) return;
    const sourceId = `pointer:${event.pointerId}`;
    this.sources.delete(sourceId);
    this.syncPointerButtonStates();
  };

  private updatePointerDirection(pointerId: number, direction: Direction | undefined): void {
    const sourceId = `pointer:${pointerId}`;
    const source = this.sources.get(sourceId);
    if (source !== undefined && source.direction === direction && source.oneShot !== true) return;

    if (direction === undefined) {
      this.sources.delete(sourceId);
    } else {
      const button = this.buttonsByDirection.get(direction);
      if (button === undefined) throw new Error(`Missing D-pad button for ${direction}.`);
      this.sources.set(sourceId, {
        sourceId,
        direction,
        pressedOrder: ++this.order,
        button,
        sampled: false,
      });
    }
    this.syncPointerButtonStates();
  }

  private directionAt(clientX: number, clientY: number): Direction | undefined {
    const bounds = this.options.directionPad.getBoundingClientRect();
    if (
      bounds.width <= 0 ||
      bounds.height <= 0 ||
      clientX < bounds.left ||
      clientX > bounds.right ||
      clientY < bounds.top ||
      clientY > bounds.bottom
    ) {
      return undefined;
    }

    const offsetX = clientX - (bounds.left + bounds.width / 2);
    const offsetY = clientY - (bounds.top + bounds.height / 2);
    if (Math.abs(offsetX) <= bounds.width / 6 && Math.abs(offsetY) <= bounds.height / 6) {
      return undefined;
    }

    const horizontalDistance = Math.abs(offsetX) / bounds.width;
    const verticalDistance = Math.abs(offsetY) / bounds.height;
    if (horizontalDistance > verticalDistance) return offsetX < 0 ? "left" : "right";
    return offsetY < 0 ? "up" : "down";
  }

  private syncPointerButtonStates(): void {
    for (const button of this.options.directionButtons) button.removeAttribute("data-active");
    for (const source of this.sources.values()) {
      source.button?.setAttribute("data-active", "true");
    }
  }

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
