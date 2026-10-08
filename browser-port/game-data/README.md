# Rooster portable game data

`v1/levels.json` contains browser-independent rules and the recovered Level 1
definition. `v1/atlases.json` describes crops by semantic asset ID; it does not
contain browser paths. The browser maps those IDs to immutable recovered files
in `src/data/assets.ts`.

Consumers validate this aggregate object with `v1/schema.json`:

```json
{
  "version": "levels.json#/version",
  "rules": "levels.json#/rules",
  "levels": "levels.json#/levels",
  "atlases": "atlases.json#/atlases"
}
```

The TypeScript loader performs that merge, checks references and frame bounds,
and exports `GAME_DATA`, `LEVEL_ONE`, and the `ATLASES` lookup. Evidence for the
transcription is recorded in `v1/evidence.json`.

Important recovered atlas details:

- Background tile IDs are one-based: `tile-1` through `tile-4`.
- Player direction groups preserve the recovered frame sequences.
- Positive-speed vehicles use the mirrored source image; negative-speed
  vehicles use the source orientation.
- HUD sheets are physically ordered `1,2,3,4,5,6,7,8,9,0`; frame IDs expose
  the displayed digit rather than the crop index.

Do not edit or optimize files under `recovered/`. A changed required asset is a
test failure because the catalog locks its SHA-256 digest and dimensions.
