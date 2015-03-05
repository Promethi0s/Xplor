package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionNone;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateNone;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

// Tiles are purely cosmetic background objects. Any MapObject that requires interaction will have its own class.
public class Tile extends MapObject {

    public static Tile fog = new Tile(Sprite.empty);
    public static Tile grass = new Tile(Sprite.grass);

    public Tile(Sprite sprite) {

        setBehaviors(new CollisionBehavior(), new PositionNone(sprite), new UpdateNone(), new CombatNone());

    }

}
