import { fileURLToPath, URL } from "node:url";
import { defineConfig } from "vite";

const browserPortRoot = fileURLToPath(new URL(".", import.meta.url));

const recoveredAssets = fileURLToPath(
  new URL("../recovered/assets", import.meta.url),
);

export default defineConfig({
  base: "./",
  publicDir: false,
  server: {
    fs: {
      allow: [browserPortRoot, recoveredAssets],
    },
  },
  build: {
    sourcemap: true,
  },
});
