package com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage.DamageType;

import static com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage.DamageType.*;

public class Weapon extends InventoryObject {

    private Damage damage;
    private Damage onHit;
    private int range;


    public Weapon(DamageType damageType, int attackPower, int range) {

        damage = new Damage(damageType, attackPower);
        this.range = range;

    }

    public void attack(MapObject target) {

        target.takeDamage(damage);
        if (onHit != null && target != null) target.takeDamage(onHit);

    }

    public void enchant(Damage.DamageType damageType, int attackPower, int range) {

        switch (damageType) {
            case physicalDamage:
                if (damage.damageType == magicDamage) damage.damageType = mixedDamage;
                break;
            case magicDamage:
                if (damage.damageType == physicalDamage) damage.damageType = mixedDamage;
                break;
            case trueDamage:
                damage.damageType = trueDamage;
                break;
            default:
                break;
        }

        damage.attackPower += attackPower;
        this.range += range;

    }

    public void enchant(Damage damage) {

        onHit = damage;

    }

}