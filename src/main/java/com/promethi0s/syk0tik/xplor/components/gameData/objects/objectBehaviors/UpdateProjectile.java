package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;

import java.util.ArrayList;

public class UpdateProjectile implements UpdateBehavior {

    private MapObject self;
    private boolean hasUpdated;

    public UpdateProjectile(MapObject self) {

        this.self = self;
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        int faceDir = self.getFaceDir();
        Coordinates beforeMove = self.getLoc();

        switch (faceDir) {
            case 0:
                self.moveUp();
                break;
            case 1:
                self.moveRight();
                break;
            case 2:
                self.moveDown();
                break;
            case 3:
                self.moveLeft();
                break;
        }

        Coordinates afterMove = self.getLoc();
        ArrayList<MapObject> attackables = self.getAttackableContacts();
        if (attackables != null) {
            for (MapObject attackable : attackables) {
                self.attack(attackable);
            }
        }

        hasUpdated = true;

        if (beforeMove == afterMove) {

            self.kill();

        }

    }

    @Override
    public void resetUpdateStatus() {

        hasUpdated = false;

    }

}
