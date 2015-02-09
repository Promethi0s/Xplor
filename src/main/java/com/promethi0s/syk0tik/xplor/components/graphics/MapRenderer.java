package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.levelData.Map;

public class MapRenderer {

    public static void render(Map map, Graphics graphics) {

        // If offset places the view mid tile, create a new start location
        int xTileStart = 0;
        int yTileStart = 0;
        if (graphics.viewOffset.x % map.scale != 0) xTileStart = (graphics.viewOffset.x % map.scale);
        if (graphics.viewOffset.y % map.scale != 0) yTileStart = (graphics.viewOffset.y % map.scale);

        for (int x = graphics.viewOffset.x; x <= graphics.viewOffset.x + graphics.screenSize.x; x += map.scale) {
            for (int y = graphics.viewOffset.y; y <= graphics.viewOffset.y + graphics.screenSize.y; y += map.scale) {
                SpriteRenderer.render(map.getTileAt(x, y).sprite, x - graphics.viewOffset.x - xTileStart, y - graphics.viewOffset.y - yTileStart, graphics);
            }
        }

    }

}