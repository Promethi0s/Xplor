package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.*;

import java.util.ArrayList;

import static com.promethi0s.syk0tik.xplor.components.gameData.positioning.PositionHandler.getLayer1CollisionsWith;

// !Todo My thought here is that it would be best if all effects - teleporting, buffing, etc, are initiated by the subject. This is open to change.
// CollisionBehavior holds an array of MapObjects subject is currently in contact with and provides them via getter methods that sort by attribute.
public class CollisionBehavior {

    private ArrayList<MapObject> contacts;

    public CollisionBehavior() {

        contacts = new ArrayList<MapObject>();

    }

    public void updateContacts(MapObject self) {

        contacts = getLayer1CollisionsWith(self);

    }

    public ArrayList<MapObject> getAcquirableContacts() {

        ArrayList<MapObject> returnList = new ArrayList<MapObject>();
        for (MapObject object : contacts) {
            if (object instanceof CanBeUsed) returnList.add(object);
        }

        return returnList;

    }

    public ArrayList<MapObject> getAttackableContacts() {

        ArrayList<MapObject> returnList = new ArrayList<MapObject>();
        for (MapObject object : contacts) {
            if (object instanceof Attackable) returnList.add(object);
        }

        return returnList;

    }

    public ArrayList<MapObject> getBuffableContacts() {

        ArrayList<MapObject> returnList = new ArrayList<MapObject>();
        for (MapObject object : contacts) {
            if (object instanceof CanBeBuffed) returnList.add(object);
        }

        return returnList;

    }

    public ArrayList<MapObject> getPortableContacts() {

        ArrayList<MapObject> returnlist = new ArrayList<MapObject>();
        for (MapObject object : contacts) {
            if (object instanceof CanTeleport) returnlist.add(object);
        }

        return returnlist;

    }

    public boolean hasCollidableContacts() {

        for (MapObject object : contacts) {
            if (object instanceof Collidable) return true;
        }

        return false;

    }

}