package com.promethi0s.syk0tik.xplor.components.gameData.entities.staticEntities;

import com.promethi0s.syk0tik.xplor.components.gameData.entities.Entity;

import static com.promethi0s.syk0tik.xplor.components.gameData.entities.staticEntities.MapEntity.Type.rock;
import static com.promethi0s.syk0tik.xplor.components.gameData.entities.staticEntities.MapEntity.Type.wall;

public class MapEntity extends Entity {

    public MapEntity(int x, int y, int scale) {

        super(x, y, scale, scale);

    }

    public static Entity create(Type type, int x, int y, int scale) {

        if (type == rock) return new Rock(x, y, scale);
        if (type == wall) return new Wall(x, y, scale);

        return null;

    }

    public static enum Type {
        rock, wall
    }

}

