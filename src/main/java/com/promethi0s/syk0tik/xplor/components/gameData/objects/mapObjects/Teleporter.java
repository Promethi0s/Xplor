package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.*;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.ActiveTile;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Teleporter extends MapObject implements ActiveTile {


    public Teleporter(int x, int y) {

        setBehaviors(new CollisionBehavior(), new PositionLayer0Static(new Coordinates(x, y), Sprite.empty), new UpdateTeleporter(this, new Coordinates(16, 16)), new InventoryNone(), new CombatNone(), new UseNone(), new BuffNone());

    }
}
