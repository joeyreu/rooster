import { expect, test } from "@playwright/test";

test("keeps the retry state visible after later preload callbacks", async ({ page }) => {
  let failCars = true;
  await page.route("**/cars_1.png*", async (route) => {
    if (route.request().resourceType() === "image" && failCars) {
      return route.abort("failed");
    }
    return route.continue();
  });
  await page.route("**/splash_1_3.png*", async (route) => {
    if (route.request().resourceType() !== "image") return route.continue();
    await new Promise((resolve) => setTimeout(resolve, 250));
    await route.continue();
  });

  await page.goto("/?seed=305419896");
  await expect(page.getByRole("heading", { name: "Couldn’t load Rooster" })).toBeVisible();
  await expect(page.getByRole("button", { name: "Retry" })).toBeVisible();

  await page.waitForTimeout(350);
  await expect(page.getByRole("heading", { name: "Couldn’t load Rooster" })).toBeVisible();
  await expect(page.getByRole("button", { name: "Retry" })).toBeVisible();

  failCars = false;
  await page.evaluate(() => {
    document.addEventListener("focusin", (event) => {
      if (event.target instanceof HTMLElement && event.target.id === "menu-panel") {
        document.documentElement.dataset.loadingFocusSeen = "true";
      }
    });
  });
  await page.getByRole("button", { name: "Retry" }).click();
  await expect(page.locator("html")).toHaveAttribute("data-loading-focus-seen", "true");
  await expect(page.getByRole("button", { name: "Start game" })).toBeFocused();
});
