package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.TestMob;

import java.util.ArrayList;
import java.util.Random;

public class UpdateTestMob implements UpdateBehavior {

    private TestMob testMob;
    private Random random;
    private int updateCounter;
    private boolean hasUpdated;

    public UpdateTestMob(TestMob testMob) {

        this.testMob = testMob;
        random = new Random();
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;
        int faceDir = testMob.getFaceDir();

        if (updateCounter == 0) faceDir = random.nextInt(4);

        if (faceDir == 0) testMob.moveUp();
        if (faceDir == 1) testMob.moveRight();
        if (faceDir == 2) testMob.moveDown();
        if (faceDir == 3) testMob.moveLeft();

        ArrayList<MapObject> attackables = testMob.getAttackableContacts();
        if (attackables != null) {
            for (MapObject attackable : attackables) {
                testMob.attack(attackable);
            }
        }

        updateCounter++;
        if (updateCounter == 20) updateCounter = 0;

        hasUpdated = true;

    }

    @Override
    public void resetUpdateStatus() {

        hasUpdated = false;

    }

}
