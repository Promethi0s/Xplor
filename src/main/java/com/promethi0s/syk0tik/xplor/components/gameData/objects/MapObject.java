package com.promethi0s.syk0tik.xplor.components.gameData.objects;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

public class MapObject {

    public static MapObject empty = new MapObject();

    public Sprite sprite;

    public Sprite getSprite() {
        return sprite;
    }

    // Does nothing, unless overridden by subclass
    public void update(Entities entities, Controls controls) {
    }

    public void resetUpdateStatus() {

    }
}
