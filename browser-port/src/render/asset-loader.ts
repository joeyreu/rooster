import {
  FIRST_PASS_ASSET_IDS,
  getAsset,
  type AssetCatalogEntry,
  type AssetId,
} from "../data";
import { CAMPAIGN_ASSET_IDS } from "../data/assets";

export type LoadedAssets = ReadonlyMap<AssetId, HTMLImageElement>;

const LOADING_ASSET_IDS = [
  "loading.background",
  "loading.bar",
] as const satisfies readonly AssetId[];
const LOADING_ASSET_ID_SET = new Set<AssetId>(LOADING_ASSET_IDS);

/**
 * Keep the original public loader name while expanding its payload to cover
 * every image that the full recovered campaign can request.
 */
export const PRELOAD_ASSET_IDS: readonly AssetId[] = Object.freeze([
  ...new Set<AssetId>([...FIRST_PASS_ASSET_IDS, ...CAMPAIGN_ASSET_IDS]),
]);

export class AssetLoadError extends Error {
  constructor(
    readonly asset: AssetCatalogEntry,
    cause?: unknown,
  ) {
    super(`Could not load ${asset.id} from ${asset.url}`, { cause });
    this.name = "AssetLoadError";
  }
}

export async function loadFirstPassAssets(
  onProgress: (loaded: number, total: number) => void,
  onAssetLoaded?: (assetId: AssetId, image: HTMLImageElement) => void,
): Promise<LoadedAssets> {
  const total = PRELOAD_ASSET_IDS.length;
  const images = new Map<AssetId, HTMLImageElement>();
  let loaded = 0;
  onProgress(loaded, total);

  const loadBatch = async (assetIds: readonly AssetId[]): Promise<void> => {
    await Promise.all(
      assetIds.map(async (assetId) => {
        const asset = getAsset(assetId);
        const image = await loadOne(asset);
        images.set(assetId, image);
        onAssetLoaded?.(assetId, image);
        loaded += 1;
        onProgress(loaded, total);
      }),
    );
  };

  await loadBatch(LOADING_ASSET_IDS);
  await loadBatch(
    PRELOAD_ASSET_IDS.filter((assetId) => !LOADING_ASSET_ID_SET.has(assetId)),
  );

  return images;
}

async function loadOne(asset: AssetCatalogEntry): Promise<HTMLImageElement> {
  const image = new Image();
  image.decoding = "async";

  await new Promise<void>((resolve, reject) => {
    image.addEventListener("load", () => resolve(), { once: true });
    image.addEventListener(
      "error",
      () => reject(new AssetLoadError(asset)),
      { once: true },
    );
    image.src = asset.url;
  });

  if (image.naturalWidth !== asset.width || image.naturalHeight !== asset.height) {
    throw new AssetLoadError(
      asset,
      new Error(
        `Expected ${asset.width}×${asset.height}, received ${image.naturalWidth}×${image.naturalHeight}.`,
      ),
    );
  }

  return image;
}
