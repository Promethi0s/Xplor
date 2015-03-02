package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure;

public class Damage {

    public DamageType damageType;
    public int attackPower;

    public Damage(DamageType damageType, int attackPower) {

        this.damageType = damageType;
        this.attackPower = attackPower;

    }

    public static enum DamageType {

        magicDamage, physicalDamage, mixedDamage, trueDamage

    }

}
