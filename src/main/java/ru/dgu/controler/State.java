package ru.dgu.controler;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public enum State {
    WALKING(EmptyKeyControl.KEY_CONTROL,
            EmptyMouseControl.MOUSE_CONTROL),

    ADDITION(EmptyKeyControl.KEY_CONTROL,
            EmptyMouseControl.MOUSE_CONTROL);

    private MouseAdapter mouseAdapter;
    private KeyAdapter keyAdapter;

    State(final KeyAdapter keyAdapter,
          final MouseAdapter mouseAdapter){
        setKeyAdapter(keyAdapter);
        setMouseAdapter(mouseAdapter);
    }

    public void setKeyAdapter(final KeyAdapter keyAdapter){
        this.keyAdapter = keyAdapter;
    }

    public void setMouseAdapter(final MouseAdapter mouseAdapter){
        this.mouseAdapter = mouseAdapter;
    }

    KeyAdapter getKeyAdapter(){
        return keyAdapter;
    }
    MouseAdapter getMouseAdapter(){
        return mouseAdapter;
    }
}
