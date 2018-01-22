package ru.dgu.controller;

import java.awt.event.*;

/**
 *  This class is the unification of mouse and key's listeners
 */
public abstract class MultiAdapter extends MouseAdapter implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
