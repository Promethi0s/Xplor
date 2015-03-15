package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Interactable;

import java.util.ArrayList;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer1;

// Currently handles just layer1 collision, will add layer0 and layer2 functionality.
public class PositionHandler {

    protected static int maxBoundsX, maxBoundsY;

    // Creates an ArrayList with all objects subject collides with, then passes to subject.
    public static ArrayList<MapObject> getLayer1CollisionsWith(MapObject subject) {

        Bounds bounds = subject.getBounds();
        ArrayList<MapObject> collidesWith = getBoundsCollisions(bounds);

        for (int i = 0; i < collidesWith.size(); i++) {
            if (collidesWith.get(i) == subject) collidesWith.remove(i);
        }

        return collidesWith;

    }

    public static MapObject getLayer1InteractableAt(Coordinates loc) {

        Bounds bounds = new Bounds(loc);
        ArrayList<MapObject> collidesWith = getBoundsCollisions(bounds);
        for (int i = 0; i < collidesWith.size(); i++) {
            if (collidesWith.get(i) instanceof Interactable) return collidesWith.get(i);
        }
        return null;

    }

    private static ArrayList<MapObject> getBoundsCollisions(Bounds bounds) {

        ArrayList<MapObject> collidesWith = new ArrayList<MapObject>();

        for (int y = bounds.y0 - maxBoundsY; y <= bounds.y1 + maxBoundsY; y++) {
            for (int x = bounds.x0 - maxBoundsX; x <= bounds.x1 + maxBoundsX; x++) {
                MapObject target = layer1.getObjectAt(x, y);
                if (target != null) {
                    Bounds targetBounds = target.getBounds();
                    if (targetBounds != null) {
                        if (bounds.intersects(target.getBounds())) {
                            collidesWith.add(target);
                        }
                    }
                }
            }
        }

        return collidesWith;

    }

}
