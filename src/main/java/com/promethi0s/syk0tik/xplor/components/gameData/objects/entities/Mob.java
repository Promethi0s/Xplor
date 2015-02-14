package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

// Adds shared move and attack behavior
public class Mob extends Entity {

    protected Entities entities;

    protected Sprite[] sprites;
    protected int faceDir;

    public Mob(int x, int y, int faceDir, int width, int height, Entities entities, boolean isCollidable) {

        super(x, y, width, height, isCollidable);
        this.entities = entities;
        this.faceDir = faceDir;

    }

    protected void moveUp() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y - 1);
        faceDir = 0;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }

    }

    protected void moveRight() {

        Coordinates newLoc = new Coordinates(loc.x + 1, loc.y);
        faceDir = 1;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }

    }

    protected void moveDown() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y + 1);
        faceDir = 2;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }

    }

    protected void moveLeft() {

        Coordinates newLoc = new Coordinates(loc.x - 1, loc.y);
        faceDir = 3;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }

    }

    protected void attack(Mob target) {

    }

    public boolean collidesWithSurroundings(Coordinates loc) {

        for (int x = loc.x - maxBounds; x <= loc.x + maxBounds; x++) {
            for (int y = loc.y - maxBounds; y <= loc.y + maxBounds; y++) {
                Entity target = entities.getEntityAt(x, y);
                if (!(loc.x == x && loc.y == y) && target != null) {
                    if (this.bounds.intersects(target.bounds)) {
                        if (target.isCollidable) return true;
                    }
                }
            }
        }
        return false;

    }

    public Sprite getSprite() {

        return sprites[faceDir];

    }

}