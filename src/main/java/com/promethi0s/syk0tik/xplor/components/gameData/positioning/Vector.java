package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

public class Vector {

    protected int x, y;

    protected Vector(Coordinates loc) {

        x = loc.x / Pathfinding.scale;
        y = loc.y / Pathfinding.scale;

    }

    protected Vector(int x, int y) {

        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Vector) {

            Vector vec = (Vector) object;
            if (vec.x == x && vec.y == y) return true;

        }

        return false;
    }

}
