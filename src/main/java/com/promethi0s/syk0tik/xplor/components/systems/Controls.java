package com.promethi0s.syk0tik.xplor.components.systems;

import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.interfaces.ControlsInterface;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// Handles key inputs, controls an array of booleans.
public class Controls implements ControlsInterface {

    public static Controls controls;

    public boolean viewUp, viewDown, viewLeft, viewRight, moveUp, moveDown, moveLeft, moveRight, use, attack, lockCamera;
    public Coordinates targetLocation = new Coordinates();
    public Coordinates clickPoint = new Coordinates();

    private boolean pointChanged;

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

        clickPoint.x = e.getX();
        clickPoint.y = e.getY();
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

    public void setTargetLocation(Coordinates viewOffset, Settings settings) {

        if (pointChanged) {
            targetLocation.x = clickPoint.x + viewOffset.x;
            targetLocation.y = clickPoint.y + viewOffset.y;
            pointChanged = false;
        }

    }

}