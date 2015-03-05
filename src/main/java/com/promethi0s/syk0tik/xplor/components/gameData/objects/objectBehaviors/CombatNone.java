package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;

public class CombatNone implements CombatBehavior {

    @Override
    public void attack(MapObject target) {

    }

    @Override
    public void takeDamage(Damage damage) {

    }

    @Override
    public int getFaction() {
        return 0;
    }

}