package ru.dgu.controler;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class Dispatcher implements Switcher {
    private static boolean created = false;
    private final MouseControl mouseControl;
    private final KeyControl keyControl;

    private Dispatcher(final MouseAdapter mouseAdapter,
                       final KeyAdapter keyAdapter) {
        mouseControl = new MouseControl(mouseAdapter);
        keyControl = new KeyControl(keyAdapter);
    }

    public static Switcher init(){
        if(created)
            throw new CallMethodException("Switcher is already initialized");
        final State state = State.WALKING;
        final Dispatcher dispatcher = new Dispatcher(state.getMouseAdapter(), state.getKeyAdapter());
        created = true;
        return dispatcher;
    }

    @Override
    public void switchState(State state) {
        mouseControl.setMouseAdapter(state.getMouseAdapter());
        keyControl.setKeyAdapter(state.getKeyAdapter());
    }

    @Override
    public MouseAdapter getMouseControl() {
        return mouseControl;
    }

    @Override
    public KeyAdapter getKeyControl() {
        return keyControl;
    }
}
