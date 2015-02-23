package com.promethi0s.syk0tik.xplor.components.saveData;

public class Settings {

    public int screenWidth, screenHeight, screenScale, screenBoundsBuffer;

    public Settings() {

        load();

    }

    public void load() {

        screenWidth = 1920;
        screenHeight = 1080;
        screenScale = 1;
        screenBoundsBuffer = 50;

    }
}
