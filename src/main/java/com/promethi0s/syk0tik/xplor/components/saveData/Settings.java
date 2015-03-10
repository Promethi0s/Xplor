package com.promethi0s.syk0tik.xplor.components.saveData;

public class Settings {

    public int screenWidth, screenHeight, screenScale, screenBoundsBuffer;

    public Settings() {

        load();

    }

    public void load() {

        screenWidth = 800;
        screenHeight = 500;
        screenScale = 2;
        screenBoundsBuffer = 50;

    }
}
