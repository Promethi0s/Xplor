package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.InventoryObject;

import java.util.ArrayList;

public class InventoryStandard implements InventoryBehavior {

    private int capacity;
    private int maxCapacity;
    private ArrayList<InventoryObject> inventoryObjects, activeObjects;

    public InventoryStandard(int maxCapacity, int hands) {

        this.maxCapacity = maxCapacity;
        capacity = 0;
        inventoryObjects = new ArrayList<InventoryObject>();
        activeObjects = new ArrayList<InventoryObject>(hands);

    }

    @Override
    public boolean addItem(InventoryObject toAdd) {

        if (capacity + toAdd.weight <= maxCapacity) {

            inventoryObjects.add(toAdd);
            capacity += toAdd.weight;
            return true;

        }

        return false;

    }

    @Override
    public void removeItem(int index) {

    }

    @Override
    public void moveItem(int index1, int index2) {

        InventoryObject item1 = inventoryObjects.get(index1);
        InventoryObject item2 = inventoryObjects.get(index2);
        inventoryObjects.set(index1, item2);
        inventoryObjects.set(index2, item1);

    }

    @Override
    public ArrayList<InventoryObject> getItems() {

        return inventoryObjects;

    }

    @Override
    public void setActiveItem(int inventoryIndex, int activeIndex) {

        activeObjects.set(activeIndex, inventoryObjects.get(inventoryIndex));

    }

    @Override
    public InventoryObject getActiveItem(int index) {

        return activeObjects.get(index);

    }
}
