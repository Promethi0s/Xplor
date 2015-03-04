package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.SpawnHandler;

public class ProjectileFactory {

    public static void createProjectile(MapObject shooter, ProjectileType projectileType, Damage damage) {

        Bounds shooterBounds = shooter.getBounds();
        int faceDir = shooter.getFaceDir();
        Coordinates spawnPoint = SpawnHandler.getProjectileSpawn(shooterBounds, faceDir);
        switch (projectileType) {
            case fireball:
                Map.layer1.set(new Fireball(spawnPoint, faceDir, damage), spawnPoint);
        }

    }

    public static enum ProjectileType {
        fireball, net, debuff
    }

}
