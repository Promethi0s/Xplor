package com.promethi0s.syk0tik.xplor.components.entities;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Tile extends MapObject {

    public static Tile empty = new Tile(Type.empty, 0, 0, 1);

    public Tile(Type type, int x, int y, int scale) {

        super(x * scale, y * scale, scale, scale);

        if (type == Type.grass) {
            sprite = Sprite.grass;
            isCollidable = false;
        }
        if (type == Type.wall) {
            sprite = Sprite.wall;
            isCollidable = true;
        }
        if (type == Type.rock) {
            sprite = Sprite.rock;
            isCollidable = true;
        }
        if (type == Type.empty) {
            sprite = Sprite.empty;
            isCollidable = false;
        }

    }

    public enum Type {

        grass, wall, rock, empty

    }

}
