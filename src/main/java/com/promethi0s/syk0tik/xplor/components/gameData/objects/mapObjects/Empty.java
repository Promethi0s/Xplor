package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateNone;

public class Empty extends MapObject {

    public Empty() {

        setBehaviors(new CollisionBehavior(), new PositionNone(null), new UpdateNone(), new CombatNone());

    }

}
