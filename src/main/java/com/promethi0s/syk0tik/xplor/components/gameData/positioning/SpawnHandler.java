package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

public class SpawnHandler {

    public static Coordinates getProjectileSpawn(Bounds shooterBounds, int faceDir) {

        int xStart = 0;
        int yStart = 0;

        switch (faceDir) {
            case 0:
                xStart = shooterBounds.x0;
                yStart = shooterBounds.y0 - PositionHandler.maxBoundsY;
                break;
            case 1:
                xStart = shooterBounds.x1;
                yStart = shooterBounds.y0;
                break;
            case 2:
                xStart = shooterBounds.x0;
                yStart = shooterBounds.y1;
                break;
            case 3:
                xStart = shooterBounds.x0 - PositionHandler.maxBoundsX;
                yStart = shooterBounds.y0;
                break;

        }

        return new Coordinates(xStart, yStart);

    }


}
