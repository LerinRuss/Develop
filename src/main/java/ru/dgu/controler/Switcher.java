package ru.dgu.controler;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public interface Switcher {
    void switchState(State state);
    MouseAdapter getMouseControl();
    KeyAdapter getKeyControl();
}
