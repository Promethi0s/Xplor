package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.Player;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;

public class UpdatePlayer implements UpdateBehavior {

    private Player player;
    private Controls controls;
    private Coordinates viewOffset;
    private Settings settings;
    private boolean hasUpdated;

    public UpdatePlayer(Player player, Controls controls, Coordinates viewOffset, Settings settings) {

        this.player = player;
        this.controls = controls;
        this.viewOffset = viewOffset;
        this.settings = settings;
        hasUpdated = false;

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        if (controls.moveUp && !controls.moveDown) player.moveUp();
        if (controls.moveRight && !controls.moveLeft) player.moveRight();
        if (controls.moveDown && !controls.moveUp) player.moveDown();
        if (controls.moveLeft && !controls.moveRight) player.moveLeft();

        if (controls.viewUp && !controls.viewDown) player.faceUp();
        if (controls.viewRight && !controls.viewLeft) player.faceRight();
        if (controls.viewDown && !controls.viewUp) player.faceDown();
        if (controls.viewLeft && !controls.viewRight) player.faceLeft();

        if (controls.attack) player.usePrimaryItem();

        ArrayList<MapObject> attackables = player.getAttackableContacts();
        if (attackables != null) {
            for (MapObject attackable : attackables) {
                player.attack(attackable);
            }
        }

        updateCamera();

        hasUpdated = true;

    }

    @Override
    public void resetUpdateStatus() {

        hasUpdated = false;

    }

    public void updateCamera() {

        viewOffset.x = player.getLoc().x - settings.screenWidth / 2;
        viewOffset.y = player.getLoc().y - settings.screenHeight / 2;

    }

}
