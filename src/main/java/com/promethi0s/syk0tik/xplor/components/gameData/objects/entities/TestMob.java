package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class TestMob extends Mob {


    public TestMob(int x, int y, int faceDir, int width, int height, Entities entities) {

        super(x, y, faceDir, width, height, entities, true);

        sprites = new Sprite[4];
        sprites[0] = Sprite.testMobUp;
        sprites[1] = Sprite.testMobRight;
        sprites[2] = Sprite.testMobDown;
        sprites[3] = Sprite.testMobLeft;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        if (faceDir == 0) {
            if (!moveUp()) faceDir++;
        } else if (faceDir == 1) {
            if (!moveRight()) faceDir++;
        } else if (faceDir == 2) {
            if (!moveDown()) faceDir++;
        } else if (faceDir == 3) {
            if (!moveLeft()) faceDir = 0;
        }

        hasUpdated = true;

    }

}
