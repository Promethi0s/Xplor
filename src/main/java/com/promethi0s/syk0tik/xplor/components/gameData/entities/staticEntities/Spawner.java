package com.promethi0s.syk0tik.xplor.components.gameData.entities.staticEntities;

import com.promethi0s.syk0tik.xplor.components.gameData.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.entities.Entity;
import com.promethi0s.syk0tik.xplor.components.gameData.entities.mobileEntities.Player;

// !Todo Create algorithm within Map that allows spawners to be created in the middle of 3x3 empty spaces
public class Spawner extends Entity {

    Coordinates[] spawnPoints;

    public Spawner(int x, int y, int width, int height) {

        super(x, y, width, height);

        spawnPoints = new Coordinates[4];
        spawnPoints[0] = new Coordinates(x, y - height);
        spawnPoints[1] = new Coordinates(x + width, y);
        spawnPoints[2] = new Coordinates(x, y + height);
        spawnPoints[3] = new Coordinates(x - width, y);

    }

    // !Todo Based on difficulty, update should only be called x seconds * random(3) + 1
    public void update(Map map, Player player, Entity[] entities) {

        Coordinates spawnPoint = openSpawnPoint();

    }

    public void createMob() {
    }

    public Coordinates openSpawnPoint() {

        for (Coordinates spawnPoint : spawnPoints) {


        }

        return null;

    }

}
