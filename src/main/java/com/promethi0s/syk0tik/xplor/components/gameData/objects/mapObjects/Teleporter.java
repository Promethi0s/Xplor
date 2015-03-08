package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionLayer0Static;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateTeleporter;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.ActiveTile;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Teleporter extends MapObject implements ActiveTile {


    public Teleporter(Coordinates spawnPoint) {

        setBehaviors(new CollisionBehavior(), new PositionLayer0Static(spawnPoint, Sprite.empty), new UpdateTeleporter(this, new Coordinates(16, 16)), new CombatNone());

    }
}
