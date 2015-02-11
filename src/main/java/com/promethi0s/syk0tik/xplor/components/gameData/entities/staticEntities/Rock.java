package com.promethi0s.syk0tik.xplor.components.gameData.entities.staticEntities;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Rock extends MapEntity {

    public Rock(int x, int y, int scale) {

        super(x, y, scale);

        sprite = Sprite.rock;
        isCollidable = true;

    }

}
