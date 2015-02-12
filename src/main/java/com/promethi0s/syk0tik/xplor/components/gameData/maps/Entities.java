package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;

public class Entities extends Map {

    private Coordinates viewOffset;
    private Controls controls;

    public Entities(int width, int height, ArrayList<MapObject> entities, Coordinates viewOffset, Controls controls) {

        super(width, height, entities);

        this.viewOffset = viewOffset;
        this.controls = controls;

    }

    public void update() {


    }

}
