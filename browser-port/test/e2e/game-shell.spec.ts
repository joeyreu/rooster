import { expect, test } from "@playwright/test";

test.beforeEach(async ({ page }) => {
  await page.goto("/?seed=305419896");
  await expect(page.getByRole("button", { name: "Start game" })).toBeVisible();
});

test("starts a run and keeps simulation frozen while paused", async ({ page }) => {
  const game = page.locator("#game-wrapper");
  await expect(game).toHaveAttribute("data-route", "title");

  await page.getByRole("button", { name: "Start game" }).click();
  await expect(game).toHaveAttribute("data-route", "run");
  await expect(game).toHaveAttribute("data-phase", "playing");
  await expect(game).toHaveAttribute("data-run-seed", "305419896");

  await expect.poll(async () => Number(await game.getAttribute("data-tick"))).toBeGreaterThan(0);
  await page.getByRole("button", { name: "Pause", exact: true }).click();
  await expect(page.getByRole("heading", { name: "Paused", exact: true })).toBeVisible();
  await expect(game).toHaveAttribute("data-suspended", "true");
  const pausedTick = Number(await game.getAttribute("data-tick"));
  await page.waitForTimeout(240);
  await expect(game).toHaveAttribute("data-tick", String(pausedTick));

  await page.getByRole("button", { name: "New game" }).click();
  await expect(page.getByRole("dialog", { name: "Start a new run?" })).toBeVisible();
  await page.keyboard.press("Escape");
  await expect(page.getByRole("dialog", { name: "Start a new run?" })).toBeHidden();
  await expect(game).toHaveAttribute("data-suspended", "true");

  await page.getByRole("button", { name: "Resume", exact: true }).click();
  await expect(game).toHaveAttribute("data-suspended", "false");
  await expect.poll(async () => Number(await game.getAttribute("data-tick"))).toBeGreaterThan(
    pausedTick,
  );
});

test("supports held keyboard movement and a global pause shortcut", async ({ page }) => {
  const game = page.locator("#game-wrapper");
  await page.getByRole("button", { name: "Start game" }).click();
  const startingY = Number(await game.getAttribute("data-player-y"));

  await page.keyboard.down("ArrowUp");
  await page.waitForTimeout(210);
  await page.keyboard.up("ArrowUp");
  await expect.poll(async () => Number(await game.getAttribute("data-player-y"))).toBeLessThan(
    startingY,
  );

  await page.keyboard.press("p");
  await expect(page.getByRole("heading", { name: "Paused", exact: true })).toBeVisible();
  await page.getByRole("button", { name: "New game" }).focus();
  await page.keyboard.press("p");
  await expect(page.getByRole("heading", { name: "Paused", exact: true })).toBeHidden();

  await page.getByRole("checkbox", { name: "Death buzz" }).focus();
  await page.keyboard.press("p");
  await expect(page.getByRole("heading", { name: "Paused", exact: true })).toBeVisible();
});

test("offers semantic touch controls without covering the scene", async ({ page }) => {
  await page.getByRole("heading", { name: "Ready to cross?" }).click();
  const game = page.locator("#game-wrapper");
  const scene = page.locator("#game-canvas");
  const sceneBox = await scene.boundingBox();
  expect(sceneBox).not.toBeNull();
  expect(sceneBox!.width / sceneBox!.height).toBeCloseTo(1.5, 1);

  const movement = page.getByRole("group", { name: "Movement controls" });
  await expect(movement.getByRole("button", { name: "Move up" })).toBeEnabled();
  await expect(movement.getByRole("button", { name: "Move right" })).toBeEnabled();
  await expect(movement.getByRole("button", { name: "Move down" })).toBeEnabled();
  await expect(movement.getByRole("button", { name: "Move left" })).toBeEnabled();

  const startingY = Number(await game.getAttribute("data-player-y"));
  await movement.getByRole("button", { name: "Move up" }).evaluate((button) => {
    (button as HTMLButtonElement).click();
  });
  await expect.poll(async () => Number(await game.getAttribute("data-player-y"))).toBe(
    startingY - 2,
  );
  await page.waitForTimeout(180);
  await expect(game).toHaveAttribute("data-player-y", String(startingY - 2));

  const pointerStartingY = Number(await game.getAttribute("data-player-y"));
  await movement.getByRole("button", { name: "Move up" }).click();
  await expect.poll(async () => Number(await game.getAttribute("data-player-y"))).toBe(
    pointerStartingY - 2,
  );
  await page.waitForTimeout(180);
  await expect(game).toHaveAttribute("data-player-y", String(pointerStartingY - 2));
});

test("keeps every game control inside a 280px viewport", async ({ page }) => {
  await page.setViewportSize({ width: 280, height: 800 });
  await page.reload();
  await page.getByRole("button", { name: "Start game" }).click();

  const controls = page.locator("[data-direction], #pause-button");
  for (let index = 0; index < (await controls.count()); index += 1) {
    const bounds = await controls.nth(index).boundingBox();
    expect(bounds).not.toBeNull();
    expect(bounds!.x).toBeGreaterThanOrEqual(0);
    expect(bounds!.x + bounds!.width).toBeLessThanOrEqual(280);
  }
});

test("keeps controls reachable in short landscape", async ({ page }) => {
  await page.getByRole("button", { name: "Start game" }).click();
  await page.setViewportSize({ width: 568, height: 320 });

  const controls = page.locator("[data-direction], #pause-button");
  for (let index = 0; index < (await controls.count()); index += 1) {
    const bounds = await controls.nth(index).boundingBox();
    expect(bounds).not.toBeNull();
    expect(bounds!.x).toBeGreaterThanOrEqual(0);
    expect(bounds!.x + bounds!.width).toBeLessThanOrEqual(568);
  }
  await expect(page.locator("#game-wrapper")).toHaveAttribute("data-route", "run");
});

test("fits the complete game surface in tablet landscape", async ({ page }) => {
  await page.setViewportSize({ width: 844, height: 390 });
  await page.reload();
  await page.getByRole("button", { name: "Start game" }).click();

  const dimensions = await page.evaluate(() => ({
    viewport: window.innerHeight,
    document: document.documentElement.scrollHeight,
  }));
  expect(dimensions.document).toBeLessThanOrEqual(dimensions.viewport);
});
