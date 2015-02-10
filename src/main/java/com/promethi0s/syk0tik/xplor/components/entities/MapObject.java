package com.promethi0s.syk0tik.xplor.components.entities;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.levelData.Coordinates;

public class MapObject {

    public Sprite sprite;
    public Coordinates loc;
    public Bounds bounds;
    public boolean isCollidable;

    public MapObject(int x, int y, int width, int height) {

        this.loc = new Coordinates(x, y);
        this.bounds = new Bounds(x, y, width, height);

    }

    // Checks that both objects are collidable, and if so checks whether bounds intersect
    public boolean collidesWith(MapObject that) {

        if (this.isCollidable && that.isCollidable) {
            return this.bounds.intersects(that.bounds);
        }
        return false;

    }

}
