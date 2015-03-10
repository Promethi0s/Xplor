package com.promethi0s.syk0tik.xplor.components.systems;

public class Cooldown {

    private int cooldownTime, counter;

    public Cooldown(int cooldownTime) {

        this.cooldownTime = cooldownTime;
        this.counter = cooldownTime;

    }

    public boolean canCast() {

        if (counter == cooldownTime) {
            counter = 0;
            return true;
        }

        return false;

    }

    public void update() {

        if (counter < cooldownTime) counter++;

    }

}
