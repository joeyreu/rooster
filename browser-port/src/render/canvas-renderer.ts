import type {
  GameState,
  ObstacleState,
  PickupKind,
  TrafficVehicleState,
} from "../core/types";
import { ASSET_CATALOG } from "../data";
import type {
  AssetId,
  AtlasDefinition,
  AtlasFrame,
  GameRules,
  LevelDefinition,
} from "../data";
import type { LoadedAssets } from "./asset-loader";

const LOGICAL_WIDTH = 240;
const LOGICAL_HEIGHT = 160;

type AtlasCollection = Readonly<Record<string, AtlasDefinition>>;

interface RenderSource {
  readonly assetId: AssetId;
  readonly atlas: AtlasDefinition;
}

export class CanvasRenderer {
  private readonly scene = document.createElement("canvas");
  private readonly context: CanvasRenderingContext2D;
  private readonly presentation: CanvasRenderingContext2D;
  private titleFrame = 0;
  private readonly reducedMotion = matchMedia("(prefers-reduced-motion: reduce)");
  private readonly background: RenderSource;
  private readonly player: RenderSource;
  private readonly traffic: RenderSource;
  private readonly obstacle: RenderSource;
  private readonly hudDigits: RenderSource;
  private readonly status: RenderSource;
  private readonly deadPlayerAssetId: AssetId;
  private readonly pickups: Readonly<Record<PickupKind, RenderSource>>;

  constructor(
    private readonly canvas: HTMLCanvasElement,
    private readonly assets: LoadedAssets,
    private readonly rules: GameRules,
    private readonly level: LevelDefinition,
    atlases: AtlasCollection,
  ) {
    this.scene.width = LOGICAL_WIDTH;
    this.scene.height = LOGICAL_HEIGHT;

    const context = this.scene.getContext("2d", { alpha: false });
    const presentation = canvas.getContext("2d", { alpha: false });
    if (context === null || presentation === null) {
      throw new Error("This browser does not provide the Canvas 2D renderer Rooster needs.");
    }

    this.context = context;
    this.presentation = presentation;
    this.context.imageSmoothingEnabled = false;
    this.presentation.imageSmoothingEnabled = false;

    this.background = renderSource(atlases, level.assets.backgroundAtlasId);
    this.player = renderSource(atlases, level.assets.playerAtlasId);
    this.traffic = renderSource(atlases, level.assets.trafficAtlasId);
    this.obstacle = renderSource(atlases, level.assets.obstacleAtlasId);
    this.hudDigits = renderSource(atlases, level.assets.hudDigitsAtlasId);
    this.status = renderSource(atlases, "overlay.gameStatus");
    this.deadPlayerAssetId = requiredAssetId(level.assets.deadPlayerAssetId);
    this.pickups = {
      gray: pickupRenderSource(rules, atlases, "life"),
      orange: pickupRenderSource(rules, atlases, "speed"),
      purple: pickupRenderSource(rules, atlases, "counter"),
    };
  }

  renderTitle(): void {
    this.context.drawImage(this.asset("title.background"), 0, 0);

    this.titleFrame = (this.titleFrame + 1) % 36;
    if (this.reducedMotion.matches || this.titleFrame < 24) {
      this.context.drawImage(this.asset("title.promptMask"), 146, 81);
    }

    this.present();
  }

  renderGame(state: GameState, paused: boolean): void {
    const context = this.context;
    context.fillStyle = "#000";
    context.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    this.drawBackground(state.cameraY);
    if (!this.level.drawObstaclesAboveActors) this.drawObstacles(state);
    this.drawDeadMarkers(state);
    this.drawPickups(state);
    this.drawPlayer(state);
    this.drawTraffic(state);
    if (this.level.drawObstaclesAboveActors) this.drawObstacles(state);
    this.drawHud(state);

    const hasTerminalOverlay = this.drawGameStatusOverlay(state);
    if (!hasTerminalOverlay) this.drawPickupMessages(state);
    if (paused) this.drawPauseTreatment();

    this.present();
  }

  private drawBackground(cameraY: number): void {
    const image = this.asset(this.background.assetId);
    this.level.tileRows.forEach((tileId, rowIndex) => {
      const frame = requiredFrame(this.background.atlas, `tile-${tileId}`);
      this.context.drawImage(
        image,
        frame.x,
        frame.y,
        frame.width,
        frame.height,
        0,
        rowIndex * this.rules.rowHeight - cameraY,
        frame.width,
        frame.height,
      );
    });
  }

  private drawDeadMarkers(state: GameState): void {
    const image = this.asset(this.deadPlayerAssetId);
    for (const marker of state.deadMarkers) {
      this.context.drawImage(image, marker.x, marker.y - state.cameraY);
    }
  }

  private drawPickups(state: GameState): void {
    for (const pickup of state.pickups) {
      if (!pickup.present || pickup.consumed) continue;
      const source = this.pickups[pickup.kind];
      const image = this.asset(source.assetId);
      const atlas = source.atlas;
      const animation = atlas.groups.animation;
      const frameId = animation?.[pickup.animationFrame % pickup.frameCount];
      if (frameId === undefined) throw new Error(`Missing pickup frame for ${pickup.kind}.`);
      const frame = requiredFrame(atlas, frameId);
      const y = pickup.y - state.cameraY;
      this.context.drawImage(
        image,
        frame.x,
        frame.y,
        frame.width,
        frame.height,
        pickup.x,
        y,
        pickup.width,
        pickup.height,
      );
      this.drawPickupMarker(pickup.kind, pickup.x + 7, y - 2);
    }
  }

  private drawPickupMarker(kind: PickupKind, x: number, y: number): void {
    const context = this.context;
    context.save();
    context.strokeStyle = "#fffbe4";
    context.fillStyle = "rgba(8, 12, 10, 0.72)";
    context.lineWidth = 1;
    context.beginPath();
    context.arc(x, y, 4, 0, Math.PI * 2);
    context.fill();
    context.stroke();
    context.strokeStyle = "#fff";

    if (kind === "gray") {
      context.fillStyle = "#fff";
      context.font = "bold 6px sans-serif";
      context.textAlign = "center";
      context.textBaseline = "middle";
      context.fillText("♥", x, y + 0.5);
    } else if (kind === "orange") {
      context.beginPath();
      context.moveTo(x - 2.5, y - 2);
      context.lineTo(x, y);
      context.lineTo(x - 2.5, y + 2);
      context.moveTo(x, y - 2);
      context.lineTo(x + 2.5, y);
      context.lineTo(x, y + 2);
      context.stroke();
    } else {
      context.beginPath();
      context.moveTo(x - 2.5, y);
      context.lineTo(x + 2.5, y);
      context.moveTo(x, y - 2.5);
      context.lineTo(x, y + 2.5);
      context.stroke();
    }
    context.restore();
  }

  private drawPlayer(state: GameState): void {
    if (!state.player.visible) return;
    const frames = this.player.atlas.groups[state.player.facing];
    const frameId = frames?.[state.player.animationStep % (frames.length || 1)];
    if (frameId === undefined) throw new Error(`Missing player frames for ${state.player.facing}.`);
    const frame = requiredFrame(this.player.atlas, frameId);
    this.context.drawImage(
      this.asset(this.player.assetId),
      frame.x,
      frame.y,
      frame.width,
      frame.height,
      state.player.x,
      state.player.y - state.cameraY,
      state.player.width,
      state.player.height,
    );
  }

  private drawTraffic(state: GameState): void {
    const image = this.asset(this.traffic.assetId);
    for (const vehicle of state.traffic) {
      if (!vehicle.active) continue;
      this.drawVehicle(image, vehicle, state.cameraY);
    }
  }

  private drawVehicle(
    image: HTMLImageElement,
    vehicle: TrafficVehicleState,
    cameraY: number,
  ): void {
    const frameId = this.traffic.atlas.groups.poolCycle?.[vehicle.frameIndex];
    if (frameId === undefined) throw new Error(`Missing traffic frame ${vehicle.frameIndex}.`);
    const frame = requiredFrame(this.traffic.atlas, frameId);
    const y = vehicle.y - cameraY;
    if (vehicle.speed < 0) {
      this.context.drawImage(
        image,
        frame.x,
        frame.y,
        frame.width,
        frame.height,
        vehicle.x,
        y,
        vehicle.width,
        vehicle.height,
      );
      return;
    }

    this.context.save();
    this.context.translate(vehicle.x + vehicle.width, y);
    this.context.scale(-1, 1);
    this.context.drawImage(
      image,
      frame.x,
      frame.y,
      frame.width,
      frame.height,
      0,
      0,
      vehicle.width,
      vehicle.height,
    );
    this.context.restore();
  }

  private drawObstacles(state: GameState): void {
    const image = this.asset(this.obstacle.assetId);
    for (const obstacle of state.obstacles) this.drawObstacle(image, obstacle, state.cameraY);
  }

  private drawObstacle(
    image: HTMLImageElement,
    obstacle: ObstacleState,
    cameraY: number,
  ): void {
    const frameId = this.obstacle.atlas.groups.typeIndex?.[obstacle.type];
    if (frameId === undefined) throw new Error(`Missing obstacle frame ${obstacle.type}.`);
    const frame = requiredFrame(this.obstacle.atlas, frameId);
    this.context.drawImage(
      image,
      frame.x,
      frame.y,
      frame.width,
      frame.height,
      obstacle.x,
      obstacle.y - cameraY,
      obstacle.width,
      obstacle.height,
    );
  }

  private drawHud(state: GameState): void {
    const panel = this.asset("hud.scorePanel");
    this.context.drawImage(panel, 0, 0);
    this.context.save();
    this.context.translate(LOGICAL_WIDTH, 0);
    this.context.scale(-1, 1);
    this.context.drawImage(panel, 0, 0);
    this.context.restore();
    this.context.drawImage(this.asset("hud.bottomLeft"), 0, 144);

    const digits = this.asset(this.hudDigits.assetId);
    this.drawNumber(digits, state.score, 1, 1, "left");
    this.drawNumber(digits, state.trafficRemaining, 242, 1, "right");
    this.drawNumber(digits, Math.max(0, state.spareLives), 17, 149, "left");
  }

  private drawNumber(
    image: HTMLImageElement,
    value: number,
    x: number,
    y: number,
    align: "left" | "right",
  ): void {
    const text = String(Math.max(0, Math.trunc(value)));
    const digitWidth = requiredFrame(this.hudDigits.atlas, "0").width;
    // The recovered HUD offsets the string, then RIGHT-anchors every glyph.
    const startX = align === "right" ? x - (text.length + 1) * digitWidth : x;
    for (let index = 0; index < text.length; index += 1) {
      const digit = Number(text[index]);
      const frame = requiredFrame(this.hudDigits.atlas, String(digit));
      this.context.drawImage(
        image,
        frame.x,
        frame.y,
        frame.width,
        frame.height,
        startX + index * frame.width,
        y,
        frame.width,
        frame.height,
      );
    }
  }

  private drawPickupMessages(state: GameState): void {
    const context = this.context;
    context.save();
    context.font = "bold 9px sans-serif";
    context.textAlign = "center";
    context.textBaseline = "bottom";
    for (const message of state.pickupMessages) {
      const y = message.y - state.cameraY;
      context.lineWidth = 3;
      context.strokeStyle = "rgba(255, 255, 255, 0.88)";
      context.fillStyle = "#080b09";
      context.strokeText(message.text, message.x, y);
      context.fillText(message.text, message.x, y);
    }
    context.restore();
  }

  private drawGameStatusOverlay(state: GameState): boolean {
    let frameId: "levelComplete" | "youLose" | "counterZero" | null = null;
    if (state.phase === "levelComplete") frameId = "levelComplete";
    else if (state.phase === "gameOver") frameId = "youLose";
    else if (state.phase === "dying" && state.lastDeathCause === "counterZero") {
      frameId = "counterZero";
    }
    if (frameId === null) return false;

    const frame = requiredFrame(this.status.atlas, frameId);
    this.context.drawImage(
      this.asset(this.status.assetId),
      frame.x,
      frame.y,
      frame.width,
      frame.height,
      LOGICAL_WIDTH / 2 - Math.trunc(frame.width / 2),
      LOGICAL_HEIGHT / 2 - Math.trunc(frame.height / 2),
      frame.width,
      frame.height,
    );
    return true;
  }

  private drawPauseTreatment(): void {
    this.context.save();
    this.context.fillStyle = "rgba(4, 7, 6, 0.46)";
    this.context.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
    this.context.restore();
  }

  private asset(id: AssetId): HTMLImageElement {
    const image = this.assets.get(id);
    if (image === undefined) throw new Error(`Required image ${id} was not preloaded.`);
    return image;
  }

  private present(): void {
    const ratio = window.devicePixelRatio || 1;
    const width = Math.max(1, Math.round(this.canvas.clientWidth * ratio));
    const height = Math.max(1, Math.round(this.canvas.clientHeight * ratio));
    if (this.canvas.width !== width || this.canvas.height !== height) {
      this.canvas.width = width;
      this.canvas.height = height;
      this.presentation.imageSmoothingEnabled = false;
    }
    this.presentation.imageSmoothingEnabled = false;
    this.presentation.fillStyle = "#000";
    this.presentation.fillRect(0, 0, width, height);

    // Keep an exact 3:2 destination inside a rounded DPR backing store. At
    // fractional-fit widths this may leave a one-pixel letterbox instead of
    // independently stretching the two axes.
    let destinationWidth = Math.min(width, Math.floor((height * 3) / 2));
    destinationWidth -= destinationWidth % 3;
    const destinationHeight = Math.max(1, (destinationWidth / 3) * 2);
    if (destinationWidth < 3) return;
    const destinationX = Math.floor((width - destinationWidth) / 2);
    const destinationY = Math.floor((height - destinationHeight) / 2);
    this.presentation.drawImage(
      this.scene,
      destinationX,
      destinationY,
      destinationWidth,
      destinationHeight,
    );
  }
}

function requiredAtlas(atlases: AtlasCollection, id: string): AtlasDefinition {
  const atlas = atlases[id];
  if (atlas === undefined) throw new Error(`Required atlas ${id} is missing.`);
  return atlas;
}

function requiredAssetId(id: string): AssetId {
  if (!Object.prototype.hasOwnProperty.call(ASSET_CATALOG, id)) {
    throw new Error(`Required asset ${id} is missing from the catalog.`);
  }
  return id as AssetId;
}

function renderSource(atlases: AtlasCollection, atlasId: string): RenderSource {
  const atlas = requiredAtlas(atlases, atlasId);
  return { atlas, assetId: requiredAssetId(atlas.assetId) };
}

function pickupRenderSource(
  rules: GameRules,
  atlases: AtlasCollection,
  id: "life" | "speed" | "counter",
): RenderSource {
  const pickup = rules.pickups.find((candidate) => candidate.id === id);
  if (pickup === undefined) throw new Error(`Required pickup ${id} is missing.`);
  const atlas = requiredAtlas(atlases, pickup.atlasId);
  const assetId = requiredAssetId(pickup.assetId);
  if (atlas.assetId !== assetId) {
    throw new Error(`Pickup ${id} atlas and asset IDs do not agree.`);
  }
  return { atlas, assetId };
}

function requiredFrame(atlas: AtlasDefinition, frameId: string): AtlasFrame {
  const frame = atlas.frames.find(({ id }) => id === frameId);
  if (frame === undefined) throw new Error(`Atlas ${atlas.id} is missing frame ${frameId}.`);
  return frame;
}

export function renderBoot(
  canvas: HTMLCanvasElement,
  loaded: number,
  total: number,
  assets?: LoadedAssets,
): void {
  const context = canvas.getContext("2d", { alpha: false });
  if (context === null) return;

  canvas.width = LOGICAL_WIDTH;
  canvas.height = LOGICAL_HEIGHT;
  context.imageSmoothingEnabled = false;
  context.fillStyle = "#060806";
  context.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

  const progress = total === 0 ? 0 : loaded / total;
  const background = assets?.get("loading.background");
  const frame = assets?.get("loading.bar");

  if (background !== undefined && frame !== undefined) {
    context.drawImage(background, 46, 67);
    context.fillStyle = "#000";
    context.fillRect(51, 70, 137, 19);
    context.fillStyle = "#900101";
    context.fillRect(51, 70, Math.max(0, Math.floor(137 * progress) - 1), 19);
    context.drawImage(frame, 51, 70);
    return;
  }

  context.fillStyle = "#202720";
  context.fillRect(32, 75, 176, 10);
  context.fillStyle = "#f2b83f";
  context.fillRect(34, 77, Math.floor(172 * progress), 6);
  context.fillStyle = "#f5f0d7";
  context.font = "bold 8px monospace";
  context.textAlign = "center";
  context.fillText(total === 0 ? "LOADING" : `LOADING ${loaded}/${total}`, 120, 69);
}
