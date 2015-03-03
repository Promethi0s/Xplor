package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.inventoryObjects.InventoryObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.*;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Living;

import java.util.ArrayList;

public class Mob extends MapObject implements Living {

    private InventoryBehavior inventoryBehavior;
    private UseBehavior useBehavior;
    private BuffBehavior buffBehavior;

    public void setBehaviors(CollisionBehavior collisionBehavior, PositionBehavior positionBehavior, UpdateBehavior updateBehavior, InventoryBehavior inventoryBehavior, CombatBehavior combatBehavior, UseBehavior useBehavior, BuffBehavior buffBehavior) {

        super.setBehaviors(collisionBehavior, positionBehavior, updateBehavior, combatBehavior);
        this.inventoryBehavior = inventoryBehavior;
        this.useBehavior = useBehavior;
        this.buffBehavior = buffBehavior;

    }

    public boolean addItem(InventoryObject toAdd) {

        return inventoryBehavior.addItem(toAdd);

    }

    public void removeItem(int index) {

        inventoryBehavior.removeItem(index);

    }

    public void moveItem(int oldIndex, int newIndex) {

        inventoryBehavior.moveItem(oldIndex, newIndex);

    }

    public ArrayList<InventoryObject> getItems() {

        return inventoryBehavior.getItems();

    }

    public void setActiveItem(int inventoryIndex, int activeIndex) {

        inventoryBehavior.setActiveItem(inventoryIndex, activeIndex);

    }

    public InventoryObject getActiveItem(int index) {

        return inventoryBehavior.getActiveItem(index);

    }

}
