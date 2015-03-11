package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.TestMob;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;

import java.util.ArrayList;

public class UpdateTestMob implements UpdateBehavior {

    private TestMob testMob;
    private int updateCounter;
    private boolean hasUpdated;
    private ArrayList<Node> path;

    public UpdateTestMob(TestMob testMob) {

        this.testMob = testMob;
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        Coordinates loc = testMob.getLoc();

        if (updateCounter == 0) path = Pathfinding.getPath(loc, Map.getClient().getLoc());

        if (path != null && path.size() > 0) {

            Coordinates nextNode = path.get(path.size() - 1).getLoc();

            if (loc.y > nextNode.y) testMob.moveUp();
            if (loc.x < nextNode.x) testMob.moveRight();
            if (loc.y < nextNode.y) testMob.moveDown();
            if (loc.x > nextNode.x) testMob.moveLeft();

            if (loc.equals(nextNode)) {
                path.remove(path.size() - 1);
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
