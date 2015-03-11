package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.Random;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer0;
import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer1;
import static com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler.Environment.city;
import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Spawner.ObjectType.*;

public class MapHandler {

    private Graphics graphics;
    private Settings settings;

    public MapHandler(Graphics graphics, Settings settings) {

        this.graphics = graphics;
        this.settings = settings;

    }

    public void update() {

        Controls.controls.setTargetLocation(graphics.viewOffset, settings);
        layer1.update();
        layer0.update();
        updateCamera();

    }

    public int[] render() {

        return graphics.renderMaps(layer0, layer1);

    }

    public void generateMap(Environment environment, int width, int height, int scale) {

        if (environment == city) {

            generateCity(width, height, scale);

        }
    }

    private void generateCity(int width, int height, int scale) {

        int pixelWidth = width * scale;
        int pixelHeight = height * scale;

        layer0 = new Map(pixelWidth, pixelHeight);
        layer1 = new Map(pixelWidth, pixelHeight);
        Pathfinding.createValidNodes(width, height, scale);

        Random random = new Random();

        // Generate map tiles
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (random.nextInt(1000) == 0) {
                    Spawner.spawnMapObjectLayer0(teleporter, new Coordinates(x * scale, y * scale));
                } else {
                    Spawner.spawnMapObjectLayer0(grass, new Coordinates(x * scale, y * scale));
                }
            }
        }

        // Generate static entities
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    Spawner.spawnMapObjectLayer1(wall, new Coordinates(x * scale, y * scale));
                } else if (random.nextInt(5) == 0) {
                    Spawner.spawnMapObjectLayer1(rock, new Coordinates(x * scale, y * scale));
                }
            }
        }

        // Generate player.
        Spawner.randomSpawnLayer1(player);

        // Generate test mob.
        for (int i = 0; i < 5; i++) {
            Spawner.randomSpawnLayer1(testMob);
        }

    }

    private void updateCamera() {

        graphics.viewOffset.x = Map.getClient().getLoc().x - settings.screenWidth / 2;
        graphics.viewOffset.y = Map.getClient().getLoc().y - settings.screenHeight / 2;

    }

    public static enum Environment {
        city
    }

}
