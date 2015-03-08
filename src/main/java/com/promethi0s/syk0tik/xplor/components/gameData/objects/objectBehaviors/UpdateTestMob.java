package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.TestMob;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;

import java.util.ArrayList;
import java.util.Random;

public class UpdateTestMob implements UpdateBehavior {

    private TestMob testMob;
    private Random random;
    private int updateCounter;
    private boolean hasUpdated;
    private ArrayList<Node> path;

    public UpdateTestMob(TestMob testMob) {

        this.testMob = testMob;
        random = new Random();
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        Coordinates loc = testMob.getLoc();
        path = Pathfinding.getPath(loc, Map.getClient().getLoc());

        if (path != null) {
            if (path.size() > 0) {
                Coordinates nextNode = path.get(path.size() - 1).getLoc();
                if (loc.y > nextNode.y) testMob.moveUp();
                if (loc.x < nextNode.x) testMob.moveRight();
                if (loc.y < nextNode.y) testMob.moveDown();
                if (loc.x > nextNode.x) testMob.moveLeft();
            }
        }

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
