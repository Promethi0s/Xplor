package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;

public class CombatProjectile implements CombatBehavior {

    private Damage damage;

    public CombatProjectile(Damage damage) {

        this.damage = damage;

    }

    @Override
    public void attack(MapObject target) {

        target.takeDamage(damage);

    }

    @Override
    public void takeDamage(Damage damage) {

    }

}
