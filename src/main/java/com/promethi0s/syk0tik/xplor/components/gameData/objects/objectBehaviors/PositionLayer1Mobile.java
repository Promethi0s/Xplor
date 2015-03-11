package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer1;

public class PositionLayer1Mobile implements PositionBehavior {

    private MapObject self;
    private Coordinates loc;
    private Bounds bounds;
    private Sprite[] sprites;
    private int faceDir, moveSpeed;

    public PositionLayer1Mobile(MapObject self, Coordinates spawnPoint, int faceDir, int moveSpeed, Sprite[] sprites) {

        this.self = self;
        this.loc = spawnPoint;
        this.faceDir = faceDir;
        this.moveSpeed = moveSpeed;
        this.sprites = sprites;
        bounds = new Bounds(spawnPoint, faceDir, sprites);

    }

    @Override
    public boolean moveUp() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y - moveSpeed);
        faceUp();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    @Override
    public boolean moveRight() {

        Coordinates newLoc = new Coordinates(loc.x + moveSpeed, loc.y);
        faceRight();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    @Override
    public boolean moveDown() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y + moveSpeed);
        faceDown();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    @Override
    public boolean moveLeft() {

        Coordinates newLoc = new Coordinates(loc.x - moveSpeed, loc.y);
        faceLeft();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    @Override
    public void faceUp() {

        faceDir = 0;

    }

    @Override
    public void faceRight() {

        faceDir = 1;

    }

    @Override
    public void faceDown() {

        faceDir = 2;

    }

    @Override
    public void faceLeft() {

        faceDir = 3;

    }

    @Override
    public boolean teleport(Coordinates newLoc) {

        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    @Override
    public int getFaceDir() {
        return faceDir;
    }

    @Override
    public Coordinates getLoc() {

        return loc;

    }

    @Override
    public Bounds getBounds() {

        return bounds;

    }

    @Override
    public Sprite getSprite() {

        return sprites[faceDir];

    }

    @Override
    public void remove() {

        Map.layer1.clear(loc);

    }

}
