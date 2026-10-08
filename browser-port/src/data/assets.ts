/// <reference types="vite/client" />

import backgroundGrassUrl from "../../../recovered/assets/img/level1Background.png";
import dialogConfirmQuitUrl from "../../../recovered/assets/img/reallyQuit.png";
import hudBottomLeftUrl from "../../../recovered/assets/img/hudBL.png";
import hudDigitsBlackUrl from "../../../recovered/assets/img/numbers10_8_black.png";
import hudDigitsWhiteUrl from "../../../recovered/assets/img/numbers10_8_white.png";
import hudScorePanelUrl from "../../../recovered/assets/img/newHUDLeft.png";
import loadingBackgroundUrl from "../../../recovered/assets/img/loaderBack.png";
import loadingBarUrl from "../../../recovered/assets/img/loaderFront.png";
import obstacleGrassUrl from "../../../recovered/assets/img/obstacles_grass1.png";
import overlayGameStatusUrl from "../../../recovered/assets/img/levelComplete_uLose_count.png";
import pickupCounterUrl from "../../../recovered/assets/img/cone_purple.png";
import pickupLifeUrl from "../../../recovered/assets/img/cone_grey.png";
import pickupSpeedUrl from "../../../recovered/assets/img/cone_orange.png";
import playerRoosterDeadUrl from "../../../recovered/assets/img/deadRooster.png";
import playerRoosterUrl from "../../../recovered/assets/img/rooster.png";
import titleBackgroundUrl from "../../../recovered/assets/img/splash_1_3.png";
import titlePromptMaskUrl from "../../../recovered/assets/img/splash_1_3_noClick.png";
import trafficCarsUrl from "../../../recovered/assets/img/cars_1.png";

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
  "traffic.cars": {
    id: "traffic.cars",
    url: trafficCarsUrl,
    sourcePath: "recovered/assets/img/cars_1.png",
    width: 359,
    height: 18,
    sha256: "0e42299ad6bc2b10af388687ebfb752313a70e886db0497882aae5767e79726d",
    atlasId: "traffic.cars",
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
