package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.maps.Tiles;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

public class Player extends Entity {

    // !Todo Q for Chris: since I'd have to individually hand Map and Entities to each update method, is it better to keep them as attributes?
    private Sprite[] sprites;
    private int faceDir;
    private Coordinates viewOffset;
    private Settings settings;
    private Tiles map;
    private Entities entities;

    public Player(int xLoc, int yLoc, int faceDir, Coordinates viewOffset, Settings settings, Tiles map, Entities entities) {

        super(xLoc, yLoc, map.scale, map.scale);
        this.faceDir = faceDir;
        this.viewOffset = viewOffset;
        this.isCollidable = true;
        this.settings = settings;
        this.map = map;
        this.entities = entities;

        // !Todo Create sprites for diagonal movement and incorporate thems
        sprites = new Sprite[4];
        sprites[0] = Sprite.playerUp;
        sprites[1] = Sprite.playerRight;
        sprites[2] = Sprite.playerDown;
        sprites[3] = Sprite.playerLeft;

        updateCamera();

    }

    public void update(Controls controls) {

        if (controls.moveUp && !controls.moveDown) moveUp();
        if (controls.moveRight && !controls.moveLeft) moveRight();
        if (controls.moveDown && !controls.moveUp) moveDown();
        if (controls.moveLeft && !controls.moveRight) moveLeft();

        updateCamera();

    }

    private void moveUp() {

        faceDir = 0;
        loc.y--;
        bounds.update(loc);
        /*
        if (this.collidesWith(map.getRenderableAt(loc.x, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x, loc.y + 15)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y + 15))) {
            loc.y++;
            bounds.update(loc);

        }
        */

    }

    private void moveRight() {

        faceDir = 1;
        loc.x++;
        bounds.update(loc);
        /*
        if (this.collidesWith(map.getRenderableAt(loc.x, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x, loc.y + 15)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y + 15))) {
            loc.x--;
            bounds.update(loc);
        }
        */
    }

    private void moveDown() {

        faceDir = 2;
        loc.y++;
        bounds.update(loc);
        /*
        if (this.collidesWith(map.getRenderableAt(loc.x, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x, loc.y + 15)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y + 15))) {
            loc.y--;
            bounds.update(loc);
        }
        */
    }

    private void moveLeft() {

        faceDir = 3;
        loc.x--;
        bounds.update(loc);
        /*
        if (this.collidesWith(map.getRenderableAt(loc.x, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y)) ||
                this.collidesWith(map.getRenderableAt(loc.x, loc.y + 15)) ||
                this.collidesWith(map.getRenderableAt(loc.x + 15, loc.y + 15))) {
            loc.x++;
            bounds.update(loc);
        }
        */
    }

    public Sprite getSprite() {

        return sprites[faceDir];

    }

    public void updateCamera() {

        viewOffset.x = loc.x - settings.screenWidth / 2;
        viewOffset.y = loc.y - settings.screenHeight / 2;

    }

}