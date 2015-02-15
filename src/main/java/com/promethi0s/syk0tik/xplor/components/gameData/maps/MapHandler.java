package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Tile;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.Player;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.Rock;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.TestMob;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.Wall;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;
import java.util.Random;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler.Environment.city;

public class MapHandler {

    private Graphics graphics;
    private Controls controls;
    private Settings settings;
    private Tiles tiles;
    private Entities entities;

    public MapHandler(Graphics graphics, Controls controls, Settings settings) {

        this.graphics = graphics;
        this.controls = controls;
        this.settings = settings;

    }

    public void update() {

        entities.update();

    }

    public int[] render() {

        return graphics.renderMaps(tiles, entities);

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
                tiles.add(x * scale + y * pixelWidth * scale, Tile.grass);
            }
        }

        // Generate static entities
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    entities.add(x * scale + y * pixelWidth * scale, new Wall(x * scale, y * scale, scale));
                } else if (random.nextInt(5) == 0) {
                    entities.add(x * scale + y * pixelWidth * scale, new Rock(x * scale, y * scale, scale));
                }
            }
        }

        this.tiles = new Tiles(pixelWidth, pixelHeight, scale, tiles);
        this.entities = new Entities(pixelWidth, pixelHeight, entities, graphics.viewOffset, controls);

        // Generate player
        spawn:
        {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int spawnLoc = x * scale + y * pixelWidth * scale;
                    if (entities.get(spawnLoc) == MapObject.empty) {
                        this.entities.set(new Player(x * scale, y * scale, 2, scale, scale, this.entities, graphics.viewOffset, settings, controls), new Coordinates(x * scale, y * scale));
                        break spawn;
                    }
                }
            }
        }

        // Generate test mob
        spawn:
        {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int spawnLoc = x * scale + y * pixelWidth * scale;
                    if (entities.get(spawnLoc) == MapObject.empty) {
                        this.entities.set(new TestMob(x * scale, y * scale, 2, scale, scale, this.entities), new Coordinates(x * scale, y * scale));
                        break spawn;
                    }
                }
            }
        }

    }

    public static enum Environment {
        city
    }

}
