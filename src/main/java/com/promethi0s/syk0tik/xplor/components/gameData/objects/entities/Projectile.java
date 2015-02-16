package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;

public class Projectile extends Mob {

    public Projectile(int x, int y, int faceDir, int width, int height, Entities entities) {

        super(x, y, faceDir, width, height, entities, false, false);

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        Coordinates oldLoc = loc;
        if (faceDir == 0) moveUp();
        if (faceDir == 1) moveRight();
        if (faceDir == 2) moveDown();
        if (faceDir == 3) moveLeft();
        if (loc == oldLoc) destroy();

        hasUpdated = true;

    }

}
