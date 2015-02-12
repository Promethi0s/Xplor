package com.promethi0s.syk0tik.xplor.components.gameData.objects;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Tile extends MapObject {

    public static Tile fog = new Tile(Sprite.empty);
    public static Tile grass = new Tile(Sprite.grass);

    public Tile(Sprite sprite) {

        this.sprite = sprite;

    }

}
