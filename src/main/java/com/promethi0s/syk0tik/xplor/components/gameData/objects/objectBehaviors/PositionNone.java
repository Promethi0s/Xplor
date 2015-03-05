package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class PositionNone implements PositionBehavior {

    private Sprite sprite;

    public PositionNone(Sprite sprite) {

        this.sprite = sprite;

    }

    @Override
    public boolean moveUp() {
        return false;
    }

    @Override
    public boolean moveRight() {
        return false;
    }

    @Override
    public boolean moveDown() {
        return false;
    }

    @Override
    public boolean moveLeft() {
        return false;
    }

    @Override
    public void faceUp() {

    }

    @Override
    public void faceRight() {

    }

    @Override
    public void faceDown() {

    }

    @Override
    public void faceLeft() {

    }

    @Override
    public boolean teleport(Coordinates newLoc) {
        return false;
    }

    @Override
    public int getFaceDir() {
        return 0;
    }

    @Override
    public Coordinates getLoc() {
        return null;
    }

    @Override
    public Bounds getBounds() {
        return null;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void remove() {

    }

}
