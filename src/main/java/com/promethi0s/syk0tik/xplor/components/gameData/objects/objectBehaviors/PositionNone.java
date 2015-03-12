package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import java.util.ArrayList;

public class PositionNone implements PositionBehavior {

    private Sprite sprite;

    public PositionNone(Sprite sprite) {

        this.sprite = sprite;

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void followPath(ArrayList<Node> path) {

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
