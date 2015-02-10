package com.promethi0s.syk0tik.xplor.components.levelData;

import com.promethi0s.syk0tik.xplor.components.entities.Tile;
import com.promethi0s.syk0tik.xplor.components.entities.Tile.Type;

import java.util.Random;

public class Map {

    public int scale;
    private int width, height;
    private Tile[] tiles;

    // Initializes a new Map with width, height and scale. This will generate a random Map.
    public Map(int width, int height, int scale) {

        this.width = width;
        this.height = height;
        this.scale = scale;
        tiles =  new Tile[width * height];

        generateMap();
    }

    // Generates random map array.
    private void generateMap() {

        Random random = new Random();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1 || x == 0 || x == width - 1) {
                    tiles[x + y * width] = new Tile(Type.wall, x, y, scale);
                } else {
                    if (random.nextInt(5) == 0) {
                        tiles[x + y * width] = new Tile(Type.rock, x, y, scale);
                    } else {
                        tiles[x + y * width] = new Tile(Type.grass, x, y, scale);
                    }
                }
            }
        }

    }

    // Returns tile at given coordinates. Coordinates are given in pixel-precision.
    public Tile getTileAt(int x, int y) {

        x = x / scale;
        y = y / scale;

        if( x < 0 || y < 0 || x >= width || y >= height) return Tile.empty;
        if (tiles[x + y * width] != null) return tiles[x + y * width];
        return Tile.empty;

    }

}
