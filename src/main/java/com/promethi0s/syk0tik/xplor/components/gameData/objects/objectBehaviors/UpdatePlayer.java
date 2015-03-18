package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.Player;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Node;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.PositionHandler;

import java.util.ArrayList;

import static com.promethi0s.syk0tik.xplor.components.systems.Controls.controls;

public class UpdatePlayer implements UpdateBehavior {

    private Player player;
    private boolean hasUpdated;
    private MapObject target;
    private Coordinates targetLocation;
    private ArrayList<Node> path;

    public UpdatePlayer(Player player) {

        this.player = player;
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        if (controls.attack) player.usePrimaryItem();
        if (controls.sprint) player.buff(BuffBehavior.BuffType.movement, 2, 1);
        if (controls.moveDown) {
            targetLocation = null;
            path = null;
        }

        setTargetLocation();
        if (targetLocation != null) {
            Coordinates loc = player.getLoc();
            path = Pathfinding.getPath(loc, targetLocation);
        }

        player.followPath(path);

        ArrayList<MapObject> attackables = player.getAttackableContacts();
        if (attackables != null) {
            for (MapObject attackable : attackables) {
                player.attack(attackable);
            }
        }

        player.updateBuffs();

        hasUpdated = true;

    }

    @Override
    public void resetUpdateStatus() {

        hasUpdated = false;

    }

    private void setTargetLocation() {

        if (controls.pointChanged) {
            MapObject interactable = PositionHandler.getLayer1InteractableAt(controls.clickPoint);
            if (interactable !=  null) {
                target = interactable;
            } else {
                target = null;
                targetLocation = controls.clickPoint;
            }
            controls.pointChanged = false;
        }


        if (target != null) {
            targetLocation = target.getLoc();
        }

    }

}
