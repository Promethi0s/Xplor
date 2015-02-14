package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;

public class Entity extends MapObject {

    protected Coordinates loc;
    protected Bounds bounds;
    protected int maxBounds;
    protected boolean isCollidable;
    protected boolean hasUpdated;

    public Entity(int x, int y, int width, int height, boolean isCollidable) {

        this.loc = new Coordinates(x, y);
        this.bounds = new Bounds(x, y, width, height);
        this.isCollidable = isCollidable;
        if (width > maxBounds) maxBounds = width;
        if (height > maxBounds) maxBounds = height;

    }

    @Override
    public void resetUpdateStatus() {
        hasUpdated = false;
    }

}
