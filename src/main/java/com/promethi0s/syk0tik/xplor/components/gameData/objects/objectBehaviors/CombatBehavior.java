package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;

public interface CombatBehavior {

    public void attack(MapObject target);

    public void takeDamage(Damage damage);

    public int getFaction();

}
