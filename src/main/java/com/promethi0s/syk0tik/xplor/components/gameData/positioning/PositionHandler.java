package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects.MapObject;

import java.util.ArrayList;

import static com.promethi0s.syk0tik.xplor.components.gameData.maps.Map.layer1;

// Currently handles just layer1 collision, will add layer0 and layer2 functionality.
public class PositionHandler {

    protected static int maxBoundsX, maxBoundsY;

    // Creates an ArrayList with all objects subject collides with, then passes to subject.
    public static ArrayList<MapObject> collidesWithSurroundingsLayer1(MapObject subject) {

        ArrayList<MapObject> collidesWith = new ArrayList<MapObject>();

        Bounds subjectBounds = subject.getBounds();

        for (int y = subjectBounds.y0 - maxBoundsY; y <= subjectBounds.y1 + maxBoundsY; y++) {
            for (int x = subjectBounds.x0 - maxBoundsX; x <= subjectBounds.x1 + maxBoundsX; x++) {
                MapObject target = layer1.getObjectAt(x, y);
                if ((target != subject) && target != null) {
                    Bounds targetBounds = target.getBounds();
                    if (targetBounds != null) {
                        if (subjectBounds.intersects(target.getBounds())) {
                            collidesWith.add(target);
                        }
                    }
                }
            }
        }

        return collidesWith;

    }

    public static MapObject getInteractableAt(Coordinates loc) {

        return null;

    }

}
