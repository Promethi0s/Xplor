package com.promethi0s.syk0tik.xplor.components.graphics;

public class Sprite {

    public static Sprite grass = new Sprite(1, 2, SpriteSheet.city);
    public static Sprite wall = new Sprite(3, 1, SpriteSheet.city);
    public static Sprite rock = new Sprite(2, 6, SpriteSheet.city);
    public static Sprite empty = new Sprite(0, 0, SpriteSheet.city);

    public static Sprite playerUp0 = new Sprite(0, 0, SpriteSheet.player);
    public static Sprite playerUp1 = new Sprite(1, 0, SpriteSheet.player);
    public static Sprite playerUp2 = new Sprite(2, 0, SpriteSheet.player);
    public static Sprite playerUp = new Sprite(new Sprite[]{playerUp0, playerUp1, playerUp2});
    public static Sprite playerRight0 = new Sprite(0, 1, SpriteSheet.player);
    public static Sprite playerRight1 = new Sprite(1, 1, SpriteSheet.player);
    public static Sprite playerRight2 = new Sprite(2, 1, SpriteSheet.player);
    public static Sprite playerRight = new Sprite(new Sprite[]{playerRight0, playerRight1, playerRight2});
    public static Sprite playerDown0 = new Sprite(0, 2, SpriteSheet.player);
    public static Sprite playerDown1 = new Sprite(1, 2, SpriteSheet.player);
    public static Sprite playerDown2 = new Sprite(2, 2, SpriteSheet.player);
    public static Sprite playerDown = new Sprite(new Sprite[]{playerDown0, playerDown1, playerDown2});
    public static Sprite playerLeft0 = new Sprite(0, 3, SpriteSheet.player);
    public static Sprite playerLeft1 = new Sprite(1, 3, SpriteSheet.player);
    public static Sprite playerLeft2 = new Sprite(2, 3, SpriteSheet.player);
    public static Sprite playerLeft = new Sprite(new Sprite[]{playerLeft0, playerLeft1, playerLeft2});
    public static Sprite[] player = new Sprite[]{playerUp, playerRight, playerDown, playerLeft};

    public static Sprite testMobUp = new Sprite(0, 0, SpriteSheet.mobs);
    public static Sprite testMobRight = new Sprite(1, 0, SpriteSheet.mobs);
    public static Sprite testMobDown = new Sprite(2, 0, SpriteSheet.mobs);
    public static Sprite testMobLeft = new Sprite(3, 0, SpriteSheet.mobs);
    public static Sprite[] testMob = new Sprite[]{testMobUp, testMobRight, testMobDown, testMobLeft};

    public static Sprite fireballUp = new Sprite(0, 0, SpriteSheet.projectiles);
    public static Sprite[] fireball = new Sprite[]{fireballUp, fireballUp, fireballUp, fireballUp};
    public int scale;
    // 254 R 254 G 254 B
    public int transparentColor = -65794;
    private int[] pixels;
    private int[][] animatedPixels;
    private boolean animated;
    private int animationCounter = 0;
    private int updateCounter = 0;

    // Initializes a sprite with coordinates and home sheet (coordinates are not pixel-precision)
    public Sprite(int xLoc, int yLoc, SpriteSheet sheet) {

        animated = false;
        this.scale = sheet.scale;

        pixels = new int[sheet.scale * sheet.scale];
        for (int x = 0; x < sheet.scale; x++) {
            for (int y = 0; y < sheet.scale; y++) {
                pixels[x + y * sheet.scale] = sheet.pixels[(x + xLoc * sheet.scale) + (y + yLoc * sheet.scale) * sheet.width];
            }
        }

    }

    public Sprite(Sprite[] sprites) {

        animated = true;
        animatedPixels = new int[sprites.length][];
        for (int i = 0; i < sprites.length; i++) {
            animatedPixels[i] = sprites[i].getPixels();
            if (sprites[i].scale > scale) scale = sprites[i].scale;
        }


    }

    public int[] getPixels() {

        if (animated == true) {
            if (updateCounter == 20) {
                updateCounter = 0;
                animationCounter++;
                if (animationCounter == 3) animationCounter = 0;
            }
            updateCounter++;
            return animatedPixels[animationCounter];
        }
        return pixels;

    }

}
