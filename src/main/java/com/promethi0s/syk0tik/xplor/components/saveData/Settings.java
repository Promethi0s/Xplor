package com.promethi0s.syk0tik.xplor.components.saveData;

public class Settings {

    public int screenWidth;
    public int screenHeight;
    public int screenScale;

    public Settings() {

        load();

    }

    public void load() {

        screenWidth = 400;
        screenHeight = 300;
        screenScale = 3;

    }
}
