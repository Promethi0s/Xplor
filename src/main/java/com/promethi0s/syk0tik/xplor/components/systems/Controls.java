package com.promethi0s.syk0tik.xplor.components.systems;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

    private boolean[] keys = new boolean[65536];
    public boolean viewUp, viewDown, viewLeft, viewRight, moveUp, moveDown, moveLeft, moveRight, use, attack, lockCamera;

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

}