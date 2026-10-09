import { defineConfig, devices } from "@playwright/test";

export default defineConfig({
  testDir: "./test/e2e",
  fullyParallel: false,
  // The restored campaign preloads forty original PNGs per page. Keeping one
  // worker per browser avoids starving WebKit while still exercising the four
  // supported desktop/mobile profiles in parallel.
  workers: 4,
  use: {
    baseURL: "http://127.0.0.1:4173",
    // Trace finalization is unreliable in the workspace path containing a
    // space on WebKit/iOS emulation; screenshots and error contexts still
    // provide the diagnostics this suite needs.
    trace: "off",
  },
  webServer: {
    command: "npm run dev -- --port 4173",
    url: "http://127.0.0.1:4173",
    reuseExistingServer: true,
  },
  projects: [
    { name: "chromium", use: { ...devices["Desktop Chrome"] } },
    { name: "firefox", use: { ...devices["Desktop Firefox"] } },
    { name: "webkit", use: { ...devices["Desktop Safari"] } },
    { name: "mobile", use: { ...devices["iPhone 13"] } }
  ],
});
