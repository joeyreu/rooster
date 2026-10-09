# Rooster recovery inventory

This document is the source-of-truth inventory for rebuilding the recovered 2008 BlackBerry release of **Rooster** as a complete twenty-level browser campaign. It separates behavior evidenced by the recovered package from behavior chosen for the browser port.

## Evidence status

- **Recovered fact** means a value or flow is present in the checked-in COD disassembly or recovered image manifest.
- **Browser-port choice** means an intentional adaptation. It must not be described as original behavior.
- Line references point into the Java-like bytecode disassembly, not clean original Java source. Private fields often have generated names, so their meaning is established from construction, call sites, and draw/update order.
- The package appears complete. The recovery contains 48 named images plus one embedded icon, all independently validated; no audio or music signatures were found. See [the recovery README](../recovered/README.md), lines 15–45, and [the asset manifest](../recovered/assets/manifest.json).

## Recovered level data

Every level is one tile wide and uses 15-pixel-high rows. “Rows” below is the length of that level's recovered `levelDef` array. “Traffic density” is the percentage threshold used by the per-update spawn gate, not a count of vehicles. “Obstacle attempts” is the number of randomized placement attempts, not a guaranteed final obstacle count. “Above” and “below” describe whether the obstacle layer is drawn after or before the moving actors.

| Level | Theme | Rows | Traffic density | Obstacle attempts | Starting traffic | Obstacle draw order | Asset group |
| ---: | --- | ---: | ---: | ---: | ---: | --- | --- |
| 1 | Grass | 11 | 6% | 20 | 60 | Above | Grass + cars |
| 2 | Grass | 12 | 12% | 20 | 60 | Above | Grass + cars |
| 3 | Grass | 14 | 13% | 20 | 70 | Above | Grass + cars |
| 4 | Grass | 15 | 14% | 20 | 80 | Above | Grass + cars |
| 5 | Desert | 12 | 15% | 20 | 80 | Above | Desert + cars |
| 6 | Desert | 16 | 20% | 20 | 80 | Above | Desert + cars |
| 7 | Desert | 18 | 25% | 20 | 100 | Above | Desert + cars |
| 8 | Desert | 20 | 30% | 20 | 150 | Above | Desert + cars |
| 9 | Water | 15 | 25% | 25 | 110 | Below | Water + boats |
| 10 | Water | 17 | 25% | 25 | 110 | Below | Water + boats |
| 11 | Water | 19 | 25% | 25 | 120 | Below | Water + boats |
| 12 | Water | 20 | 30% | 25 | 160 | Below | Water + boats |
| 13 | Steel/metal | 18 | 30% | 30 | 120 | Above | Steel + mercs |
| 14 | Steel/metal | 19 | 30% | 30 | 140 | Above | Steel + mercs |
| 15 | Steel/metal | 23 | 35% | 30 | 150 | Above | Steel + mercs |
| 16 | Steel/metal | 23 | 40% | 30 | 160 | Above | Steel + mercs |
| 17 | Space | 17 | 40% | 35 | 160 | Below | Space + ships |
| 18 | Space | 24 | 40% | 35 | 170 | Below | Space + ships |
| 19 | Space | 25 | 50% | 40 | 180 | Below | Space + ships |
| 20 | Space | 30 | 70% | 40 | 240 | Below | Space + ships |

Recovered evidence:

- The twenty tile-row arrays are in [LevelConfig.java](../recovered/disassembly/com/plazmic/rooster/LevelConfig.java), lines 44–126. [Levels.java](../recovered/disassembly/com/plazmic/rooster/Levels.java), lines 42–76 and 132–166, constructs a one-column tiled layer with 15-pixel rows.
- Theme image arrays and actor/traffic selections are in `LevelConfig.java`, lines 211–221. Obstacle files, draw-order flags, traffic density, obstacle-attempt counts, and starting counters are at lines 305–315.
- [Traffic.java](../recovered/disassembly/com/plazmic/rooster/Traffic.java), lines 231–270, implements `abs(random.nextInt()) % 100 < carDensity[level]` before attempting a spawn.
- [Forest.java](../recovered/disassembly/com/plazmic/rooster/Forest.java), lines 131–210, allocates from and iterates the recovered `treeDensity` value. The recovered spelling is `obsticleImages`; this document uses “obstacle.”
- [Game.java](../recovered/disassembly/com/plazmic/rooster/Game.java), lines 1252–1299, paints the obstacle layer before or after the actor layers according to `drawAbove`.

### Recovered theme asset groups

Dimensions come from [the asset manifest](../recovered/assets/manifest.json). All paths below are under `recovered/assets/img/`.

| Levels | Background tiles | Player atlas | Dead player | Traffic atlas | Obstacle sheet |
| --- | --- | --- | --- | --- | --- |
| 1–4 | `level1Background.png` — 240×60 | `rooster.png` — 25×300 | `deadRooster.png` — 25×25 | `cars_1.png` — 359×18 | `obstacles_grass1.png` — 30×45 |
| 5–8 | `level2Background.png` — 240×60 | `rooster.png` — 25×300 | `deadRooster.png` — 25×25 | `cars_1.png` — 359×18 | `obstacles_desert1.png` — 30×45 |
| 9–12 | `bg_level_water_8.png` — 240×60 | `roosterBoat.png` — 25×300 | `deadRooster_boat.png` — 25×25 | `boats_1.png` — 380×18 | `obstacles_water1.png` — 30×45 |
| 13–16 | `bg_level_steel_8.png` — 240×60 | `roosterTank.png` — 25×300 | `deadRooster_tank.png` — 25×25 | `merc_1.png` — 215×18 | `obstacles_metal1.png` — 30×45 |
| 17–20 | `bg_level_space_8.png` — 240×60 | `roosterSpace.png` — 25×300 | `deadRooster_space.png` — 25×25 | `ships_1.png` — 137×18 | `obstacles_space1.png` — 30×45 |

Shared campaign art:

| Purpose | Recovered asset and dimensions |
| --- | --- |
| Extra-life pickup | `cone_grey.png` — 135×15 |
| Counter-bonus pickup | `cone_purple.png` — 135×15 |
| Speed pickup | `cone_orange.png` — 135×15 |
| HUD pieces | `hudBL.png` — 33×16; `newHUDLeft.png` — 39×15 |
| HUD digits | `numbers10_8_black.png` and `numbers10_8_white.png` — 70×8 each |
| Outer-device framing | `top.png` — 240×47 |
| Application icons | `roosterIcon_160805.png` and an unreferenced embedded alternate — 36×36 each |

## Recovered screens and artwork

The original logical viewport is 240×160. `RoosterCanvas` centers that viewport on a larger device screen; see [RoosterCanvas.java](../recovered/disassembly/com/plazmic/rooster/RoosterCanvas.java), lines 114–168.

| Screen / use | Recovered artwork | Dimensions and slicing |
| --- | --- | --- |
| Title / splash | `splash_1_3.png`; `splash_1_3_noClick.png` | 240×160; 77×60 |
| Synchronous loading | `loaderBack.png`; `loaderFront.png` | 148×32; 137×19 |
| Settings / key mapping | `instructions.png`; `instructions_select.png` | 240×160; 29×29 |
| Quit/new-game/close confirmation | `reallyQuit.png` | 187×67 |
| Between-level card | `nextLevel.png`; `nextLevel_spaceToPlay.png`; `levelNames.png` | 240×160; 207×30; 215×285. The name sheet is sliced into nineteen 215×15 rows for Levels 2–20. |
| Gameplay terminal overlays | `levelComplete_uLose_count.png` | 179×124 sheet: `LEVEL COMPLETED` at (0,0), 179×50; `YOU LOSE` at (0,50), 179×25; counter-zero message at (0,75), 179×49. |
| Initials entry | `top10.png` | 187×107 |
| High-score table | `highScore.png` | 240×52 header; names and scores are rendered text. |
| About, page 2 | `plazmic-games-c_204x106.gif` | 204×106 |
| Finale | `winGold.png`; `winGold_txt.png`; `winGold_finish.png` | 240×160 background; 126×315 scrolling story; 95×30 finish prompt. |

Screen-to-asset call sites are [Splash.java](../recovered/disassembly/com/plazmic/rooster/Splash.java), lines 42–136; [Loading.java](../recovered/disassembly/com/plazmic/rooster/Loading.java), lines 31–77; [KeyMapper.java](../recovered/disassembly/com/plazmic/rooster/KeyMapper.java), lines 65–112; [Confirm.java](../recovered/disassembly/com/plazmic/rooster/Confirm.java), lines 28–51; [NextLevel.java](../recovered/disassembly/com/plazmic/rooster/NextLevel.java), lines 40–137; `Game.java`, lines 217–265; [EnterName.java](../recovered/disassembly/com/plazmic/rooster/EnterName.java), lines 35–77; [HighScores.java](../recovered/disassembly/com/plazmic/rooster/HighScores.java), lines 65–93; [About.java](../recovered/disassembly/com/plazmic/rooster/About.java), lines 42–72; and [Finale.java](../recovered/disassembly/com/plazmic/rooster/Finale.java), lines 30–88.

There is no separate pause illustration. Pause redraws the frozen game and adds text. Likewise, the BlackBerry command menus are native platform UI, not recovered raster assets.

### Between-level captions

These strings are manual transcriptions of the nineteen rows in `levelNames.png`; the raster is the authoritative source because the captions do not appear as Java strings.

| Upcoming level | Caption |
| ---: | --- |
| 2 | `What are ya, Chicken?!` |
| 3 | `Time to take it up a notch` |
| 4 | `The grass is always greener...` |
| 5 | `Operation desert chicken.` |
| 6 | `Rooster of Arabia` |
| 7 | `Hasta la vista, chicken!!` |
| 8 | `Never travel alone` |
| 9 | `Avast ye cowardly squab!!` |
| 10 | `Mmmm... Eau de toilet!` |
| 11 | `How's da wetter??` |
| 12 | `In the creek.` |
| 13 | `Heavy Metal Baby!!!!` |
| 14 | `Tanks for the memories` |
| 15 | `What are those things?` |
| 16 | `I'm scared mommy.` |
| 17 | `The final frontier.` |
| 18 | `Fast-forwarding, Sir!` |
| 19 | `Is that your UFO????` |
| 20 | `THE BIG KAHOONA!!!` |

`NextLevel.java`, lines 94–125, loads and slices the sheet; lines 172–198 associate the zero-based target level and cumulative score; lines 347–356 choose row `targetLevel - 1`.

## Recovered campaign flow

```text
Title
  └─ Start ─> Gameplay: Level 1
                  ├─ death with spares left ─> death hold/camera return ─> same level
                  ├─ death with no spares ─> YOU LOSE for >3 s
                  │                              ├─ qualifying score ─> Initials ─> High Scores
                  │                              └─ non-qualifying score ─> Title
                  └─ reach top ─> LEVEL COMPLETED for >3 s; add counter to score
                                         ├─ Levels 1–19 ─> Next Level card
                                         │                    └─ Continue ─> next Gameplay level
                                         └─ Level 20 ─> Finale
                                                               ├─ qualifying score ─> Initials ─> High Scores
                                                               └─ non-qualifying score ─> Title
```

The central mode dispatcher is in `RoosterCanvas.java`, lines 211–392. Mode 5 increments the level and populates the next-level card for Levels 1–19, but constructs the finale when the current index is the last level (`levelDef.length - 1`) at lines 322–369. The valid level indices are 0–19 at lines 416–428.

### Inputs and command menus

| Screen | Direct input | Recovered BlackBerry command menu |
| --- | --- | --- |
| Title | Space or key code 48 starts; Escape exits. | About, High Scores, Settings, Start |
| Gameplay | Mapped movement keys; Escape release enters Pause. | Hide, New Game, Settings, Quit Game, Pause, Close |
| Pause | Gameplay is frozen. | Hide, New Game, Settings, Quit Game, Resume, Close |
| Next Level | Space or key code 48 continues; Escape suspends the MIDlet. | Hide, Quit Game, Continue, Close |
| Settings | Escape returns to the recorded prior mode. | Default Settings, Toggle Death Buzz, plus Return To Game when entered from play or Start Screen otherwise |
| About | Any key advances pages 1 → 2 → 3 → Title. | Start Screen |
| High Scores | Escape returns to Title. | Start Screen |
| Finale | Any key immediately performs high-score qualification, even before the story finishes scrolling. | Start Screen |
| Confirm | `Y`/`N`, with legacy device aliases; no command menu. | None |

Command construction and input evidence: `Splash.java`, lines 208–223, 380–431, and 509–543; `Game.java`, lines 1533–1615; [Pause.java](../recovered/disassembly/com/plazmic/rooster/Pause.java), lines 117–240; `NextLevel.java`, lines 203–231 and 388–422; `KeyMapper.java`, lines 150–178 and 452–506; `About.java`, lines 93–112 and 413–429; `HighScores.java`, lines 249–259 and 473–489; `Finale.java`, lines 122–150 and 233–249; and `Confirm.java`, lines 100–204. Central command routing, including the three confirmation usages, is in `RoosterCanvas.java`, lines 438–716.

About page 1 credits **Spencer Quin** as Engine Programmer and **Tudor Whiteley** for Artwork; page 2 shows the Plazmic logo; page 3 shows a feedback URL (`About.java`, lines 244–391).

## Recovered score, lives, and between-level continuity

| State | Recovered behavior |
| --- | --- |
| Initial lives | The run starts with **2 spare lives**, meaning three attempts including the current one. |
| Death | A traffic collision or a counter reaching zero removes one spare. Game over begins only when the value becomes `-1`. |
| Extra life | The grey pickup increments the spare-life value by one. |
| Score | Reset to zero for Level 1/new game. On successful completion, the current remaining traffic counter is added to the cumulative score. No other recovered call adds to score. |
| Level transition | Cumulative score and spare lives remain unchanged when Levels 2–20 are initialized. The next-level card displays the cumulative score. |
| Per-level counter | Reset to that level's `startCarsPassed` value at level start and after every death. The purple pickup adds a randomized 10–20 to this counter, not directly to score. |
| Player speed | Reset to normal speed 2 at every level initialization and after a respawn. The orange pickup changes it to 4 until one of those resets. |
| Level world | Background/rows, traffic, obstacles, player placement, dead markers, and pickups are regenerated/reset for the new level. A respawn within a level does not perform a whole-level reset. |
| Random generators | The same `Game`, `Traffic`, and `Forest` objects are reset between sequential levels; their `java.util.Random` objects are constructed once and not replaced by the reset routines. Their original initial seeds are time/device-dependent and are not recoverable constants. |
| Relaunch | No recovered campaign-save record exists. The run is memory-only; high scores, key mapping, and death-buzz preference are the recovered persistent data. |

The decisive reset branch is `Game.java`, lines 596–676: normal speed and the level counter are always reset, while score and lives reset only for level index 0 or the debug-level-jump path (lines 635–647). The death/life/counter flow is at lines 1011–1128; pickup effects are at lines 907–976; completion scoring is at lines 1166–1218. `RoosterCanvas.java`, lines 239–289, reuses the existing `Game` object for sequential levels. Random construction versus reset reuse is visible in `Game.java`, lines 73–125 and 596–893; `Traffic.java`, lines 33–83 and 444 onward; and `Forest.java`, lines 32–77 and 387–418.

[Storage.java](../recovered/disassembly/com/plazmic/rooster/Storage.java), lines 22–130 and 134–489, contains only the `Scores`, key-mapping, and death-buzz record-store paths. Its high-score qualification is strictly greater-than, so a score tied with an existing entry does not take that rank (`Storage.java`, lines 503–570). Initials entry and insertion flow are in `EnterName.java`, lines 106–254, and `Storage.java`, lines 574–740.

## Recovered timing

The main loop targets one render/update pass every 60 ms (`RoosterCanvas.java`, lines 720–764). These are nominal timings: the loop sleeps only when work finishes inside the 60 ms budget, so slow frames extend tick-counted animations.

| Sequence | Recovered timing and behavior |
| --- | --- |
| Death before camera return | A 15-pass counter gate, nominally about 900 ms, then the camera moves toward the start at 4 pixels per pass. The exact perceived hold has a one-pass boundary ambiguity because the counter is incremented during the death update itself. (`Game.java`, lines 1078–1128.) |
| Level complete | Reaching player `y <= 0` records wall-clock time. The overlay stays until elapsed time is **strictly greater than 3,000 ms**, then the remaining counter is added to score and mode 5 is entered. At a perfect 60 ms cadence, strict `>` makes the first eligible check nominally 3,060 ms after the timestamp. (`Game.java`, lines 1166–1218.) |
| Game over | Uses the same strict `> 3,000 ms` wall-clock gate before high-score qualification or return to Title. (`Game.java`, lines 1183–1250.) |
| Next-level prompt | No automatic advance. The prompt is visible for counter values 4–11 and hidden for 1–3 and 12: nominally 480 ms on, 240 ms off, 720 ms per cycle. (`NextLevel.java`, lines 357–384.) |
| Title prompt | Uses the same 8-on/4-off render-pass blink. (`Splash.java`, lines 394–431.) |
| Finale story hold | The story Y starts at 10. A counter runs through 61 render passes before scrolling begins: nominally about 3.66 s. (`Finale.java`, lines 108–117 and 160–185.) |
| Finale story scroll | The story moves from Y=10 to Y=-215 at 1 pixel per render pass: 225 passes, nominally 13.5 s. The finish-prompt phase begins around 17.16 s after rendering starts; the first visible prompt is roughly 3 passes later. (`Finale.java`, lines 160–228.) |
| Finale prompt | Same 8-on/4-off blink as the next-level prompt. Any key can skip the hold, scroll, or prompt and immediately run score qualification. |
| High-score reveal | One row in each five-entry column becomes available per render pass; all ten are present after five passes, nominally about 300 ms. (`HighScores.java`, lines 263–469.) |

Level 20 still receives the normal level-complete overlay and score award before the finale is constructed. The finale itself does not add another score bonus.

## Browser-port choices — not recovered facts

These policies adapt the BlackBerry behavior to a testable browser game. Keep them labeled as port choices in code, tests, and user-facing notes.

1. **Deterministic time:** the browser specification normalizes each strict wall-clock terminal delay to 50 fixed 60 ms simulation ticks (exactly 3,000 ms). That differs from the original strict `> 3,000 ms` check and its nominal 3,060 ms boundary.
2. **Deterministic randomness:** the browser uses explicit seeded streams and carries their states between levels. This preserves within-run continuity while making replays possible; the original reused unseeded `java.util.Random` objects.
3. **Browser lifecycle:** simulation freezes while paused or page-hidden. BlackBerry MIDlet hide/pause notifications are evidence for suspension intent, but browser visibility handling and catch-up limits are port policy.
4. **Input:** Enter, modern keyboard aliases, Pointer Events, touch controls, and clicking/tapping the scene are browser affordances. The recovered direct transition key is Space/key code 48, while gameplay movement uses persisted BlackBerry key mappings.
5. **Menus:** accessible DOM controls replace BlackBerry's native command-menu chrome. Command names and destinations can match the recovered menus; their pixels, focus behavior, and device soft-key layout cannot.
6. **Persistence:** `localStorage` is the browser persistence mechanism. Persisting a best score/settings is a mapping of recovered persistent concepts; saving an in-progress campaign would be a new feature because the original did not do so.
7. **Display:** the recovered 240×160 coordinate system and artwork are authoritative, while responsive layout, integer scaling, letterboxing, and surrounding page UI are browser presentation choices.

The current deterministic and platform-adaptation policies are specified in [browser-port-spec.md](browser-port-spec.md), especially sections 3.1, 3.3, 6.2, 7.8–7.9, 8, 10, and 12. If a future fidelity pass changes one of these choices, update that specification without rewriting the recovered-fact sections above.
