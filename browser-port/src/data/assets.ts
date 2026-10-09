/// <reference types="vite/client" />

import backgroundGrassUrl from "../../../recovered/assets/img/level1Background.png";
import backgroundDesertUrl from "../../../recovered/assets/img/level2Background.png";
import backgroundSpaceUrl from "../../../recovered/assets/img/bg_level_space_8.png";
import backgroundSteelUrl from "../../../recovered/assets/img/bg_level_steel_8.png";
import backgroundWaterUrl from "../../../recovered/assets/img/bg_level_water_8.png";
import dialogConfirmQuitUrl from "../../../recovered/assets/img/reallyQuit.png";
import finaleBackgroundUrl from "../../../recovered/assets/img/winGold.png";
import finalePromptUrl from "../../../recovered/assets/img/winGold_finish.png";
import finaleStoryUrl from "../../../recovered/assets/img/winGold_txt.png";
import hudBottomLeftUrl from "../../../recovered/assets/img/hudBL.png";
import hudDigitsBlackUrl from "../../../recovered/assets/img/numbers10_8_black.png";
import hudDigitsWhiteUrl from "../../../recovered/assets/img/numbers10_8_white.png";
import hudScorePanelUrl from "../../../recovered/assets/img/newHUDLeft.png";
import loadingBackgroundUrl from "../../../recovered/assets/img/loaderBack.png";
import loadingBarUrl from "../../../recovered/assets/img/loaderFront.png";
import nextLevelBackgroundUrl from "../../../recovered/assets/img/nextLevel.png";
import nextLevelNamesUrl from "../../../recovered/assets/img/levelNames.png";
import nextLevelPromptUrl from "../../../recovered/assets/img/nextLevel_spaceToPlay.png";
import obstacleDesertUrl from "../../../recovered/assets/img/obstacles_desert1.png";
import obstacleGrassUrl from "../../../recovered/assets/img/obstacles_grass1.png";
import obstacleMetalUrl from "../../../recovered/assets/img/obstacles_metal1.png";
import obstacleSpaceUrl from "../../../recovered/assets/img/obstacles_space1.png";
import obstacleWaterUrl from "../../../recovered/assets/img/obstacles_water1.png";
import overlayGameStatusUrl from "../../../recovered/assets/img/levelComplete_uLose_count.png";
import pickupCounterUrl from "../../../recovered/assets/img/cone_purple.png";
import pickupLifeUrl from "../../../recovered/assets/img/cone_grey.png";
import pickupSpeedUrl from "../../../recovered/assets/img/cone_orange.png";
import playerRoosterBoatDeadUrl from "../../../recovered/assets/img/deadRooster_boat.png";
import playerRoosterBoatUrl from "../../../recovered/assets/img/roosterBoat.png";
import playerRoosterDeadUrl from "../../../recovered/assets/img/deadRooster.png";
import playerRoosterSpaceDeadUrl from "../../../recovered/assets/img/deadRooster_space.png";
import playerRoosterSpaceUrl from "../../../recovered/assets/img/roosterSpace.png";
import playerRoosterTankDeadUrl from "../../../recovered/assets/img/deadRooster_tank.png";
import playerRoosterTankUrl from "../../../recovered/assets/img/roosterTank.png";
import playerRoosterUrl from "../../../recovered/assets/img/rooster.png";
import titleBackgroundUrl from "../../../recovered/assets/img/splash_1_3.png";
import titlePromptMaskUrl from "../../../recovered/assets/img/splash_1_3_noClick.png";
import trafficBoatsUrl from "../../../recovered/assets/img/boats_1.png";
import trafficCarsUrl from "../../../recovered/assets/img/cars_1.png";
import trafficMercUrl from "../../../recovered/assets/img/merc_1.png";
import trafficShipsUrl from "../../../recovered/assets/img/ships_1.png";

export interface AssetCatalogEntry {
  readonly id: string;
  readonly url: string;
  readonly sourcePath: `recovered/assets/img/${string}`;
  readonly width: number;
  readonly height: number;
  readonly sha256: string;
  readonly atlasId?: string;
}

export const ASSET_CATALOG = {
  "background.grass": {
    id: "background.grass",
    url: backgroundGrassUrl,
    sourcePath: "recovered/assets/img/level1Background.png",
    width: 240,
    height: 60,
    sha256: "b30ba4a5ac62e8e9ebc7c7ad45ff86b782670ab06314ecc154ccf6127d738933",
    atlasId: "background.grass",
  },
  "background.desert": {
    id: "background.desert",
    url: backgroundDesertUrl,
    sourcePath: "recovered/assets/img/level2Background.png",
    width: 240,
    height: 60,
    sha256: "df0b8aaefdfabe04b1084906f0422164c548c2f551831dbaea84b63db2cea55e",
    atlasId: "background.desert",
  },
  "background.water": {
    id: "background.water",
    url: backgroundWaterUrl,
    sourcePath: "recovered/assets/img/bg_level_water_8.png",
    width: 240,
    height: 60,
    sha256: "c379f6758ef8b9795e62034a76d7fded1a4c9532c3b9ef12cff0ac82620e93a4",
    atlasId: "background.water",
  },
  "background.steel": {
    id: "background.steel",
    url: backgroundSteelUrl,
    sourcePath: "recovered/assets/img/bg_level_steel_8.png",
    width: 240,
    height: 60,
    sha256: "f964e8f4c1d9a3433c1d96aa53152068b179f1689b39aea68ff24ef176e46243",
    atlasId: "background.steel",
  },
  "background.space": {
    id: "background.space",
    url: backgroundSpaceUrl,
    sourcePath: "recovered/assets/img/bg_level_space_8.png",
    width: 240,
    height: 60,
    sha256: "bec277171ae1da0fdbcc12454f803435e7e03799f84918c5b1c254da24099971",
    atlasId: "background.space",
  },
  "player.rooster": {
    id: "player.rooster",
    url: playerRoosterUrl,
    sourcePath: "recovered/assets/img/rooster.png",
    width: 25,
    height: 300,
    sha256: "423eba0595d451c2573df0cd2be3d146e6b71f3a84e715698e305c02ceeb3383",
    atlasId: "player.rooster",
  },
  "player.roosterDead": {
    id: "player.roosterDead",
    url: playerRoosterDeadUrl,
    sourcePath: "recovered/assets/img/deadRooster.png",
    width: 25,
    height: 25,
    sha256: "bb64a20df5f3bed9b7a3e0476a9d982a1c3be0eea73dafb115e30228734e1fd8",
  },
  "player.roosterBoat": {
    id: "player.roosterBoat",
    url: playerRoosterBoatUrl,
    sourcePath: "recovered/assets/img/roosterBoat.png",
    width: 25,
    height: 300,
    sha256: "06c6d9c0d334c6c25c673ad7e265425e781432245a467b985748b86ff4139c69",
    atlasId: "player.roosterBoat",
  },
  "player.roosterBoatDead": {
    id: "player.roosterBoatDead",
    url: playerRoosterBoatDeadUrl,
    sourcePath: "recovered/assets/img/deadRooster_boat.png",
    width: 25,
    height: 25,
    sha256: "e9427cbb7724e6a2a4572da03653ad825251bda8917c4ce1b4682dbe62e208d1",
  },
  "player.roosterTank": {
    id: "player.roosterTank",
    url: playerRoosterTankUrl,
    sourcePath: "recovered/assets/img/roosterTank.png",
    width: 25,
    height: 300,
    sha256: "faa1dbf14a0275bb259bdbc7b0ad20940ea1f6ad768e120eb8d8208dff5fe6e6",
    atlasId: "player.roosterTank",
  },
  "player.roosterTankDead": {
    id: "player.roosterTankDead",
    url: playerRoosterTankDeadUrl,
    sourcePath: "recovered/assets/img/deadRooster_tank.png",
    width: 25,
    height: 25,
    sha256: "3f938bd3ab5f48a491deb1ef45da2755f62b45d16f58797a2055dcb27da5b71b",
  },
  "player.roosterSpace": {
    id: "player.roosterSpace",
    url: playerRoosterSpaceUrl,
    sourcePath: "recovered/assets/img/roosterSpace.png",
    width: 25,
    height: 300,
    sha256: "ab6ff11897dd2486359a5623bcb5adb0cc92f785cfb79b6c1bf09b0744a068be",
    atlasId: "player.roosterSpace",
  },
  "player.roosterSpaceDead": {
    id: "player.roosterSpaceDead",
    url: playerRoosterSpaceDeadUrl,
    sourcePath: "recovered/assets/img/deadRooster_space.png",
    width: 25,
    height: 25,
    sha256: "5a5c46556c3d46abe536fd7404cd0e470d3aa5def484c3e1a1bb6fd2fff9e068",
  },
  "traffic.cars": {
    id: "traffic.cars",
    url: trafficCarsUrl,
    sourcePath: "recovered/assets/img/cars_1.png",
    width: 359,
    height: 18,
    sha256: "0e42299ad6bc2b10af388687ebfb752313a70e886db0497882aae5767e79726d",
    atlasId: "traffic.cars",
  },
  "traffic.boats": {
    id: "traffic.boats",
    url: trafficBoatsUrl,
    sourcePath: "recovered/assets/img/boats_1.png",
    width: 380,
    height: 18,
    sha256: "0713b4756e626c7ba7c4863f811c98c083787a3499ed2ebc8194b5fc506315af",
    atlasId: "traffic.boats",
  },
  "traffic.merc": {
    id: "traffic.merc",
    url: trafficMercUrl,
    sourcePath: "recovered/assets/img/merc_1.png",
    width: 215,
    height: 18,
    sha256: "b821a32bf54c0c41a7051f7394abda8cb82290038493204442ab3689c20318b7",
    atlasId: "traffic.merc",
  },
  "traffic.ships": {
    id: "traffic.ships",
    url: trafficShipsUrl,
    sourcePath: "recovered/assets/img/ships_1.png",
    width: 137,
    height: 18,
    sha256: "3ae686ac532ed2d4ff79068be5c6ea926db5c05e320a1173c4e7b06e9851d697",
    atlasId: "traffic.ships",
  },
  "obstacle.grass": {
    id: "obstacle.grass",
    url: obstacleGrassUrl,
    sourcePath: "recovered/assets/img/obstacles_grass1.png",
    width: 30,
    height: 45,
    sha256: "665c79d78b28451133b0ff2a932daac749597b303b451b41724ee053a820ae2c",
    atlasId: "obstacle.grass",
  },
  "obstacle.desert": {
    id: "obstacle.desert",
    url: obstacleDesertUrl,
    sourcePath: "recovered/assets/img/obstacles_desert1.png",
    width: 30,
    height: 45,
    sha256: "38383b787cdb218fdee5dec95ffeb410be442f24cbba4a1e459be2833da378f2",
    atlasId: "obstacle.desert",
  },
  "obstacle.water": {
    id: "obstacle.water",
    url: obstacleWaterUrl,
    sourcePath: "recovered/assets/img/obstacles_water1.png",
    width: 30,
    height: 45,
    sha256: "1d2f466c4ed584fc5afed7e9b31df13c0e6178e716917e65bad0fd5ff33bc98e",
    atlasId: "obstacle.water",
  },
  "obstacle.metal": {
    id: "obstacle.metal",
    url: obstacleMetalUrl,
    sourcePath: "recovered/assets/img/obstacles_metal1.png",
    width: 30,
    height: 45,
    sha256: "5625d888b7fe66298dabeef19a6b56f12f17a344d9e79933a322157c1ad4061b",
    atlasId: "obstacle.metal",
  },
  "obstacle.space": {
    id: "obstacle.space",
    url: obstacleSpaceUrl,
    sourcePath: "recovered/assets/img/obstacles_space1.png",
    width: 30,
    height: 45,
    sha256: "477e2bee41f7b2eb4075bc0b70b6e3d67dab24dc1328dfb1c8bfc98f212c35ea",
    atlasId: "obstacle.space",
  },
  "pickup.life": {
    id: "pickup.life",
    url: pickupLifeUrl,
    sourcePath: "recovered/assets/img/cone_grey.png",
    width: 135,
    height: 15,
    sha256: "1c5bc18c955443df91dc65d86a839c8ea857437420483100e0ac5282175e043e",
    atlasId: "pickup.life",
  },
  "pickup.speed": {
    id: "pickup.speed",
    url: pickupSpeedUrl,
    sourcePath: "recovered/assets/img/cone_orange.png",
    width: 135,
    height: 15,
    sha256: "32854d7712f42f4cca6ffe60be753288f747d2656bb7f82b4025d0b0ab743b2d",
    atlasId: "pickup.speed",
  },
  "pickup.counter": {
    id: "pickup.counter",
    url: pickupCounterUrl,
    sourcePath: "recovered/assets/img/cone_purple.png",
    width: 135,
    height: 15,
    sha256: "2d0f4aabc1f5b65883615192d8ebe7873aa8666851da62c8ef9468df98e1d8cf",
    atlasId: "pickup.counter",
  },
  "hud.bottomLeft": {
    id: "hud.bottomLeft",
    url: hudBottomLeftUrl,
    sourcePath: "recovered/assets/img/hudBL.png",
    width: 33,
    height: 16,
    sha256: "e2175b7c2f0b054f613f3f0cae40579a5725ab62b5410e95f70cf0c0e9494f2d",
  },
  "hud.scorePanel": {
    id: "hud.scorePanel",
    url: hudScorePanelUrl,
    sourcePath: "recovered/assets/img/newHUDLeft.png",
    width: 39,
    height: 15,
    sha256: "a7d3806335c5e69d8ccbcb65eac24bba37288ab9e7308d6e2b56fa4ccb4fe610",
  },
  "hud.digitsBlack": {
    id: "hud.digitsBlack",
    url: hudDigitsBlackUrl,
    sourcePath: "recovered/assets/img/numbers10_8_black.png",
    width: 70,
    height: 8,
    sha256: "862b6b508a027dca6e1e530c14f95a295f178efbffe0e0032b01d5b59a14458b",
    atlasId: "hud.digitsBlack",
  },
  "hud.digitsWhite": {
    id: "hud.digitsWhite",
    url: hudDigitsWhiteUrl,
    sourcePath: "recovered/assets/img/numbers10_8_white.png",
    width: 70,
    height: 8,
    sha256: "ab848b339b7784c5daec78fe67cdc20c6fcfcaf801ad9a942ea4e7944bb83010",
    atlasId: "hud.digitsWhite",
  },
  "overlay.gameStatus": {
    id: "overlay.gameStatus",
    url: overlayGameStatusUrl,
    sourcePath: "recovered/assets/img/levelComplete_uLose_count.png",
    width: 179,
    height: 124,
    sha256: "b032b98a07bd225cc9e11eff239311bfaabd874bfbad80e895b575a56a3ee23c",
    atlasId: "overlay.gameStatus",
  },
  "screen.nextLevel.background": {
    id: "screen.nextLevel.background",
    url: nextLevelBackgroundUrl,
    sourcePath: "recovered/assets/img/nextLevel.png",
    width: 240,
    height: 160,
    sha256: "281fc9055a27f3bf98f93c985960d76cb39f09e67c0cd22536e7f953fd1cc2ad",
  },
  "screen.nextLevel.prompt": {
    id: "screen.nextLevel.prompt",
    url: nextLevelPromptUrl,
    sourcePath: "recovered/assets/img/nextLevel_spaceToPlay.png",
    width: 207,
    height: 30,
    sha256: "02239e7bcd77da4dd1f98017c110941224fa6c470dda5f98b36c7c7dbcc5506a",
  },
  "screen.nextLevel.levelNames": {
    id: "screen.nextLevel.levelNames",
    url: nextLevelNamesUrl,
    sourcePath: "recovered/assets/img/levelNames.png",
    width: 215,
    height: 285,
    sha256: "360b13fa511ecdfdb6ab36c6daa1d205a93f681ee2515aa062b7bea9face79fe",
  },
  "screen.finale.background": {
    id: "screen.finale.background",
    url: finaleBackgroundUrl,
    sourcePath: "recovered/assets/img/winGold.png",
    width: 240,
    height: 160,
    sha256: "a9fd7fe4b4cd0a8b28484f8d7a7f87195c2f3df8ee4ea4b85c6345d9ee004237",
  },
  "screen.finale.story": {
    id: "screen.finale.story",
    url: finaleStoryUrl,
    sourcePath: "recovered/assets/img/winGold_txt.png",
    width: 126,
    height: 315,
    sha256: "4ffdabce5d2936d3a303a78e83c38b80e6f9f2edf2badba9ad1e8e7fe1815b4b",
  },
  "screen.finale.prompt": {
    id: "screen.finale.prompt",
    url: finalePromptUrl,
    sourcePath: "recovered/assets/img/winGold_finish.png",
    width: 95,
    height: 30,
    sha256: "c365c1c68c3a579d650d4962e3d67fddb7b8b94b05ba9ec1856512bd927e7382",
  },
  "title.background": {
    id: "title.background",
    url: titleBackgroundUrl,
    sourcePath: "recovered/assets/img/splash_1_3.png",
    width: 240,
    height: 160,
    sha256: "95b8ec712a2a37f6320aecad48c1ef55247bcd8a55bbc8cd9d89bc78f34c3c35",
  },
  "title.promptMask": {
    id: "title.promptMask",
    url: titlePromptMaskUrl,
    sourcePath: "recovered/assets/img/splash_1_3_noClick.png",
    width: 77,
    height: 60,
    sha256: "d9beb8d5b74568a1235a18603b3023875835dcf37da00a4bd650d7883e8bd8c0",
  },
  "loading.background": {
    id: "loading.background",
    url: loadingBackgroundUrl,
    sourcePath: "recovered/assets/img/loaderBack.png",
    width: 148,
    height: 32,
    sha256: "a3aedc208a2dd2a0fe7f7409bae5a6895b5bdf7fc793cb310288d8c007002f74",
  },
  "loading.bar": {
    id: "loading.bar",
    url: loadingBarUrl,
    sourcePath: "recovered/assets/img/loaderFront.png",
    width: 137,
    height: 19,
    sha256: "a3dfb4656ac067abf59fbb1f922ed24dd928e6e91f1a2635ee96fe6caab37013",
  },
  "dialog.confirmQuit": {
    id: "dialog.confirmQuit",
    url: dialogConfirmQuitUrl,
    sourcePath: "recovered/assets/img/reallyQuit.png",
    width: 187,
    height: 67,
    sha256: "58f4de795e6a506eac0c90c582b95b48608b65f6bdbf64e3ea2cc7ef594bb2ef",
  },
} as const satisfies Record<string, AssetCatalogEntry>;

export type AssetId = keyof typeof ASSET_CATALOG;

/** Assets required while playing the recovered twenty-level campaign. */
export const CAMPAIGN_ASSET_IDS = Object.freeze([
  "background.grass",
  "background.desert",
  "background.water",
  "background.steel",
  "background.space",
  "player.rooster",
  "player.roosterDead",
  "player.roosterBoat",
  "player.roosterBoatDead",
  "player.roosterTank",
  "player.roosterTankDead",
  "player.roosterSpace",
  "player.roosterSpaceDead",
  "traffic.cars",
  "traffic.boats",
  "traffic.merc",
  "traffic.ships",
  "obstacle.grass",
  "obstacle.desert",
  "obstacle.water",
  "obstacle.metal",
  "obstacle.space",
  "pickup.life",
  "pickup.speed",
  "pickup.counter",
  "hud.bottomLeft",
  "hud.scorePanel",
  "hud.digitsBlack",
  "hud.digitsWhite",
  "overlay.gameStatus",
  "screen.nextLevel.background",
  "screen.nextLevel.prompt",
  "screen.nextLevel.levelNames",
  "screen.finale.background",
  "screen.finale.story",
  "screen.finale.prompt",
] as const satisfies readonly AssetId[]);

export const FIRST_PASS_ASSET_IDS = Object.freeze([
  "loading.background",
  "loading.bar",
  "background.grass",
  "player.rooster",
  "player.roosterDead",
  "traffic.cars",
  "obstacle.grass",
  "pickup.life",
  "pickup.speed",
  "pickup.counter",
  "hud.bottomLeft",
  "hud.scorePanel",
  "hud.digitsBlack",
  "overlay.gameStatus",
  "title.background",
  "title.promptMask",
] as const satisfies readonly AssetId[]);

export function getAsset(assetId: AssetId): AssetCatalogEntry {
  return ASSET_CATALOG[assetId];
}
