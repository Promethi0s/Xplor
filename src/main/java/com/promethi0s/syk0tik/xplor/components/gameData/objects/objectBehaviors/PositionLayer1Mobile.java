package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.Mob;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import java.util.ArrayList;

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
    public void moveUp() {

        int moveCounter = moveSpeed;

        while (moveCounter > 0) {
            moveCounter--;
            upMove();
        }

    }

    @Override
    public void moveRight() {

        int moveCounter = moveSpeed;

        while (moveCounter > 0) {
            moveCounter--;
            rightMove();
        }

    }

    @Override
    public void moveDown() {

        int moveCounter = moveSpeed;

        while (moveCounter > 0) {
            moveCounter--;
            downMove();
        }

    }

    @Override
    public void moveLeft() {

        int moveCounter = moveSpeed;

        while (moveCounter > 0) {
            moveCounter--;
            leftMove();
        }

    }

    @Override
    public void followPath(ArrayList<Node> path) {

        int movementModifier = 0;

        if (self instanceof Mob) {
            movementModifier = ((Mob)self).getBuff(BuffBehavior.BuffType.movement);
        }
        int moveCounter = moveSpeed + movementModifier;

        while (moveCounter > 0) {
            moveCounter--;
            if (path != null && path.size() > 0) {

                Coordinates nextNode = path.get(path.size() - 1).getLoc();

                if (loc.y > nextNode.y) upMove();
                if (loc.x < nextNode.x) rightMove();
                if (loc.y < nextNode.y) downMove();
                if (loc.x > nextNode.x) leftMove();

                if (loc.equals(nextNode)) {
                    path.remove(path.size() - 1);
                }
            }
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

    public void upMove() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y - 1);
        faceUp();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }

    }

    public void rightMove() {

        Coordinates newLoc = new Coordinates(loc.x + 1, loc.y);
        faceRight();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }

    }

    public void downMove() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y + 1);
        faceDown();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }
    }

    public void leftMove() {

        Coordinates newLoc = new Coordinates(loc.x - 1, loc.y);
        faceLeft();
        layer1.move(self, loc, newLoc);
        bounds.update(newLoc);
        self.updateContacts();
        if (self.hasCollidableContacts()) {
            layer1.move(self, newLoc, loc);
            bounds.update(loc);
        } else {
            loc = newLoc;
        }
    }

}
