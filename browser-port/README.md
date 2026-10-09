# Rooster browser port

This folder contains the native-browser campaign port of the recovered
BlackBerry game. It runs all 20 levels with the original world, character,
traffic, obstacle, transition, and finale artwork. The campaign includes
keyboard and touch controls, pause/resume, death and respawn, continuous score
and lives between levels, win/loss results, and local best-score and vibration
settings.

The recovered files in `../recovered/` are immutable inputs. Browser code imports
the original PNGs directly; versioned rules and atlas metadata live in
`game-data/v1/`.

## Run locally

Requirements: Node.js 20.19+ (or 22.12+) and npm.

```sh
npm install
npm run dev
```

Open the local URL printed by Vite. Use Arrow keys, WASD, or K/L to move; press
Escape or P to pause. The on-screen D-pad supports mouse, pen, and touch.
Append `?seed=305419896` to the URL to reproduce the same diagnostic run.
Append `?level=13` to start a fresh diagnostic run on a specific recovered
level; ordinary play always progresses through the campaign in order.

## Verify

```sh
npm run check
npm test
npm run build
npm run test:e2e
```

Playwright's browser binaries may need to be installed once with
`npx playwright install` before the end-to-end suite can run.

## Boundaries

- `src/core/` is deterministic and browser-independent.
- `game-data/v1/` is the portable 20-level and atlas contract.
- `src/data/` validates data and maps semantic asset IDs to recovered files.
- `src/render/` owns Canvas 2D presentation at a logical 240×160 resolution.
- `src/platform/` contains browser input, timing, storage, and haptics adapters.
- `src/screens/` and `src/styles/` provide the accessible responsive shell.

The governing behavior and acceptance criteria are in
[`../docs/browser-port-spec.md`](../docs/browser-port-spec.md).
The recovered campaign evidence is indexed in
[`../docs/recovery-inventory.md`](../docs/recovery-inventory.md).
