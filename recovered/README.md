# Rooster BlackBerry game recovery

This directory contains a first-pass recovery of the five original BlackBerry
COD modules. The input files in the parent directory were not modified.

## Package identity

- Platform: classic BlackBerry Java (RIM COD), not BlackBerry 10
- Java profile: CLDC 1.1 / MIDP 2.0
- Entrypoint: `com.plazmic.rooster.RoosterMIDlet`
- Embedded title/vendor/version: `Rooster`, `Plazmic Inc.`, `1.0.0.64`
- Embedded creation time: `2008-08-15 14:58:49 UTC`
- Main dependency: `net_rim_cldc`

The sizes declared in `com_plazmic_games_rooster.jad` exactly match all five
COD files, so the package appears complete.

## Recovered output

- `disassembly/` contains 27 game classes and 6 generated resource classes.
  The files preserve class names, method names, fields, constants, control flow,
  and RIM JVM instructions.
- `assets/img/` contains the 48 named game resources: 47 PNG files and one GIF.
- `assets/embedded/` contains one additional 36x36 PNG embedded in the main COD.
  It is an alternate application-icon stream that is not registered as a
  separate named resource.
- `assets/manifest.json` records dimensions, byte sizes, SHA-256 hashes, and
  the source of every recovered image.
- `extract_assets.py` reproducibly rebuilds the asset directory from the
  resource disassembly and scans the original CODs for unnamed PNG streams.
- `crosscheck/cod2jar/` contains a second decompiler's low-level text and XML
  dumps for all five modules. It independently decoded the main module's 29
  classes, 222 routines, and 9,111 bytecode instructions without errors.

Run the extractor from the game directory with:

```sh
python3 recovered/extract_assets.py
```

Every recovered PNG was checked chunk-by-chunk, including CRC validation. The
GIF signature and trailer were also validated. A second, independent scan of
the five COD files recovered the same 49 unique image hashes byte-for-byte, and
all 49 images decode successfully. No embedded audio or music signatures were
found.

## Important limitation

The `.java` files are a Java-like disassembly, not clean original source and not
directly compilable. RIM COD files contain optimized BlackBerry JVM bytecode,
not ordinary JVM `.class` files. Some private field names were stripped by the
original build and are represented as `field_<offset>`. Reconstructing a modern,
playable port is feasible from this output, but it is a separate source-rewrite
step.

## Tooling note

The disassembly was produced from the open-source
[`george-hopkins/coddec`](https://github.com/george-hopkins/coddec) mirror at
commit `9ef9eb6f10ec280ef16a1d3148df206ae2717ecc`. Its parser incorrectly retained
a version-6 layout flag while reading these version-5 COD data sections. The
minimal correction used for this recovery is saved as `coddec-v5-fix.patch`.

The supplemental `crosscheck/cod2jar/` output was generated with a temporary
Python 3 port of `cod2jar`. Fully resolved JVM class/JAR output still requires
BlackBerry's matching `net_rim_cldc.cod` library (and a Jasmin assembler), so
the checked-in cross-check is intentionally the dependency-free raw decode.
