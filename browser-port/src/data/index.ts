import atlasesDocument from "../../game-data/v1/atlases.json";
import levelsDocument from "../../game-data/v1/levels.json";

import { assertValidGameData } from "./validate";

const rawGameData: unknown = {
  version: levelsDocument.version,
  rules: levelsDocument.rules,
  levels: levelsDocument.levels,
  atlases: atlasesDocument.atlases,
};

if (atlasesDocument.version !== levelsDocument.version) {
  throw new Error(
    `Mismatched game-data versions: levels=${levelsDocument.version}, atlases=${atlasesDocument.version}`,
  );
}

assertValidGameData(rawGameData);

export const GAME_DATA = rawGameData;
export const LEVELS = GAME_DATA.levels;
export const LEVEL_ONE = GAME_DATA.levels[0]!;
export const LEVELS_BY_NUMBER = Object.freeze(
  Object.fromEntries(LEVELS.map((level) => [level.displayNumber, level])),
);
export const ATLASES = Object.freeze(
  Object.fromEntries(GAME_DATA.atlases.map((atlas) => [atlas.id, atlas])),
);

export { assertValidGameData, validateGameData } from "./validate";
export type {
  AtlasDefinition,
  AtlasFrame,
  GameDataV1,
  GameRules,
  LevelDefinition,
  PickupDefinition,
  Rectangle,
  Size,
  ValidationIssue,
  ValidationResult,
} from "./types";
export type { AssetCatalogEntry, AssetId } from "./assets";
export { ASSET_CATALOG, FIRST_PASS_ASSET_IDS, getAsset } from "./assets";
