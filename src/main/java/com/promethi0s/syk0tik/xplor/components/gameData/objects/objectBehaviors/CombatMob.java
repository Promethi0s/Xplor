package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.Equipable;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.MeleeWeapon;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.Mob;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;

public class CombatMob implements CombatBehavior {

    private Mob self;
    private int health, faction;

    public CombatMob(Mob self, int health, int faction) {

        this.self = self;
        this.health = health;
        this.faction = faction;

    }

    @Override
    public void attack(MapObject target) {

        Equipable activeItem = self.getActiveItem(0);
        if (self.getFaction() != target.getFaction())
            if (activeItem instanceof MeleeWeapon) {

                ((MeleeWeapon) activeItem).moveAttack(target);

            } else {

                // !Todo Potentially replace this code with a default fists weapon.
                target.takeDamage(new Damage(Damage.DamageType.physicalDamage, 1));

            }

    }

    @Override
    public void takeDamage(Damage damage) {

        health -= damage.attackPower;
        if (health <= 0) {

            self.kill();

        }

    }

    @Override
    public int getFaction() {

        return faction;

    }


}
