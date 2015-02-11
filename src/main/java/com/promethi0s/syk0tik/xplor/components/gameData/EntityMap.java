package com.promethi0s.syk0tik.xplor.components.gameData;

import com.promethi0s.syk0tik.xplor.components.gameData.entities.Entity;
import com.promethi0s.syk0tik.xplor.components.gameData.entities.mobileEntities.Player;

public class EntityMap {

    private Entity[] entities;
    private int width;

    public EntityMap(Entity[] entities, int width) {

        this.entities = entities;
        this.width = width;

    }

    public void update(Map map, Player player) {

        for (Entity entity : entities) {

            if (entities != null) entity.update();

        }

    }

    public Entity getEntityAt(Coordinates coordinates) {

        return entities[coordinates.x + coordinates.y * width];

    }

}
