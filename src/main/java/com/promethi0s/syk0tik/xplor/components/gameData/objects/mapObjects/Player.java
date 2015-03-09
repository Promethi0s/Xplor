package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.MagicWeapon;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.*;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Living;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Player extends Mob implements Living {

    public Player(Coordinates spawnPoint) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Mobile(this, spawnPoint, 0, 1, Sprite.player), new UpdatePlayer(this), new InventoryStandard(10, 2), new CombatMob(this, 10, 1), new UseNone(), new BuffNone());
        addItem(new MagicWeapon(this, ProjectileFactory.ProjectileType.fireball, new Damage(Damage.DamageType.magicDamage, 10)));
        setActiveItem(0, 0);

    }

}