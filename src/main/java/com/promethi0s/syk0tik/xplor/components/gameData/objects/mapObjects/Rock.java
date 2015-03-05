package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionLayer1Static;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.CanCollide;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Rock extends MapObject implements CanCollide {

    public Rock(int x, int y) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Static(new Coordinates(x, y), Sprite.rock), new UpdateNone(), new CombatNone());

    }

}
