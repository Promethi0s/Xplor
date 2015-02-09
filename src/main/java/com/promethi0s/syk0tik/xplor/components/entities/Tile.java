package com.promethi0s.syk0tik.xplor.components.entities;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Tile extends MapObject {

    public static Tile grass = new Tile(Sprite.grass, false);
    public static Tile wall = new Tile(Sprite.wall, true);
    public static Tile rock = new Tile(Sprite.rock, true);
    public static Tile empty = new Tile(Sprite.empty, true);

    public Tile(Sprite sprite, boolean collidable) {

        this.sprite = sprite;
        this.collidable = collidable;

    }

}
