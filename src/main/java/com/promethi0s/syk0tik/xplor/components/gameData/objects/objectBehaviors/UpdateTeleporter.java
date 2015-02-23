package com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Map;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;

import java.util.ArrayList;

public class UpdateTeleporter implements UpdateBehavior {

    private MapObject self;
    private Coordinates targetLoc;

    public UpdateTeleporter(MapObject self, Coordinates targetLoc) {

        this.self = self;
        this.targetLoc = targetLoc;

    }

    @Override
    public void update() {

        if (Map.layer1.getObjectAt(targetLoc.x, targetLoc.y) == MapObject.empty) {
            self.updateContacts();
            ArrayList<MapObject> contacts = self.getPortableContacts();
            if (contacts.size() > 0) {
                MapObject contact = contacts.get(0);
                Map.layer1.move(contact, contact.getLoc(), targetLoc);
            }
        }

    }

    @Override
    public void resetUpdateStatus() {

    }

}
