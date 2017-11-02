package ru.dgu.controler;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

public class Dispatcher implements Switcher {
    private static boolean created = false;

    private final MouseControl mouseControl;
    private final KeyControl keyControl;

    private Dispatcher(final MouseAdapter mouseAdapter,
                       final KeyListener keyListener) {
        mouseControl = new MouseControl(mouseAdapter);
        keyControl = new KeyControl(keyListener);
    }

    public static Switcher init() {
        if (created)
            throw new CallMethodException("Switcher is already initialized");
        final State state = State.WALKING;
        final Dispatcher dispatcher = new Dispatcher(state.getMouseAdapter(), state.getKeyListener());
        created = true;
        return dispatcher;
    }

    @Override
    public void switchState(State state) {
        mouseControl.setMouseAdapter(state.getMouseAdapter());
        keyControl.setKeyListener(state.getKeyListener());
    }

    public MouseControl getMouseControl() {
        return mouseControl;
    }

    public KeyControl getKeyControl() {
        return keyControl;
    }
}
