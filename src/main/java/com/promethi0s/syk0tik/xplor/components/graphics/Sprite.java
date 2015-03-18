package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.systems.Cooldown;

public class Sprite {

    public static Sprite grass = new Sprite(1, 2, SpriteSheet.city);
    public static Sprite wall = new Sprite(3, 1, SpriteSheet.city);
    public static Sprite rock = new Sprite(2, 6, SpriteSheet.city);
    public static Sprite empty = new Sprite(1, 4, SpriteSheet.city);

    public static Sprite playerUp0 = new Sprite(0, 4, SpriteSheet.player);
    public static Sprite playerUp1 = new Sprite(1, 4, SpriteSheet.player);
    public static Sprite playerUp2 = new Sprite(2, 4, SpriteSheet.player);
    public static Sprite playerUp3 = new Sprite(3, 4, SpriteSheet.player);
    public static Sprite playerUp4 = new Sprite(4, 4, SpriteSheet.player);
    public static Sprite playerUp = new Sprite(new Sprite[]{playerUp0, playerUp1, playerUp2, playerUp3, playerUp4});
    public static Sprite playerRight0 = new Sprite(0, 5, SpriteSheet.player);
    public static Sprite playerRight1 = new Sprite(1, 5, SpriteSheet.player);
    public static Sprite playerRight2 = new Sprite(2, 5, SpriteSheet.player);
    public static Sprite playerRight3 = new Sprite(3, 5, SpriteSheet.player);
    public static Sprite playerRight4 = new Sprite(4, 5, SpriteSheet.player);
    public static Sprite playerRight = new Sprite(new Sprite[]{playerRight0, playerRight1, playerRight2, playerRight3, playerRight4});
    public static Sprite playerDown0 = new Sprite(0, 2, SpriteSheet.player);
    public static Sprite playerDown1 = new Sprite(1, 2, SpriteSheet.player);
    public static Sprite playerDown2 = new Sprite(2, 2, SpriteSheet.player);
    public static Sprite playerDown3 = new Sprite(3, 2, SpriteSheet.player);
    public static Sprite playerDown4 = new Sprite(4, 2, SpriteSheet.player);
    public static Sprite playerDown = new Sprite(new Sprite[]{playerDown0, playerDown1, playerDown2, playerDown3, playerDown4});
    public static Sprite playerLeft0 = new Sprite(0, 3, SpriteSheet.player);
    public static Sprite playerLeft1 = new Sprite(1, 3, SpriteSheet.player);
    public static Sprite playerLeft2 = new Sprite(2, 3, SpriteSheet.player);
    public static Sprite playerLeft3 = new Sprite(3, 3, SpriteSheet.player);
    public static Sprite playerLeft4 = new Sprite(4, 3, SpriteSheet.player);
    public static Sprite playerLeft = new Sprite(new Sprite[]{playerLeft0, playerLeft1, playerLeft2, playerLeft3, playerLeft4});
    public static Sprite[] player = new Sprite[]{playerUp, playerRight, playerDown, playerLeft};


    public static Sprite testMobUp0 = new Sprite(0, 0, SpriteSheet.testMob);
    public static Sprite testMobUp1 = new Sprite(1, 0, SpriteSheet.testMob);
    public static Sprite testMobUp2 = new Sprite(2, 0, SpriteSheet.testMob);
    public static Sprite testMobUp = new Sprite(new Sprite[]{testMobUp0, testMobUp1, testMobUp2, testMobUp1});
    public static Sprite testMobRight0 = new Sprite(0, 1, SpriteSheet.testMob);
    public static Sprite testMobRight1 = new Sprite(1, 1, SpriteSheet.testMob);
    public static Sprite testMobRight2 = new Sprite(2, 1, SpriteSheet.testMob);
    public static Sprite testMobRight = new Sprite(new Sprite[]{testMobRight0, testMobRight1, testMobRight2, testMobRight1});
    public static Sprite testMobDown0 = new Sprite(0, 2, SpriteSheet.testMob);
    public static Sprite testMobDown1 = new Sprite(1, 2, SpriteSheet.testMob);
    public static Sprite testMobDown2 = new Sprite(2, 2, SpriteSheet.testMob);
    public static Sprite testMobDown = new Sprite(new Sprite[]{testMobDown0, testMobDown1, testMobDown2, testMobDown1});
    public static Sprite testMobLeft0 = new Sprite(0, 3, SpriteSheet.testMob);
    public static Sprite testMobLeft1 = new Sprite(1, 3, SpriteSheet.testMob);
    public static Sprite testMobLeft2 = new Sprite(2, 3, SpriteSheet.testMob);
    public static Sprite testMobLeft = new Sprite(new Sprite[]{testMobLeft0, testMobLeft1, testMobLeft2, testMobLeft1});
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
    private Cooldown cooldown;

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
        cooldown = new Cooldown(10);
        animatedPixels = new int[sprites.length][];
        for (int i = 0; i < sprites.length; i++) {
            animatedPixels[i] = sprites[i].getPixels();
            if (sprites[i].scale > scale) scale = sprites[i].scale;
        }


    }

    public int[] getPixels() {

        if (animated == true) {
            if (cooldown.canCast()) {
                animationCounter++;
                if (animationCounter == animatedPixels.length) animationCounter = 0;
            }
            cooldown.update();
            return animatedPixels[animationCounter];
        }

        return pixels;

    }

}
