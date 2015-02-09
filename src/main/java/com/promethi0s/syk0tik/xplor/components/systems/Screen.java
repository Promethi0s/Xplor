package com.promethi0s.syk0tik.xplor.components.systems;

import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Canvas {

    private JFrame frame;
    private BufferedImage image;
    private int[] pixels;

    public Screen(Settings settings, Controls controls) {

        image = new BufferedImage(settings.screenWidth, settings.screenHeight, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

        Dimension size = new Dimension(settings.screenWidth * settings.screenScale, settings.screenHeight * settings.screenScale);
        setPreferredSize(size);

        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Xplor");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        requestFocus();

        addKeyListener(controls);

    }

    public void render(int[] bufferPixels) {

        // Load triple-buffering strategy, create if necessary
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        // Load screen into pixels array
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = bufferPixels[i];
        }

        // Display pixels array
        Graphics dg = bs.getDrawGraphics();
        dg.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        dg.dispose();
        bs.show();

    }

}
