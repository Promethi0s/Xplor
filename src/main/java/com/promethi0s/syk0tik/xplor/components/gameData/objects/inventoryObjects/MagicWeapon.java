package com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.systems.WorkThread;

import static com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.ProjectileFactory.ProjectileType;
import static com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.ProjectileFactory.createProjectile;

public class MagicWeapon extends InventoryObject implements Equipable {

    MapObject holder;
    ProjectileType projectileType;
    Damage damage;
    long lastUsed;

    public MagicWeapon(MapObject holder, ProjectileType projectileType, Damage damage) {

        this.holder = holder;
        this.projectileType = projectileType;
        this.damage = damage;
        lastUsed = 0;

    }

    @Override
    public void use() {

        if (lastUsed + 10 < WorkThread.updateTimer) {
            createProjectile(holder, projectileType, damage);
            lastUsed = WorkThread.updateTimer;
        }

    }

}
