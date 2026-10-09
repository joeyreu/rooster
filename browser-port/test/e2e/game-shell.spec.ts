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

test("keeps D-pad arrow labels unselectable during touch gestures", async ({ page }) => {
  const styles = await page.getByRole("button", { name: "Move up" }).evaluate((button) => {
    const glyph = button.querySelector("span")!;
    const buttonStyle = getComputedStyle(button);
    const glyphStyle = getComputedStyle(glyph);
    return {
      buttonUserSelect: buttonStyle.userSelect,
      glyphPointerEvents: glyphStyle.pointerEvents,
      glyphUserSelect: glyphStyle.userSelect,
    };
  });

  expect(styles).toEqual({
    buttonUserSelect: "none",
    glyphPointerEvents: "none",
    glyphUserSelect: "none",
  });
});

test("changes held direction while dragging across the D-pad", async ({ page }) => {
  const game = page.locator("#game-wrapper");
  const up = page.getByRole("button", { name: "Move up" });
  const right = page.getByRole("button", { name: "Move right" });
  const left = page.getByRole("button", { name: "Move left" });
  const pad = page.locator("#direction-pad");
  const center = page.locator(".dpad-center");

  await page.getByRole("button", { name: "Start game" }).click();

  const upBounds = await up.boundingBox();
  const rightBounds = await right.boundingBox();
  const leftBounds = await left.boundingBox();
  const padBounds = await pad.boundingBox();
  const centerBounds = await center.boundingBox();
  expect(upBounds).not.toBeNull();
  expect(rightBounds).not.toBeNull();
  expect(leftBounds).not.toBeNull();
  expect(padBounds).not.toBeNull();
  expect(centerBounds).not.toBeNull();

  const startingY = Number(await game.getAttribute("data-player-y"));
  await page.mouse.move(
    upBounds!.x + upBounds!.width / 2,
    upBounds!.y + upBounds!.height / 2,
  );
  await page.mouse.down();
  await expect(up).toHaveAttribute("data-active", "true");
  await expect.poll(async () => Number(await game.getAttribute("data-player-y"))).toBeLessThan(
    startingY,
  );

  const rightStartingX = Number(await game.getAttribute("data-player-x"));
  await page.mouse.move(
    rightBounds!.x + rightBounds!.width / 2,
    rightBounds!.y + rightBounds!.height / 2,
  );
  await expect(up).not.toHaveAttribute("data-active", "true");
  await expect(right).toHaveAttribute("data-active", "true");
  await expect.poll(async () => Number(await game.getAttribute("data-player-x"))).toBeGreaterThan(
    rightStartingX,
  );

  await page.mouse.move(
    centerBounds!.x + centerBounds!.width / 2,
    centerBounds!.y + centerBounds!.height / 2,
  );
  await expect(right).not.toHaveAttribute("data-active", "true");
  await page.waitForTimeout(120);
  const neutralPosition = {
    x: await game.getAttribute("data-player-x"),
    y: await game.getAttribute("data-player-y"),
  };
  await page.waitForTimeout(180);
  await expect(game).toHaveAttribute("data-player-x", neutralPosition.x!);
  await expect(game).toHaveAttribute("data-player-y", neutralPosition.y!);

  await page.mouse.move(
    rightBounds!.x + rightBounds!.width / 2,
    rightBounds!.y + rightBounds!.height / 2,
  );
  await expect(right).toHaveAttribute("data-active", "true");
  await page.mouse.move(padBounds!.x - 8, padBounds!.y + padBounds!.height / 2);
  await expect(right).not.toHaveAttribute("data-active", "true");
  await page.waitForTimeout(120);
  const outsidePosition = {
    x: await game.getAttribute("data-player-x"),
    y: await game.getAttribute("data-player-y"),
  };
  await page.waitForTimeout(180);
  await expect(game).toHaveAttribute("data-player-x", outsidePosition.x!);
  await expect(game).toHaveAttribute("data-player-y", outsidePosition.y!);

  await page.mouse.move(
    leftBounds!.x + leftBounds!.width / 2,
    leftBounds!.y + leftBounds!.height / 2,
  );
  await expect(left).toHaveAttribute("data-active", "true");
  await expect.poll(async () => Number(await game.getAttribute("data-player-x"))).toBeLessThan(
    Number(neutralPosition.x),
  );

  await page.mouse.up();
  await expect(left).not.toHaveAttribute("data-active", "true");
  await page.waitForTimeout(120);
  const releasedPosition = {
    x: await game.getAttribute("data-player-x"),
    y: await game.getAttribute("data-player-y"),
  };
  await page.waitForTimeout(180);
  await expect(game).toHaveAttribute("data-player-x", releasedPosition.x!);
  await expect(game).toHaveAttribute("data-player-y", releasedPosition.y!);
});

test("stops D-pad movement when pointer capture is lost", async ({ page }) => {
  const game = page.locator("#game-wrapper");
  const pad = page.locator("#direction-pad");
  const up = page.getByRole("button", { name: "Move up" });

  await page.getByRole("button", { name: "Start game" }).click();
  await pad.evaluate((element) => {
    element.addEventListener(
      "pointerdown",
      (event) => {
        element.setAttribute("data-test-pointer-id", String((event as PointerEvent).pointerId));
      },
      { once: true },
    );
  });

  const upBounds = await up.boundingBox();
  expect(upBounds).not.toBeNull();
  const startingY = Number(await game.getAttribute("data-player-y"));
  await page.mouse.move(
    upBounds!.x + upBounds!.width / 2,
    upBounds!.y + upBounds!.height / 2,
  );
  await page.mouse.down();
  await expect.poll(async () => Number(await game.getAttribute("data-player-y"))).toBeLessThan(
    startingY,
  );

  await pad.evaluate((element) => {
    const pointerId = Number(element.getAttribute("data-test-pointer-id"));
    element.releasePointerCapture(pointerId);
  });
  await expect(up).not.toHaveAttribute("data-active", "true");
  await page.waitForTimeout(120);
  const cancelledY = await game.getAttribute("data-player-y");
  await page.waitForTimeout(180);
  await expect(game).toHaveAttribute("data-player-y", cancelledY!);
  await page.mouse.up();
});

test("clears a captured D-pad gesture when movement becomes disabled", async ({ page }) => {
  const game = page.locator("#game-wrapper");
  const up = page.getByRole("button", { name: "Move up" });
  const right = page.getByRole("button", { name: "Move right" });

  await page.getByRole("button", { name: "Start game" }).click();
  const upBounds = await up.boundingBox();
  const rightBounds = await right.boundingBox();
  expect(upBounds).not.toBeNull();
  expect(rightBounds).not.toBeNull();

  await page.mouse.move(
    upBounds!.x + upBounds!.width / 2,
    upBounds!.y + upBounds!.height / 2,
  );
  await page.mouse.down();
  await expect(up).toHaveAttribute("data-active", "true");

  await page.evaluate(() => {
    const playtest = (
      window as Window & {
        __ROOSTER_PLAYTEST__?: { completeLevel(): unknown };
      }
    ).__ROOSTER_PLAYTEST__;
    if (playtest === undefined) throw new Error("Missing Rooster playtest API.");
    playtest.completeLevel();
  });

  await expect(game).toHaveAttribute("data-route", "nextLevel");
  await expect(up).toBeDisabled();
  await expect(up).not.toHaveAttribute("data-active", "true");
  await page.mouse.move(
    rightBounds!.x + rightBounds!.width / 2,
    rightBounds!.y + rightBounds!.height / 2,
  );
  await expect(right).not.toHaveAttribute("data-active", "true");
  await page.mouse.up();
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

test("fills the available game width on a narrow portrait screen", async ({ page }) => {
  await page.setViewportSize({ width: 390, height: 844 });
  await page.reload();

  const dimensions = await page.evaluate(() => {
    const canvas = document.querySelector<HTMLCanvasElement>("#game-canvas")!;
    const layout = document.querySelector<HTMLElement>(".play-layout")!;
    const canvasBounds = canvas.getBoundingClientRect();
    const layoutStyle = getComputedStyle(layout);
    const availableWidth =
      layout.clientWidth -
      Number.parseFloat(layoutStyle.paddingLeft) -
      Number.parseFloat(layoutStyle.paddingRight);
    return {
      availableWidth,
      canvasHeight: canvasBounds.height,
      canvasWidth: canvasBounds.width,
      documentWidth: document.documentElement.scrollWidth,
    };
  });

  expect(dimensions.canvasWidth).toBeGreaterThan(dimensions.availableWidth - 3);
  expect(dimensions.canvasWidth / dimensions.canvasHeight).toBeCloseTo(1.5, 2);
  expect(dimensions.documentWidth).toBeLessThanOrEqual(390);
});

test("keeps the scene compact on a narrow, short landscape screen", async ({ page }) => {
  await page.setViewportSize({ width: 540, height: 320 });
  await page.reload();
  await page.getByRole("button", { name: "Start game" }).click();

  const scene = await page.locator("#game-canvas").boundingBox();
  const firstDirection = await page
    .getByRole("button", { name: "Move up" })
    .boundingBox();
  expect(scene).not.toBeNull();
  expect(firstDirection).not.toBeNull();
  expect(scene!.width).toBeLessThanOrEqual(240);
  expect(firstDirection!.y).toBeLessThan(320);
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
