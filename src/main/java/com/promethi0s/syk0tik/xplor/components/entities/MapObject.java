package com.promethi0s.syk0tik.xplor.components.entities;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.levelData.Coordinates;

public class MapObject {

    public Sprite sprite;
    public Coordinates loc;
    public boolean collidable;

    public boolean collidesWith(MapObject target) {

        if (this.collidable && target.collidable) return true;
        return false;

    }

}
