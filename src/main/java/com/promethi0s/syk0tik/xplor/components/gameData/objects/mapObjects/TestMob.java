package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.*;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Living;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class TestMob extends Mob implements Living {

    public TestMob(Coordinates spawnPoint, int faceDir) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Mobile(this, spawnPoint, faceDir, 1, Sprite.testMob), new UpdateTestMob(this), new InventoryNone(), new CombatMob(this, 1, 2), new UseNone(), new BuffNone());

    }

}
