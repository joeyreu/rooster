import { createHash } from "node:crypto";
import { readFileSync } from "node:fs";
import { fileURLToPath } from "node:url";

import { describe, expect, it } from "vitest";

import manifest from "../../../recovered/assets/manifest.json";
import {
  ASSET_CATALOG,
  CAMPAIGN_ASSET_IDS,
  FIRST_PASS_ASSET_IDS,
  getAsset,
} from "../../src/data/assets";
import { PRELOAD_ASSET_IDS } from "../../src/render/asset-loader";

const workspaceRoot = fileURLToPath(new URL("../../../", import.meta.url));

describe("first-pass asset catalog", () => {
  it("uses stable semantic IDs and browser-resolvable URLs", () => {
    expect(FIRST_PASS_ASSET_IDS).toHaveLength(16);
    expect(FIRST_PASS_ASSET_IDS).not.toContain("hud.digitsWhite");
    expect(FIRST_PASS_ASSET_IDS).not.toContain("dialog.confirmQuit");
    for (const assetId of FIRST_PASS_ASSET_IDS) {
      const asset = getAsset(assetId);
      expect(asset.id).toBe(assetId);
      expect(asset.url).toEqual(expect.any(String));
      expect(asset.url.length).toBeGreaterThan(0);
    }
  });

  it("preloads the complete recovered campaign without duplicate requests", () => {
    expect(CAMPAIGN_ASSET_IDS).toHaveLength(36);
    expect(new Set(CAMPAIGN_ASSET_IDS).size).toBe(CAMPAIGN_ASSET_IDS.length);
    expect(new Set(PRELOAD_ASSET_IDS).size).toBe(PRELOAD_ASSET_IDS.length);
    expect(PRELOAD_ASSET_IDS).not.toContain("dialog.confirmQuit");
    for (const assetId of CAMPAIGN_ASSET_IDS) {
      expect(PRELOAD_ASSET_IDS, assetId).toContain(assetId);
    }
  });

  it("matches every original file's checksum and PNG dimensions", () => {
    for (const asset of Object.values(ASSET_CATALOG)) {
      const bytes = readFileSync(`${workspaceRoot}${asset.sourcePath}`);
      const checksum = createHash("sha256").update(bytes).digest("hex");
      expect(checksum, asset.id).toBe(asset.sha256);
      expect(bytes.subarray(1, 4).toString("ascii"), asset.id).toBe("PNG");
      expect(bytes.readUInt32BE(16), asset.id).toBe(asset.width);
      expect(bytes.readUInt32BE(20), asset.id).toBe(asset.height);
    }
  });

  it("agrees with the frozen recovery manifest", () => {
    const manifestByPath = new Map(manifest.map((entry) => [entry.path, entry]));
    for (const asset of Object.values(ASSET_CATALOG)) {
      const manifestEntry = manifestByPath.get(
        asset.sourcePath.replace(/^recovered\/assets\//, ""),
      );
      expect(manifestEntry, asset.id).toMatchObject({
        width: asset.width,
        height: asset.height,
        sha256: asset.sha256,
        kind: "named_resource",
      });
    }
  });
});
