package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public interface PositionBehavior {

    public boolean moveUp();

    public boolean moveRight();

    public boolean moveDown();

    public boolean moveLeft();

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
