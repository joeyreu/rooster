import { applyCollisionRect, overlapsInclusive } from "../collision";
import { randomInt, randomIntInclusive } from "../rng";
import type {
  GameDefinition,
  GameEvent,
  GameState,
  PickupMessageState,
  PickupState,
  PlayerState,
  RngStates,
} from "../types";

export interface GeneratedPickups {
  pickups: PickupState[];
  rngStates: RngStates;
}

export function generatePickups(
  definition: GameDefinition,
  rngStates: RngStates,
): GeneratedPickups {
  const { rules, level } = definition;
  const worldHeight = level.tileRows.length * rules.rowHeight;
  let pickupRng = rngStates.pickups;
  const pickups: PickupState[] = [];

  for (const kind of rules.pickups.initializationOrder) {
    const rule = rules.pickups.rules.find((candidate) => candidate.kind === kind);
    if (rule === undefined) {
      throw new Error(`missing ${kind} pickup rule`);
    }

    const presenceRoll = randomInt(pickupRng, 100);
    pickupRng = presenceRoll.state;
    const present = presenceRoll.value < rule.presencePercent;
    let x = 0;
    let y = 0;
    let bonus = 0;

    if (present) {
      const xRoll = randomIntInclusive(
        pickupRng,
        rules.pickups.placement.minX,
        rules.pickups.placement.maxX,
      );
      pickupRng = xRoll.state;
      x = xRoll.value;

      const yRoll = randomIntInclusive(
        pickupRng,
        rules.pickups.placement.minY,
        worldHeight - rules.pickups.placement.bottomMargin,
      );
      pickupRng = yRoll.state;
      y = yRoll.value;

      if (kind === "purple") {
        const bonusRoll = randomIntInclusive(
          pickupRng,
          rules.pickups.purpleBonus.min,
          rules.pickups.purpleBonus.max,
        );
        pickupRng = bonusRoll.state;
        bonus = bonusRoll.value;
      }
    }

    pickups.push({
      kind,
      x,
      y,
      width: rules.pickups.size.width,
      height: rules.pickups.size.height,
      present,
      consumed: false,
      animationFrame: 0,
      frameCount: rule.frameCount,
      bonus,
    });
  }

  return {
    pickups,
    rngStates: { ...rngStates, pickups: pickupRng },
  };
}

export function advancePickupAnimation(pickups: PickupState[], advances: number): void {
  for (const pickup of pickups) {
    if (!pickup.present || pickup.consumed) {
      continue;
    }
    pickup.animationFrame = (pickup.animationFrame + advances) % pickup.frameCount;
  }
}

function pickupMessage(
  definition: GameDefinition,
  pickup: PickupState,
  text: string,
): PickupMessageState {
  return {
    kind: pickup.kind,
    text,
    x: pickup.x,
    y: pickup.y,
    ageTicks: 0,
    durationTicks: definition.rules.transitions.pickupMessageTicks,
  };
}

function pickupOverlapsPlayer(
  definition: GameDefinition,
  pickup: PickupState,
  player: PlayerState,
): boolean {
  return overlapsInclusive(applyCollisionRect(player, definition.rules.player.collision), pickup);
}

export function collectOverlappingPickups(
  definition: GameDefinition,
  state: GameState,
  events: GameEvent[],
): void {
  if (!state.player.visible) {
    return;
  }

  for (const kind of definition.rules.pickups.collectionOrder) {
    const pickup = state.pickups.find((candidate) => candidate.kind === kind);
    if (
      pickup === undefined ||
      !pickup.present ||
      pickup.consumed ||
      !pickupOverlapsPlayer(definition, pickup, state.player)
    ) {
      continue;
    }

    pickup.consumed = true;
    let message: string;
    let eventBonus = 0;
    switch (pickup.kind) {
      case "gray":
        state.spareLives += 1;
        message = definition.rules.pickups.rules.find(({ kind }) => kind === "gray")?.message ?? "Free Bird";
        break;
      case "purple":
        state.trafficRemaining += pickup.bonus;
        eventBonus = pickup.bonus;
        message = (
          definition.rules.pickups.rules.find(({ kind }) => kind === "purple")?.message ??
          "Countdown +NN"
        ).replace("NN", String(pickup.bonus));
        break;
      case "orange":
        state.player.speed = definition.rules.player.boostedSpeed;
        message = definition.rules.pickups.rules.find(({ kind }) => kind === "orange")?.message ?? "Speed x2";
        break;
    }

    state.pickupMessages.push(pickupMessage(definition, pickup, message));
    events.push({
      type: "pickupCollected",
      kind: pickup.kind,
      message,
      bonus: eventBonus,
    });
  }
}

export function advancePickupMessages(messages: PickupMessageState[]): PickupMessageState[] {
  const active: PickupMessageState[] = [];
  for (const message of messages) {
    message.ageTicks += 1;
    message.y -= 1;
    if (message.ageTicks < message.durationTicks) {
      active.push(message);
    }
  }
  return active;
}
