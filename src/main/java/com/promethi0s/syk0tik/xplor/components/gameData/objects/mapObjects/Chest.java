package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionLayer1Static;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.ActiveTile;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Chest extends MapObject implements ActiveTile {

    public Chest(Coordinates spawnPoint) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Static(spawnPoint, Sprite.empty), new UpdateNone(), new CombatNone());

    }

}
