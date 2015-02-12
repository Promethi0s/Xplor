package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Tile;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.Rock;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.Wall;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;
import java.util.Random;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.MapHandler.Environment.city;

public class MapHandler {

    private Graphics graphics;
    private Controls controls;
    private Tiles tileMap;
    private Entities entityMap;

    public MapHandler(Graphics graphics, Controls controls) {

        this.graphics = graphics;
        this.controls = controls;

    }

    public void update() {

        entityMap.update();

    }

    public int[] render() {

        return graphics.renderMaps(tileMap, entityMap);

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

        // Generate map tiles
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles.add(x * scale + y * pixelWidth * scale, Tile.grass);
            }
        }

        // Generate static entities
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    entities.add(x * scale + y * pixelWidth * scale, new Wall(x, y, scale));
                } else if (random.nextInt(5) == 0) {
                    entities.add(x * scale + y * pixelWidth * scale, new Rock(x, y, scale));
                }
            }
        }

        tileMap = new Tiles(pixelWidth, pixelHeight, scale, tiles);
        entityMap = new Entities(pixelWidth, pixelHeight, entities, graphics.viewOffset, controls);

    }

    public static enum Environment {
        city
    }

}
