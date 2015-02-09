package com.promethi0s.syk0tik.xplor.components.entities;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.levelData.Coordinates;
import com.promethi0s.syk0tik.xplor.components.levelData.Map;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

public class Player extends MapObject {

    // !Todo Q for Chris: since I'd have to individually hand Map and Entities to each update method, is it better to keep them as attributes?
    private Sprite[] sprites;
    private int faceDir;
    private Coordinates viewOffset;
    private Settings settings;
    private Map map;
    private MapObject[] entities;
    public Coordinates loc;

    public Player(Coordinates loc, int faceDir, Coordinates viewOffset, Settings settings, Map map, MapObject[] entities) {

        this.loc = loc;
        this.faceDir = faceDir;
        this.viewOffset = viewOffset;
        this.collidable = true;
        this.settings = settings;
        this.map = map;
        this.entities = entities;

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

    }

    private void moveUp() {

        faceDir = 0;
        if (!this.collidesWith(map.getTileAt(loc.x, loc.y - 1))) {
            loc.y--;
            updateCamera();
        }

    }

    private void moveRight() {

        faceDir = 1;
        if (!this.collidesWith(map.getTileAt(loc.x + 17, loc.y))) {
            loc.x++;
            updateCamera();
        }

    }

    private void moveDown() {

        faceDir = 2;
        if (!this.collidesWith(map.getTileAt(loc.x, loc.y + 17))) {
            loc.y++;
            updateCamera();
        }

    }

    private void moveLeft() {

        faceDir = 3;
        if (!this.collidesWith(map.getTileAt(loc.x - 1, loc.y))) {
            loc.x--;
            updateCamera();
        }

    }

    public Sprite getSprite() {

        return sprites[faceDir];

    }

    public void updateCamera() {

        viewOffset.x = loc.x - settings.screenWidth / 2;
        viewOffset.y = loc.y -settings.screenHeight / 2;

    }

}
