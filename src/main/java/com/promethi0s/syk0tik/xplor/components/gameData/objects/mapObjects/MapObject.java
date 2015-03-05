package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import java.util.ArrayList;

public abstract class MapObject {

    public static MapObject empty = new Empty();

    private CollisionBehavior collisionBehavior;
    private PositionBehavior positionBehavior;
    private UpdateBehavior updateBehavior;
    private CombatBehavior combatBehavior;

    public void setBehaviors(CollisionBehavior collisionBehavior, PositionBehavior positionBehavior, UpdateBehavior updateBehavior, CombatBehavior combatBehavior) {

        this.collisionBehavior = collisionBehavior;
        this.positionBehavior = positionBehavior;
        this.updateBehavior = updateBehavior;
        this.combatBehavior = combatBehavior;

    }

    public void updateContacts() {

        collisionBehavior.updateContacts(this);

    }

    public ArrayList<MapObject> getAcquirableContacts() {

        return collisionBehavior.getAcquirableContacts();

    }

    public ArrayList<MapObject> getAttackableContacts() {

        return collisionBehavior.getAttackableContacts();

    }

    public ArrayList<MapObject> getBuffableContacts() {

        return collisionBehavior.getBuffableContacts();

    }

    public ArrayList<MapObject> getPortableContacts() {

        return collisionBehavior.getPortableContacts();

    }

    public boolean hasCollidableContacts() {

        return collisionBehavior.hasCollidableContacts();

    }

    public void moveUp() {

        positionBehavior.moveUp();

    }

    public void moveRight() {

        positionBehavior.moveRight();

    }

    public void moveDown() {

        positionBehavior.moveDown();

    }

    public void moveLeft() {

        positionBehavior.moveLeft();

    }

    public void faceUp() {

        positionBehavior.faceUp();

    }

    public void faceRight() {

        positionBehavior.faceRight();

    }

    public void faceDown() {

        positionBehavior.faceDown();

    }

    public void faceLeft() {

        positionBehavior.faceLeft();

    }

    public int getFaceDir() {

        return positionBehavior.getFaceDir();

    }

    public boolean teleport(Coordinates newLoc) {

        return positionBehavior.teleport(newLoc);

    }

    public Coordinates getLoc() {

        return positionBehavior.getLoc();

    }

    public Bounds getBounds() {

        return positionBehavior.getBounds();

    }

    public Sprite getSprite() {

        return positionBehavior.getSprite();

    }

    public void kill() {

        positionBehavior.remove();

    }

    public void update() {

        updateBehavior.update();

    }

    public void resetUpdateStatus() {

        updateBehavior.resetUpdateStatus();

    }

    public void attack(MapObject target) {

        combatBehavior.attack(target);

    }

    public void takeDamage(Damage damage) {

        combatBehavior.takeDamage(damage);

    }

    public int getFaction() {

        return combatBehavior.getFaction();

    }

}
