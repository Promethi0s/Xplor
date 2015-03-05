package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class SpriteMultiple implements SpriteBehavior {

    private Sprite[] sprites;

    public SpriteMultiple(Sprite[] sprites) {

        this.sprites = sprites;

    }

    @Override
    public Sprite getSprite() {
        return null;
    }

}
