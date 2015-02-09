package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.entities.MapObject;

public class EntityRenderer {

    public static void render(MapObject[] entities, Graphics graphics) {

        for (MapObject entity : entities) {
            if (entity.loc.x >= graphics.viewOffset.x && entity.loc.x <= graphics.viewOffset.x + graphics.screenSize.x && entity.loc.y >= graphics.viewOffset.y && entity.loc.y <= graphics.viewOffset.y + graphics.screenSize.y) {
                SpriteRenderer.render(entity.sprite, entity.loc.x - graphics.viewOffset.x, entity.loc.y - graphics.viewOffset.y, graphics);
            }
        }

    }

}
