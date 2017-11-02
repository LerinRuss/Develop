package ru.dgu.controler;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyControl implements KeyListener{
    private static boolean created = false;
    private KeyListener keyListener;

    KeyControl(final KeyListener keyListener){
        if(created)
            throw new CallMethodException("KeyControl is already exist");
        setKeyListener(keyListener);
        created = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyListener.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyListener.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyListener.keyReleased(e);
    }

    void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }
}
