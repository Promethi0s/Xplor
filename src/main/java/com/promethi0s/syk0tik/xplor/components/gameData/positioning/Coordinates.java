package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

public class Coordinates {

    public int x, y;

    public Coordinates() {

        x = 0;
        y = 0;

    }

    public Coordinates(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public void add(Coordinates coordinates) {

        x += coordinates.x;
        y += coordinates.y;

    }

    public Coordinates plus(Coordinates coordinates) {

        int rX = x += coordinates.x;
        int rY = y += coordinates.y;
        return new Coordinates(rX, rY);

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
