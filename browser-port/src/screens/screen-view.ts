export type ScreenAction =
  | "retry"
  | "start"
  | "resume"
  | "newGame"
  | "quit"
  | "replay"
  | "title";

export interface ResultsViewModel {
  outcome: "win" | "loss";
  score: number;
  bestScore: number;
  isNewBest: boolean;
}

interface ScreenButton {
  action: ScreenAction;
  label: string;
  style: "primary" | "secondary";
  focus?: boolean;
}

interface ScreenContent {
  kind: "loading" | "error" | "title" | "pause" | "results";
  kicker: string;
  title: string;
  copy: string;
  buttons: readonly ScreenButton[];
}

export class ScreenView {
  private readonly layer: HTMLElement;
  private readonly panel: HTMLElement;
  private readonly kicker: HTMLElement;
  private readonly title: HTMLElement;
  private readonly copy: HTMLElement;
  private readonly actions: HTMLElement;
  private readonly dialog: HTMLDialogElement;
  private readonly confirmTitle: HTMLElement;
  private readonly confirmCopy: HTMLElement;
  private readonly confirmAction: HTMLButtonElement;
  private invokedBy: HTMLElement | null = null;

  constructor(private readonly onAction: (action: ScreenAction) => void) {
    this.layer = requiredElement("menu-layer");
    this.panel = requiredElement("menu-panel");
    this.kicker = requiredElement("menu-kicker");
    this.title = requiredElement("menu-title");
    this.copy = requiredElement("menu-copy");
    this.actions = requiredElement("menu-actions");
    this.dialog = requiredElement("confirm-dialog", HTMLDialogElement);
    this.confirmTitle = requiredElement("confirm-title");
    this.confirmCopy = requiredElement("confirm-copy");
    this.confirmAction = requiredElement("confirm-action", HTMLButtonElement);
    this.dialog.addEventListener("close", this.onDialogClose);
    this.dialog.addEventListener("cancel", this.onDialogCancel);
    this.layer.addEventListener("click", (event) => {
      const target = event.target;
      const tappedInteractiveElement =
        target instanceof Element &&
        target.closest("button, a, input, label, select, textarea, summary") !== null;
      if (this.layer.dataset.kind === "title" && !tappedInteractiveElement) {
        this.onAction("start");
      }
    });
  }

  showLoading(loaded: number, total: number, focusStatus = false): void {
    const copy = total === 0 ? "Preparing the original artwork." : `Loading ${loaded} of ${total}.`;
    this.show({
      kind: "loading",
      kicker: "Restoring the road…",
      title: "Loading",
      copy,
      buttons: [],
    });
    if (focusStatus) requestAnimationFrame(() => this.panel.focus());
  }

  showLoadError(assetLabel: string): void {
    this.show({
      kind: "error",
      kicker: "Asset check failed",
      title: "Couldn’t load Rooster",
      copy: `The original asset “${assetLabel}” could not be prepared.`,
      buttons: [{ action: "retry", label: "Retry", style: "primary", focus: true }],
    });
  }

  showTitle(): void {
    this.show({
      kind: "title",
      kicker: "Level 1 restoration",
      title: "Ready to cross?",
      copy: "Reach the top before your traffic counter runs out.",
      buttons: [{ action: "start", label: "Start game", style: "primary", focus: true }],
    });
  }

  showPause(): void {
    this.show({
      kind: "pause",
      kicker: "Run suspended",
      title: "Paused",
      copy: "The road is frozen exactly where you left it.",
      buttons: [
        { action: "resume", label: "Resume", style: "primary", focus: true },
        { action: "newGame", label: "New game", style: "secondary" },
        { action: "quit", label: "Title", style: "secondary" },
      ],
    });
  }

  showResults(model: ResultsViewModel): void {
    const outcomeTitle = model.outcome === "win" ? "Road crossed!" : "Run over";
    const bestCopy = model.isNewBest ? " New best score." : ` Best: ${model.bestScore}.`;
    this.show({
      kind: "results",
      kicker: model.outcome === "win" ? "Level 1 complete" : "Game over",
      title: outcomeTitle,
      copy: `Score: ${model.score}.${bestCopy}`,
      buttons: [
        { action: "replay", label: "Replay", style: "primary", focus: true },
        { action: "title", label: "Title", style: "secondary" },
      ],
    });
  }

  hide(): void {
    this.layer.hidden = true;
    this.actions.replaceChildren();
  }

  confirmNewGame(invoker: HTMLElement): void {
    this.showConfirmation(
      invoker,
      "Start a new run?",
      "Your current progress will be lost.",
      "Start over",
      "newGame",
    );
  }

  confirmQuit(invoker: HTMLElement): void {
    this.showConfirmation(
      invoker,
      "Return to the title?",
      "Your current progress will be lost.",
      "Leave run",
      "quit",
    );
  }

  private show(content: ScreenContent): void {
    this.layer.hidden = false;
    this.layer.dataset.kind = content.kind;
    this.kicker.textContent = content.kicker;
    this.title.textContent = content.title;
    this.copy.textContent = content.copy;
    this.actions.replaceChildren(
      ...content.buttons.map((button) => {
        const element = document.createElement("button");
        element.type = "button";
        element.className = button.style === "primary" ? "primary-button" : "secondary-button";
        element.dataset.action = button.action;
        element.textContent = button.label;
        element.addEventListener("click", () => {
          if (content.kind === "pause" && button.action === "newGame") {
            this.confirmNewGame(element);
          } else if (content.kind === "pause" && button.action === "quit") {
            this.confirmQuit(element);
          } else {
            this.onAction(button.action);
          }
        });
        if (button.focus === true) requestAnimationFrame(() => element.focus());
        return element;
      }),
    );
  }

  private showConfirmation(
    invoker: HTMLElement,
    title: string,
    copy: string,
    actionLabel: string,
    action: "newGame" | "quit",
  ): void {
    this.invokedBy = invoker;
    this.confirmTitle.textContent = title;
    this.confirmCopy.textContent = copy;
    this.confirmAction.textContent = actionLabel;
    this.confirmAction.dataset.confirmAction = action;
    this.dialog.showModal();
  }

  private readonly onDialogClose = (): void => {
    const action = this.confirmAction.dataset.confirmAction;
    if (this.dialog.returnValue === "confirm" && (action === "newGame" || action === "quit")) {
      this.onAction(action);
    } else {
      this.invokedBy?.focus();
    }
    this.invokedBy = null;
  };

  private readonly onDialogCancel = (): void => {
    this.dialog.returnValue = "cancel";
  };
}

export function requiredElement<T extends HTMLElement>(
  id: string,
  constructor?: abstract new (...args: never[]) => T,
): T {
  const element = document.getElementById(id);
  if (element === null || (constructor !== undefined && !(element instanceof constructor))) {
    throw new Error(`Required interface element #${id} is missing or has the wrong type.`);
  }
  return element as T;
}
