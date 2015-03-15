package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.Mob;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;

import java.util.ArrayList;

public class UpdateTestMob2 implements UpdateBehavior {

    private Mob testMob;
    private int updateCounter;
    private boolean hasUpdated;
    private ArrayList<Node> path;

    public UpdateTestMob2(Mob testMob) {

        this.testMob = testMob;
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        Coordinates loc = testMob.getLoc();

        if (updateCounter == 0) path = Pathfinding.getPath(loc, Map.getClient().getLoc());

        testMob.followPath(path);


        ArrayList<MapObject> attackables = testMob.getAttackableContacts();
        if (attackables != null) {
            for (MapObject attackable : attackables) {
                testMob.attack(attackable);
            }
        }

        updateCounter++;
        if (updateCounter == 120) updateCounter = 0;

        hasUpdated = true;

    }

    @Override
    public void resetUpdateStatus() {

        hasUpdated = false;

    }

}
