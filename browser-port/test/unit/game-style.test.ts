import { readFileSync } from "node:fs";
import { describe, expect, it } from "vitest";

const gameStyles = readFileSync(
  new URL("../../src/styles/game.css", import.meta.url),
  "utf8",
);

describe("D-pad touch styles", () => {
  it("suppresses the iOS touch-and-hold callout on arrow labels", () => {
    expect(gameStyles).toMatch(
      /\.control-button,\s*\.control-button > span\s*\{[^}]*-webkit-touch-callout:\s*none;/s,
    );
  });
});
