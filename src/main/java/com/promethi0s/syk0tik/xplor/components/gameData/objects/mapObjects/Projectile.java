package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CanAttack;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CanCollide;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CanTeleport;

public interface Projectile extends CanAttack, CanTeleport, CanCollide {

}