package com.promethi0s.syk0tik.xplor.components.gameData;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Tile {

    public static Tile empty = new Tile(Sprite.empty);
    public static Tile grass = new Tile(Sprite.grass);
    public Sprite sprite;

    public Tile(Sprite sprite) {

        this.sprite = sprite;

    }

}
