package ru.dgu.controler;

import java.awt.event.*;

public enum State {
    WALKING, ADDITION;

    private MouseAdapter mouseAdapter;
    private KeyListener keyListener;

    State(){
        setKeyListener(EmptyKeyControl.KEY_CONTROL);
        setMouseAdapter(EmptyMouseControl.MOUSE_CONTROL);
    }

    public void setKeyListener(final KeyListener keyListener){
        this.keyListener = keyListener;
    }
    public void setMouseAdapter(final MouseAdapter mouseAdapter){
        this.mouseAdapter = mouseAdapter;
    }

    KeyListener getKeyListener(){
        return keyListener;
    }
    MouseAdapter getMouseAdapter(){
        return mouseAdapter;
    }
}
