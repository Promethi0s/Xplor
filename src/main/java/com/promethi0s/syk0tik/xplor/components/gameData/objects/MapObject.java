package com.promethi0s.syk0tik.xplor.components.gameData.objects;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class MapObject {

    public static MapObject empty = new MapObject();

    public Sprite sprite;

    public Sprite getSprite() {
        return sprite;
    }

    // Does nothing, unless overridden by subclass
    public void update() {
    }

    public void resetUpdateStatus() {

    }
}
