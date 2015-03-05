package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.Equipable;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.InventoryObject;

import java.util.ArrayList;

public interface InventoryBehavior {

    public boolean addItem(InventoryObject toAdd);

    public void removeItem(int index);

    public void moveItem(int oldIndex, int newIndex);

    public ArrayList<InventoryObject> getItems();

    public void setActiveItem(int inventoryIndex, int activeIndex);

    public Equipable getActiveItem(int index);

}
