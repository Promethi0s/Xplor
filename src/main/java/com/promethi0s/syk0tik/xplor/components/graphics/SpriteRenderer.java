package com.promethi0s.syk0tik.xplor.components.graphics;

public class SpriteRenderer {

    // !Todo Add a green-screen effect to allow irregularly shaped Sprites
    // Writes Sprite at given coordinates into pixels array. Coordinates are in pixel-precision.
    public static void render(Sprite sprite, int xLoc, int yLoc, Graphics graphics) {

        for (int x = 0; x < sprite.scale; x++) {
            for (int y = 0; y < sprite.scale; y++) {
                if (x + xLoc + (y + yLoc) * graphics.screenSize.x >= 0 && x + xLoc + (y + yLoc) * graphics.screenSize.x < graphics.bufferPixels.length) {
                    graphics.bufferPixels[x + xLoc + (y + yLoc) * graphics.screenSize.x] = sprite.pixels[x + y * sprite.scale];
                }
            }
        }

    }
}
