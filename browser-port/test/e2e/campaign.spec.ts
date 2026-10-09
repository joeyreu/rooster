import { expect, test } from "@playwright/test";

interface CampaignSnapshot {
  route: string;
  level: number;
  score: number;
  spareLives: number;
  trafficRemaining: number;
  phase: string | null;
}

async function callPlaytest(
  page: import("@playwright/test").Page,
  action: "completeLevel" | "continue" | "snapshot",
): Promise<CampaignSnapshot> {
  return page.evaluate((method) => {
    const api = (
      window as unknown as {
        __ROOSTER_PLAYTEST__?: Record<string, () => CampaignSnapshot>;
      }
    ).__ROOSTER_PLAYTEST__;
    if (api === undefined || api[method] === undefined) {
      throw new Error("Campaign playtest API is unavailable.");
    }
    return api[method]();
  }, action);
}

test.beforeEach(async ({ page }) => {
  await page.goto("/?seed=305419896");
  await expect(page.getByRole("button", { name: "Start game" })).toBeVisible();
});

test("plays the complete 20-level campaign with score and life continuity", async ({
  page,
}) => {
  const game = page.locator("#game-wrapper");
  await page.getByRole("button", { name: "Start game" }).click();
  const seeded = await page.evaluate(() => {
    const api = (
      window as unknown as {
        __ROOSTER_PLAYTEST__?: {
          setCampaignTotals(score: number, spareLives: number): CampaignSnapshot;
        };
      }
    ).__ROOSTER_PLAYTEST__;
    if (api === undefined) throw new Error("Campaign playtest API is unavailable.");
    return api.setCampaignTotals(500, 4);
  });
  expect(seeded).toMatchObject({ route: "run", level: 1, score: 500, spareLives: 4 });

  let expectedScore = 500;
  for (let level = 1; level < 20; level += 1) {
    await expect(game).toHaveAttribute("data-route", "run");
    await expect(game).toHaveAttribute("data-level", String(level));

    const completed = await callPlaytest(page, "completeLevel");
    expect(completed).toMatchObject({
      route: "nextLevel",
      level,
      spareLives: 4,
      phase: null,
    });
    expect(completed.score).toBeGreaterThan(expectedScore);
    expectedScore = completed.score;
    await expect(game).toHaveAttribute("data-route", "nextLevel");

    if (level === 1) {
      const frameBeforeWait = Number(await game.getAttribute("data-screen-frame"));
      await page.waitForTimeout(125);
      const frameAfterWait = Number(await game.getAttribute("data-screen-frame"));
      expect(frameAfterWait - frameBeforeWait).toBeGreaterThanOrEqual(1);
      expect(frameAfterWait - frameBeforeWait).toBeLessThanOrEqual(4);
    }

    const continued = await callPlaytest(page, "continue");
    expect(continued).toMatchObject({
      route: "run",
      level: level + 1,
      score: expectedScore,
      spareLives: 4,
      phase: "playing",
    });
  }

  const finale = await callPlaytest(page, "completeLevel");
  expect(finale).toMatchObject({ route: "finale", level: 20, spareLives: 4 });
  expect(finale.score).toBe(2_993);
  await expect(game).toHaveAttribute("data-route", "finale");
  await expect.poll(async () => Number(await game.getAttribute("data-screen-frame"))).toBeGreaterThan(5);

  await callPlaytest(page, "continue");
  await expect(game).toHaveAttribute("data-route", "results");
  await expect(page.getByRole("heading", { name: "Golden Rooster!" })).toBeVisible();
  await expect(page.getByText("All 20 levels complete", { exact: true })).toBeVisible();
  await expect(page.locator("#status-best")).toHaveText(String(finale.score));
});

test("exposes campaign screens to keyboard, pointer, and assistive UI", async ({ page }) => {
  const game = page.locator("#game-wrapper");
  await page.getByRole("button", { name: "Start game" }).click();
  await callPlaytest(page, "completeLevel");

  await expect(page.locator("#scene-title")).toHaveText("Level 1 complete");
  await expect(page.locator("#game-objective")).toContainText(
    "Next: Level 2, What are ya, Chicken?!",
  );
  await expect(page.getByRole("button", { name: "Continue" })).toBeEnabled();
  await page.keyboard.press("0");
  await expect(game).toHaveAttribute("data-level", "2");
  await expect(game).toHaveAttribute("data-route", "run");

  await callPlaytest(page, "completeLevel");
  await page.locator("#game-canvas").click();
  await expect(game).toHaveAttribute("data-level", "3");
  await expect(game).toHaveAttribute("data-route", "run");

  await page.goto("/?seed=305419896&level=20");
  await page.getByRole("button", { name: "Start game" }).click();
  await callPlaytest(page, "completeLevel");
  await expect(page.locator("#scene-title")).toHaveText("Golden Rooster finale");
  await expect(page.getByRole("button", { name: "Finish" })).toBeEnabled();
  await expect(page.locator("#game-objective")).toContainText("The rooster crossed");
  await page.keyboard.press("Tab");
  await expect(page.getByRole("button", { name: "Finish" })).toBeFocused();
  await game.focus();
  await expect(game).toBeFocused();
  await page.keyboard.press("Shift+a");
  await expect(game).toHaveAttribute("data-route", "finale");
  await page.keyboard.press("a");
  await expect(game).toHaveAttribute("data-route", "results");
  await expect(page.getByRole("heading", { name: "Golden Rooster!" })).toBeVisible();
});

for (const level of [1, 5, 9, 13, 17, 20]) {
  test(`starts recovered level ${level} directly for visual diagnostics`, async ({ page }) => {
    await page.goto(`/?seed=305419896&level=${level}`);
    await expect(page.getByRole("button", { name: "Start game" })).toBeVisible();
    await page.getByRole("button", { name: "Start game" }).click();
    await expect(page.locator("#game-wrapper")).toHaveAttribute("data-level", String(level));
    await expect(page.locator("#status-level")).toHaveText(`${level}/20`);
    await expect(page.locator("#game-canvas")).toBeVisible();
  });
}
