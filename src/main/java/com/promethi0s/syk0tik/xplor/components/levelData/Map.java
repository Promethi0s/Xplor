package com.promethi0s.syk0tik.xplor.components.levelData;

import com.promethi0s.syk0tik.xplor.components.entities.Tile;

import java.util.Random;

public class Map {

    private int width, height;
    private Tile[] tiles;
    public int scale;

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
                    tiles[x + y * width] = Tile.wall;
                } else {
                    if (random.nextInt(5) == 0) {
                        tiles[x + y * width] = Tile.rock;
                    } else {
                        tiles[x + y * width] = Tile.grass;
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
        if (tiles[x + y * width] == Tile.wall) return Tile.wall;
        if (tiles[x + y * width] == Tile.grass) return Tile.grass;
        if (tiles[x + y * width] == Tile.rock) return Tile.rock;
        return Tile.empty;

    }

}
