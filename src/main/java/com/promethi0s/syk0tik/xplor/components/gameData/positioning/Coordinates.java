package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

public class Coordinates {

    public int x, y;

    public Coordinates(int x, int y) {

        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Coordinates) {

            Coordinates coord = (Coordinates) object;
            if (coord.x == x && coord.y == y) return true;

        }

        return false;
    }

}
