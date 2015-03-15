package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.Equipable;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.InventoryObject;

import java.util.ArrayList;

public class InventoryBehavior {

    private int capacity, maxCapacity, hands;
    private ArrayList<InventoryObject> inventoryObjects;
    private Equipable[] activeObjects;

    public InventoryBehavior(int maxCapacity, int hands) {

        this.maxCapacity = maxCapacity;
        this.hands = hands;
        capacity = 0;
        inventoryObjects = new ArrayList<InventoryObject>();
        activeObjects = new Equipable[hands];

    }

    public boolean addItem(InventoryObject toAdd) {

        if (capacity + toAdd.weight <= maxCapacity) {

            inventoryObjects.add(toAdd);
            capacity += toAdd.weight;
            return true;

        }

        return false;

    }

    public void removeItem(int index) {

    }

    public void moveItem(int index1, int index2) {

        InventoryObject item1 = inventoryObjects.get(index1);
        InventoryObject item2 = inventoryObjects.get(index2);
        inventoryObjects.set(index1, item2);
        inventoryObjects.set(index2, item1);

    }

    public ArrayList<InventoryObject> getItems() {

        return inventoryObjects;

    }

    public void setActiveItem(int inventoryIndex, int activeIndex) {

        InventoryObject toSet = inventoryObjects.get(inventoryIndex);
        if (activeIndex < activeObjects.length && toSet instanceof Equipable) {
            activeObjects[activeIndex] = (Equipable) toSet;
        }

    }

    public Equipable getActiveItem(int index) {

        return activeObjects[index];

    }
}
