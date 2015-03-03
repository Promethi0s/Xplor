package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.*;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;
import java.util.Random;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer0;
import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer1;
import static com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler.Environment.city;

public class MapHandler {

    private Graphics graphics;
    private Controls controls;
    private Settings settings;

    public MapHandler(Graphics graphics, Controls controls, Settings settings) {

        this.graphics = graphics;
        this.controls = controls;
        this.settings = settings;

    }

    public void update() {

        Map.layer1.update();
        Map.layer0.update();

    }

    public int[] render() {

        return graphics.renderMaps(Map.layer0, Map.layer1);

    }

    public void generateMap(Environment environment, int width, int height, int scale) {

        if (environment == city) {

            generateCity(width, height, scale);

        }
    }

    // !Todo Add functionality: spawners, interior walls, multiple environments within map
    private void generateCity(int width, int height, int scale) {

        int pixelWidth = width * scale;
        int pixelHeight = height * scale;

        ArrayList<MapObject> tiles = new ArrayList<MapObject>();
        ArrayList<MapObject> entities = new ArrayList<MapObject>();

        for (int i = 0; i < width * height * scale * scale; i++) {
            tiles.add(MapObject.empty);
            entities.add(MapObject.empty);
        }

        Random random = new Random();

        // !Todo Reversing the x and y variables in the for loops messes the whole thing up. Why is this?
        // Generate map tiles
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (random.nextInt(1000) == 0) {
                    tiles.add(x * scale + y * pixelWidth * scale, new Teleporter(x * scale, y * scale));
                } else {
                    tiles.add(x * scale + y * pixelWidth * scale, Tile.grass);
                }
            }
        }

        // Generate static entities
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    entities.add(x * scale + y * pixelWidth * scale, new Wall(x * scale, y * scale));
                } else if (random.nextInt(5) == 0) {
                    entities.add(x * scale + y * pixelWidth * scale, new Rock(x * scale, y * scale));
                }
            }
        }

        layer0 = new Map(pixelWidth, pixelHeight, tiles);
        layer1 = new Map(pixelWidth, pixelHeight, entities);

        // Generate player
        spawn:
        {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int spawnLoc = x * scale + y * pixelWidth * scale;
                    if (entities.get(spawnLoc) == MapObject.empty) {
                        layer1.set(new Player(x * scale, y * scale, 2, Sprite.player, controls, graphics.viewOffset, settings), new Coordinates(x * scale, y * scale));
                        break spawn;
                    }
                }
            }
        }

        // Generate test mob
        spawn:
        {
            int counter = 0;
            for (int y = height - 1; y >= 0; y--) {
                for (int x = width - 1; x >= 0; x--) {
                    int spawnLoc = x * scale + y * pixelWidth * scale;
                    if (entities.get(spawnLoc) == MapObject.empty) {
                        layer1.set(new TestMob(x * scale, y * scale, 2), new Coordinates(x * scale, y * scale));
                        counter++;
                        if (counter == 500) break spawn;
                    }
                }
            }
        }

    }

    public static enum Environment {
        city
    }

}
