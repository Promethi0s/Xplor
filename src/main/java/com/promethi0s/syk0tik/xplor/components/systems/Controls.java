package com.promethi0s.syk0tik.xplor.components.systems;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Graphics;
import com.promethi0s.syk0tik.xplor.components.interfaces.ControlsInterface;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// Handles key inputs, controls an array of booleans.
public class Controls implements ControlsInterface {

    public static Controls controls;

    private Graphics graphics;
    private Settings settings;

    public Controls(Graphics graphics, Settings settings) {

        this.graphics = graphics;
        this.settings = settings;

    }

    public boolean viewUp, viewDown, viewLeft, viewRight, moveUp, moveDown, moveLeft, moveRight, use, attack, lockCamera, sprint, pointChanged;
    public Coordinates clickPoint = new Coordinates();

    private boolean[] keys = new boolean[65536];

    public void update() {

        viewUp = keys[KeyEvent.VK_UP];
        viewDown = keys[KeyEvent.VK_DOWN];
        viewLeft = keys[KeyEvent.VK_LEFT];
        viewRight = keys[KeyEvent.VK_RIGHT];
        moveUp = keys[KeyEvent.VK_W];
        moveDown = keys[KeyEvent.VK_S];
        moveLeft = keys[KeyEvent.VK_A];
        moveRight = keys[KeyEvent.VK_D];
        use = keys[KeyEvent.VK_R];
        attack = keys[KeyEvent.VK_SPACE];
        lockCamera = keys[KeyEvent.VK_T];
        sprint = keys[KeyEvent.VK_SHIFT];

        System.out.println();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        clickPoint.x = e.getX() / settings.screenScale + graphics.viewOffset.x;
        clickPoint.y = e.getY() / settings.screenScale + graphics.viewOffset.y;
        pointChanged = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}