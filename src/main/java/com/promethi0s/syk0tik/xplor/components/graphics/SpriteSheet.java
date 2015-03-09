package com.promethi0s.syk0tik.xplor.components.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    public static SpriteSheet city = new SpriteSheet("/textures/city.png", 736, 928, 32);
    public static SpriteSheet player = new SpriteSheet("/textures/player.png", 256, 256, 16);
    public static SpriteSheet mobs = new SpriteSheet("/textures/mobs.png", 256, 256, 16);
    public static SpriteSheet projectiles = new SpriteSheet("/textures/projectiles.png", 256, 256, 16);

    public int width, scale;
    public int[] pixels;
    private String path;

    public SpriteSheet(String path, int width, int height, int scale) {

        this.path = path;
        this.width = width;
        this.scale = scale;
        pixels = new int[width * height];

    }

    public void load() {

        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
