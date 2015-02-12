package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;

import java.util.ArrayList;

public class Tiles extends Map {

    public int scale;

    public Tiles(int width, int height, int scale, ArrayList<MapObject> tiles) {

        super(width, height, tiles);
        this.scale = scale;

    }

}
