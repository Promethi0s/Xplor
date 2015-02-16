package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

public class Graphics {

    public Coordinates screenSize, viewOffset;
    public int screenBoundsBuffer;
    public int[] bufferPixels;

    public Graphics(Settings settings) {

        screenSize = new Coordinates(settings.screenWidth, settings.screenHeight);
        viewOffset = new Coordinates(0, 0);
        screenBoundsBuffer = settings.screenBoundsBuffer;
        bufferPixels = new int[screenSize.x * screenSize.y];

    }

    // Loads player graphics
    public void loadPlayer() {

        SpriteSheet.player.load();

    }

    // Loads mob graphics
    public void loadMobs() {

        SpriteSheet.mobs.load();

    }

    // Loads projectile graphics
    public void loadProjectiles() {

        SpriteSheet.projectiles.load();

    }
    
    // Loads city environment graphics
    public void loadCityEnvironment() {

        SpriteSheet.city.load();

    }

    // Renders running screen given map, player, and entities.
    public int[] renderMaps(Map tiles, Map entities) {

        MapRenderer.render(tiles, this);
        MapRenderer.render(entities, this);

        return bufferPixels;

    }

    // Clear pixels array to black
    public void clear() {

        for(int i = 0; i < bufferPixels.length; i++) {
            bufferPixels[i] = 0;
        }

    }

}
