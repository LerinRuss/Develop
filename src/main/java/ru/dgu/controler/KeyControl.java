package ru.dgu.controler;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyControl extends KeyAdapter{
    private static boolean created = false;
    private KeyAdapter keyAdapter;

    KeyControl(final KeyAdapter keyAdapter){
        if(created)
            throw new CallMethodException("KeyControl is already exist");
        setKeyAdapter(keyAdapter);
        created = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyAdapter.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyAdapter.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyAdapter.keyReleased(e);
    }

    void setKeyAdapter(KeyAdapter keyAdapter) {
        this.keyAdapter = keyAdapter;
    }
}
