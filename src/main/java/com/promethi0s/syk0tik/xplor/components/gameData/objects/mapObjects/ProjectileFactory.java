package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;

public class ProjectileFactory {

    public static void createProjectile(MapObject shooter, Type type) {

        Bounds shooterBounds = shooter.getBounds();
        int faceDir = shooter.getFaceDir();
        int startX, startY;
        if (faceDir == 0) {

        }


    }

    public static enum Type {
        fireball, net, debuff
    }

}
