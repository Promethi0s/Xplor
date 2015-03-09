package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.*;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Pathfinding;

import java.util.Random;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer0;
import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer1;

public class Spawner {

    protected static boolean spawnMapObjectLayer0(ObjectType objectType, Coordinates loc) {

        MapObject mapObject = MapObject.empty;

        switch (objectType) {

            case grass:
                mapObject = Tile.grass;
                break;

            case teleporter:
                mapObject = new Teleporter(loc);
                break;

        }

        layer0.set(mapObject, loc);
        return true;

    }

    protected static boolean spawnMapObjectLayer1(ObjectType objectType, Coordinates loc) {

        MapObject mapObject = MapObject.empty;

        switch (objectType) {

            case rock:
                mapObject = new Rock(loc);
                Pathfinding.setInvalidNode(loc);
                break;

            case wall:
                mapObject = new Wall(loc);
                Pathfinding.setInvalidNode(loc);
                break;

            case player:
                mapObject = new Player(loc);
                Map.setClient((Player) mapObject);
                break;

            case testMob:
                mapObject = new TestMob(loc);
                break;

        }

        if (layer1.getObjectAt(loc.x, loc.y) == MapObject.empty) layer1.set(mapObject, loc);
        mapObject.updateContacts();

        if (mapObject.hasCollidableContacts()) {
            layer1.clear(loc);
            return false;
        }

        return true;

    }

    // Temporary method - spawns given object at random position on layer 1.
    protected static void randomSpawnLayer1(ObjectType objectType) {

        Random random = new Random();
        boolean spawned = false;
        while (!spawned) {
            int x = random.nextInt(layer1.width - 1);
            int y = random.nextInt(layer1.height - 1);
            spawned = spawnMapObjectLayer1(objectType, new Coordinates(x, y));
        }

    }

    public static enum ObjectType {
        rock, wall, grass, empty, player, testMob, fireball, teleporter
    }

}
