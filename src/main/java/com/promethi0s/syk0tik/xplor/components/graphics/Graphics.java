package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.gameData.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.EntityMap;
import com.promethi0s.syk0tik.xplor.components.gameData.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.entities.mobileEntities.Player;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

public class Graphics {

    public Coordinates screenSize;
    public int[] bufferPixels;
    public Coordinates viewOffset;

    public Graphics(Settings settings) {

        screenSize = new Coordinates(settings.screenWidth, settings.screenHeight);
        bufferPixels = new int[screenSize.x * screenSize.y];

    }

    // Loads city environment graphics
    public void loadCityEnvironment() {

        SpriteSheet.city.load();

    }

    // Loads player graphics
    public void loadPlayer() {

        SpriteSheet.player.load();

    }

    // Renders running screen given map, player, and entities.
    public int[] renderRunning(Map map, Player player, EntityMap entities, Coordinates viewOffset) {

        this.viewOffset = viewOffset;
        MapRenderer.render(map, this);
        PlayerRenderer.render(player, this);
        //EntityRenderer.render(entities, this);

        return bufferPixels;

    }

    // Clear pixels array to black
    public void clear() {

        for(int i = 0; i < bufferPixels.length; i++) {
            bufferPixels[i] = 0;
        }

    }

}
