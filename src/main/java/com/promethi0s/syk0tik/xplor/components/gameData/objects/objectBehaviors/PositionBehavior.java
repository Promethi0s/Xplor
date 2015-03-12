package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import java.util.ArrayList;

public interface PositionBehavior {

    public void moveUp();

    public void moveRight();

    public void moveDown();

    public void moveLeft();

    public void followPath(ArrayList<Node> path);

    public void faceUp();

    public void faceRight();

    public void faceDown();

    public void faceLeft();

    public boolean teleport(Coordinates newLoc);

    public int getFaceDir();

    public Coordinates getLoc();

    public Bounds getBounds();

    public Sprite getSprite();

    void remove();

}
