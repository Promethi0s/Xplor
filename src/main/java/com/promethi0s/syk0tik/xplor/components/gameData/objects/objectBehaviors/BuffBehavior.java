package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.buffs.Buff;

import java.util.HashMap;
import java.util.Map;

public class BuffBehavior {

    private Map<BuffType, Buff> buffs;

    public BuffBehavior() {

        buffs = new HashMap<BuffType, Buff>();

    }

    public void buff(BuffType buffType, int power, int duration) {

        buffs.put(buffType, new Buff(power, duration));

    }

    public int getBuff(BuffType buffType) {

        if (buffs.get(buffType) != null) {
            return buffs.get(buffType).power;
        } else {
            return 0;
        }

    }

    public void cleanse() {

        buffs.clear();

    }

    public void update() {

        for (BuffType key : buffs.keySet()) {

            Buff buff = buffs.get(key);
            buff.duration--;
            if (buff.duration == 0) buffs.remove(key);

        }

    }

    public static enum BuffType {
        movement
    }

}
