package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;

import java.util.ArrayList;

public class Map {

    protected int width, height;
    protected ArrayList<MapObject> objects;

    public Map(int width, int height, ArrayList<MapObject> objects) {

        this.width = width;
        this.height = height;
        this.objects = objects;

    }

    // !Todo Is the MapObject.empty technique here okay?
    // Returns object at given coordinates. Coordinates are given in pixel-precision.
    public MapObject getRenderableAt(int x, int y) {

        if (x < 0 || y < 0 || x >= width || y >= height) return null;
        if (objects.get(x + y * width) != MapObject.empty) return objects.get(x + y * width);
        return null;

    }


}
