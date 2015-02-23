package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;

import java.util.ArrayList;

public class Map {

    // !Todo Add functionality for movement-affecting and damaging tiles (lava, water, etc.)
    // Tile layer - no current implemented interactions.
    public static Map layer0;
    // Ground layer - all current implemented interactions.
    public static Map layer1;
    // !Todo Add functionality for air -> ground and ground -> air attacks
    // Air layer - interactions not yet implemented.
    public static Map layer2;
    protected int width, height;
    protected ArrayList<MapObject> objects;

    public Map(int width, int height, ArrayList<MapObject> objects) {

        this.width = width;
        this.height = height;
        this.objects = objects;

    }

    public void update() {

        for (int x = 0; x < objects.size(); x++) {

            MapObject object = objects.get(x);
            object.update();

        }

        for (int x = 0; x < objects.size(); x++) {

            MapObject object = objects.get(x);
            object.resetUpdateStatus();

        }

    }

    // Returns object at given coordinates. Coordinates are given in pixel-precision.
    public MapObject getObjectAt(int x, int y) {

        int pos = x + y * width;
        if (pos >= 0 && pos < objects.size() && x >= 0 && x < width) {
            if (objects.get(pos) != MapObject.empty) return objects.get(pos);
        }
        return MapObject.empty;

    }

    // Sets MapObject at coordinates.
    public void set(MapObject mapObject, Coordinates loc) {

        if (loc.x + loc.y * width >= 0 && loc.x + loc.y * width < objects.size())
            objects.set(loc.x + loc.y * width, mapObject);

    }

    // Moves MapObject from 1st coordinates to 2nd coordinates, sets 1st to empty.
    public boolean move(MapObject mapObject, Coordinates oldLoc, Coordinates newLoc) {

        int pos1 = oldLoc.x + oldLoc.y * width;
        int pos2 = newLoc.x + newLoc.y * width;

        if (pos2 >= 0 && pos2 < objects.size()) {
            objects.set(pos2, mapObject);
            objects.set(pos1, MapObject.empty);
            return true;
        }

        return false;

    }

    // Sets MapObject at coordinates to empty.
    public void clear(Coordinates loc) {

        if (loc.x + loc.y * width >= 0 && loc.x + loc.y * width < objects.size())
            objects.set(loc.x + loc.y * width, MapObject.empty);

    }

}
