package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;

import static com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.ProjectileFactory.Type.fireball;

public class ProjectileFactory {

    public static void create(Entity shooter, Type projectileType) {

        int x = 0;
        int y = 0;
        if (shooter.faceDir == 0) {
            x = shooter.loc.x;
            y = shooter.loc.y - shooter.height;
        } else if (shooter.faceDir == 1) {
            x = shooter.loc.x + shooter.width;
            y = shooter.loc.y;
        } else if (shooter.faceDir == 2) {
            x = shooter.loc.x;
            y = shooter.loc.y + shooter.height;
        } else if (shooter.faceDir == 3) {
            x = shooter.loc.x - shooter.width;
            y = shooter.loc.y;
        }
        if (projectileType == fireball) {
            shooter.entities.set(new Fireball(x, y, shooter.faceDir, 16, 16, shooter.entities), new Coordinates(x, y));
        }

    }

    protected enum Type {
        fireball
    }

}
