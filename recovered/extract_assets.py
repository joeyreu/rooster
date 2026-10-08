#!/usr/bin/env python3
"""Recover named image resources from Coddec's BlackBerry COD disassembly."""

from __future__ import annotations

import argparse
import hashlib
import json
import re
import struct
import zlib
from pathlib import Path, PurePosixPath


ARRAY_RE = re.compile(r"(?m)^\s*arrayinit \[([^\]]*)\]\s*$")
RESOURCE_RE = re.compile(r'ldc literal_\d+:"(img/[^\"]+\.(?:png|gif))"')
PNG_SIGNATURE = b"\x89PNG\r\n\x1a\n"


def image_metadata(data: bytes, resource_name: str) -> tuple[str, int, int]:
    suffix = Path(resource_name).suffix.lower()
    if suffix == ".png":
        if not data.startswith(PNG_SIGNATURE) or len(data) < 33:
            raise ValueError(f"{resource_name}: invalid PNG signature")

        offset = len(PNG_SIGNATURE)
        saw_ihdr = False
        saw_iend = False
        while offset + 12 <= len(data):
            length = struct.unpack_from(">I", data, offset)[0]
            chunk_end = offset + 12 + length
            if chunk_end > len(data):
                raise ValueError(f"{resource_name}: truncated PNG chunk")
            chunk_type = data[offset + 4 : offset + 8]
            chunk_data = data[offset + 8 : offset + 8 + length]
            expected_crc = struct.unpack_from(">I", data, offset + 8 + length)[0]
            actual_crc = zlib.crc32(chunk_type + chunk_data) & 0xFFFFFFFF
            if actual_crc != expected_crc:
                raise ValueError(f"{resource_name}: PNG CRC mismatch")
            if chunk_type == b"IHDR":
                saw_ihdr = True
            if chunk_type == b"IEND":
                saw_iend = True
                offset = chunk_end
                break
            offset = chunk_end

        if not saw_ihdr or not saw_iend or offset != len(data):
            raise ValueError(f"{resource_name}: incomplete PNG stream")
        width, height = struct.unpack_from(">II", data, 16)
        return "PNG", width, height

    if suffix == ".gif":
        if len(data) < 14 or data[:6] not in (b"GIF87a", b"GIF89a"):
            raise ValueError(f"{resource_name}: invalid GIF signature")
        if data[-1] != 0x3B:
            raise ValueError(f"{resource_name}: missing GIF trailer")
        width, height = struct.unpack_from("<HH", data, 6)
        return "GIF", width, height

    raise ValueError(f"{resource_name}: unsupported image type")


def carve_png(blob: bytes, start: int, source_name: str) -> bytes:
    if not blob.startswith(PNG_SIGNATURE, start):
        raise ValueError(f"{source_name}: no PNG at 0x{start:x}")
    offset = start + len(PNG_SIGNATURE)
    while offset + 12 <= len(blob):
        length = struct.unpack_from(">I", blob, offset)[0]
        chunk_end = offset + 12 + length
        if chunk_end > len(blob):
            raise ValueError(f"{source_name}: truncated PNG at 0x{start:x}")
        if blob[offset + 4 : offset + 8] == b"IEND":
            return blob[start:chunk_end]
        offset = chunk_end
    raise ValueError(f"{source_name}: PNG at 0x{start:x} has no IEND")


def safe_resource_path(root: Path, resource_name: str) -> Path:
    relative = PurePosixPath(resource_name)
    if relative.is_absolute() or ".." in relative.parts or not relative.parts:
        raise ValueError(f"unsafe resource path: {resource_name}")
    if relative.parts[0] not in ("img", "embedded"):
        raise ValueError(f"resource is outside an allowed asset folder: {resource_name}")
    return root.joinpath(*relative.parts)


def extract(resources_dir: Path, output_dir: Path, cod_dir: Path | None) -> list[dict[str, object]]:
    manifest: list[dict[str, object]] = []
    seen: set[str] = set()
    populators = sorted(resources_dir.glob("*RIMResourcesPopulator*.java"))
    if not populators:
        raise FileNotFoundError(f"no resource populators found in {resources_dir}")

    for populator in populators:
        source = populator.read_text(encoding="utf-8")
        arrays = list(ARRAY_RE.finditer(source))
        for index, match in enumerate(arrays):
            segment_end = arrays[index + 1].start() if index + 1 < len(arrays) else len(source)
            segment = source[match.end() : segment_end]
            resource_match = RESOURCE_RE.search(segment)
            if resource_match is None:
                continue

            resource_name = resource_match.group(1)
            if resource_name in seen:
                raise ValueError(f"duplicate resource name: {resource_name}")
            seen.add(resource_name)

            values = [int(value.strip()) for value in match.group(1).split(",") if value.strip()]
            data = bytes(value & 0xFF for value in values)
            image_format, width, height = image_metadata(data, resource_name)
            destination = safe_resource_path(output_dir, resource_name)
            destination.parent.mkdir(parents=True, exist_ok=True)
            destination.write_bytes(data)

            manifest.append(
                {
                    "path": resource_name,
                    "format": image_format,
                    "width": width,
                    "height": height,
                    "bytes": len(data),
                    "sha256": hashlib.sha256(data).hexdigest(),
                    "source": populator.name,
                    "kind": "named_resource",
                }
            )

    if cod_dir is not None:
        named_hashes = {str(item["sha256"]) for item in manifest}
        for cod_path in sorted(cod_dir.glob("*.cod")):
            blob = cod_path.read_bytes()
            cursor = 0
            while True:
                offset = blob.find(PNG_SIGNATURE, cursor)
                if offset < 0:
                    break
                data = carve_png(blob, offset, cod_path.name)
                cursor = offset + len(data)
                digest = hashlib.sha256(data).hexdigest()
                if digest in named_hashes:
                    continue

                resource_name = f"embedded/{cod_path.stem}_{offset:08x}.png"
                image_format, width, height = image_metadata(data, resource_name)
                destination = safe_resource_path(output_dir, resource_name)
                destination.parent.mkdir(parents=True, exist_ok=True)
                destination.write_bytes(data)
                manifest.append(
                    {
                        "path": resource_name,
                        "format": image_format,
                        "width": width,
                        "height": height,
                        "bytes": len(data),
                        "sha256": digest,
                        "source": f"{cod_path.name} @ 0x{offset:x}",
                        "kind": "embedded_unreferenced",
                    }
                )
                named_hashes.add(digest)

    manifest.sort(key=lambda item: str(item["path"]))
    return manifest


def main() -> None:
    recovered_dir = Path(__file__).resolve().parent
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--resources-dir",
        type=Path,
        default=recovered_dir / "disassembly/com/rim/resources",
    )
    parser.add_argument("--output-dir", type=Path, default=recovered_dir / "assets")
    parser.add_argument(
        "--cod-dir",
        type=Path,
        default=recovered_dir.parent,
        help="scan COD modules for additional unnamed PNG streams",
    )
    args = parser.parse_args()

    manifest = extract(args.resources_dir.resolve(), args.output_dir.resolve(), args.cod_dir.resolve())
    manifest_path = args.output_dir.resolve() / "manifest.json"
    manifest_path.write_text(json.dumps(manifest, indent=2) + "\n", encoding="utf-8")
    png_count = sum(item["format"] == "PNG" for item in manifest)
    gif_count = sum(item["format"] == "GIF" for item in manifest)
    print(f"Recovered {len(manifest)} images ({png_count} PNG, {gif_count} GIF)")
    print(f"Manifest: {manifest_path}")


if __name__ == "__main__":
    main()
