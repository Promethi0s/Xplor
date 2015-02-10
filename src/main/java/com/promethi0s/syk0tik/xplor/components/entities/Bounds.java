package com.promethi0s.syk0tik.xplor.components.entities;

import com.promethi0s.syk0tik.xplor.components.levelData.Coordinates;

public class Bounds {

    public int x0, x1, y0, y1, width, height;

    public Bounds(int x, int y, int width, int height) {

        this.width = width;
        this.height = height;
        update(new Coordinates(x, y));

    }

    // Called on creation, and any time an entity's position is updated.
    public void update(Coordinates loc) {

        x0 = loc.x;
        x1 = loc.x + width;
        y0 = loc.y;
        y1 = loc.y + height;

    }

    public boolean intersects(Bounds target) {

        if (this.isIn(target) || target.isIn(this)) return true;
        return false;

    }

    private boolean isIn(Bounds target) {

        if ((x0 >= target.x0 && x0 <= target.x1 && y0 >= target.y0 && y0 <= target.y1) ||
                (x1 >= target.x0 && x1 <= target.x1 && y0 >= target.y0 && y0 <= target.y1) ||
                (x0 >= target.x0 && x0 <= target.x1 && y1 >= target.y0 && y1 <= target.y1) ||
                (x1 >= target.x0 && x1 <= target.x1 && y1 >= target.y0 && y1 <= target.y1)) return true;

        return false;

    }

}
