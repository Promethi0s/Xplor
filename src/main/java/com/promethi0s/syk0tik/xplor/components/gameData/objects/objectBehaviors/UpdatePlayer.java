package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.Player;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;

import static com.promethi0s.syk0tik.xplor.components.systems.Controls.controls;

public class UpdatePlayer implements UpdateBehavior {

    private Player player;
    private boolean hasUpdated;
    private ArrayList<Node> path;

    public UpdatePlayer(Player player) {

        this.player = player;
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        Coordinates loc = player.getLoc();
        Coordinates target = Controls.controls.targetLocation;

        path = Pathfinding.getPath(loc, target);

        player.followPath(path);

        if (controls.attack) player.usePrimaryItem();

        ArrayList<MapObject> attackables = player.getAttackableContacts();
        if (attackables != null) {
            for (MapObject attackable : attackables) {
                player.attack(attackable);
            }
        }

        hasUpdated = true;

    }

    @Override
    public void resetUpdateStatus() {

        hasUpdated = false;

    }

}
