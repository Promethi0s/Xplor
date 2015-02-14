package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

public class Player extends Mob {

    // !Todo Q for Chris: since I'd have to individually hand Map and Entities to each update method, is it better to keep them as attributes?

    private Coordinates viewOffset;
    private Settings settings;
    private Controls controls;

    public Player(int xLoc, int yLoc, int faceDir, int width, int height, Entities entities, Coordinates viewOffset, Settings settings, Controls controls) {

        super(xLoc, yLoc, faceDir, width, height, entities, true);
        this.viewOffset = viewOffset;
        this.settings = settings;
        this.controls = controls;

        // !Todo Create sprites for diagonal movement and incorporate them
        sprites = new Sprite[4];
        sprites[0] = Sprite.playerUp;
        sprites[1] = Sprite.playerRight;
        sprites[2] = Sprite.playerDown;
        sprites[3] = Sprite.playerLeft;

        updateCamera();

    }

    @Override
    public void update(Entities entities, Controls controls) {

        if (hasUpdated) return;

        if (controls.moveUp && !controls.moveDown) moveUp();
        if (controls.moveRight && !controls.moveLeft) moveRight();
        if (controls.moveDown && !controls.moveUp) moveDown();
        if (controls.moveLeft && !controls.moveRight) moveLeft();

        updateCamera();

        hasUpdated = true;

    }


    public void updateCamera() {

        viewOffset.x = loc.x - settings.screenWidth / 2;
        viewOffset.y = loc.y - settings.screenHeight / 2;

    }

}