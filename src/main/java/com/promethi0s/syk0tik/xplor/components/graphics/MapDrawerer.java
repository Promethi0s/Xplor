package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;

class MapDrawerer {

    public static void draw(Map map, Graphics graphics) {

        // Starting at offset - bounds buffer, iterate through all visible tiles, including one extra on bottom to prevent partial rendering
        for (int y = graphics.viewOffset.y - graphics.screenBoundsBuffer; y < graphics.viewOffset.y + graphics.screenSize.y; y++) {
            for (int x = graphics.viewOffset.x - graphics.screenBoundsBuffer; x < graphics.viewOffset.x + graphics.screenSize.x; x++) {
                MapObject object = map.getObjectAt(x, y);
                if (object != MapObject.empty)
                    SpriteDrawerer.draw(object.getSprite(), x - graphics.viewOffset.x, y - graphics.viewOffset.y, graphics);
            }
        }

    }

}