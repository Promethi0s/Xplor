package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.MagicWeapon;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.*;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Living;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

public class Player extends Mob implements Living {

    public Player(Coordinates spawnPoint, int faceDir, Sprite[] sprites, Controls controls, Coordinates viewOffset, Settings settings) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Mobile(this, spawnPoint, faceDir, 1, sprites), new UpdatePlayer(this, controls, viewOffset, settings), new InventoryStandard(10, 2), new CombatMob(this, 10, 1), new UseNone(), new BuffNone());
        addItem(new MagicWeapon(this, ProjectileFactory.ProjectileType.fireball, new Damage(Damage.DamageType.magicDamage, 10)));
        setActiveItem(0, 0);

    }

}