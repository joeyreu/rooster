export interface StatusViewModel {
  score: number;
  trafficRemaining: number;
  spareLives: number;
  bestScore: number;
  objective: string;
}

export class StatusView {
  private readonly score = statusElement("status-score");
  private readonly traffic = statusElement("status-traffic");
  private readonly lives = statusElement("status-lives");
  private readonly best = statusElement("status-best");
  private readonly mirror = statusElement("status-mirror");
  private readonly liveRegion = statusElement("live-region");

  update(model: StatusViewModel): void {
    const visibleLives = Math.max(0, model.spareLives);
    this.score.textContent = String(model.score);
    this.traffic.textContent = String(model.trafficRemaining);
    this.lives.textContent = String(visibleLives);
    this.best.textContent = String(model.bestScore);
    this.mirror.textContent = `${model.objective} Score ${model.score}. ${visibleLives} spare ${visibleLives === 1 ? "life" : "lives"}. ${model.trafficRemaining} traffic remaining. Best score ${model.bestScore}.`;
  }

  announce(message: string): void {
    this.liveRegion.textContent = "";
    requestAnimationFrame(() => {
      this.liveRegion.textContent = message;
    });
  }

}

function statusElement(id: string): HTMLElement {
  const element = document.getElementById(id);
  if (element === null) throw new Error(`Required status element #${id} is missing.`);
  return element;
}
