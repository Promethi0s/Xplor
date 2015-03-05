package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.Equipable;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.InventoryObject;

import java.util.ArrayList;

public class InventoryNone implements InventoryBehavior {

    @Override
    public boolean addItem(InventoryObject toAdd) {

        return false;

    }

    @Override
    public void removeItem(int index) {

    }

    @Override
    public void moveItem(int oldIndex, int newIndex) {

    }

    @Override
    public ArrayList<InventoryObject> getItems() {
        return null;
    }

    @Override
    public void setActiveItem(int inventoryIndex, int activeIndex) {

    }

    @Override
    public Equipable getActiveItem(int index) {
        return null;
    }
}
