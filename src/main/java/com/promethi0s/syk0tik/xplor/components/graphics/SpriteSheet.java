package com.promethi0s.syk0tik.xplor.components.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    private String path;
    public int size;
    public int scale;
    public int[] pixels;

    public static SpriteSheet city = new SpriteSheet("/textures/city.png", 256, 16);
    public static SpriteSheet player = new SpriteSheet("/textures/player.png", 256, 16);

    public SpriteSheet(String path, int size, int scale) {

        this.path = path;
        this.size = size;
        this.scale = scale;
        pixels = new int[size * size];

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
