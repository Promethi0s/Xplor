package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionLayer1Static;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Collidable;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Wall extends MapObject implements Collidable {

    public Wall(Coordinates spawnPoint) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Static(spawnPoint, Sprite.wall), new UpdateNone(), new CombatNone());

    }

}
