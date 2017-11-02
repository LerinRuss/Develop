package ru.dgu.controler;

public interface Switcher {
    void switchState(State state);
    MouseControl getMouseControl();
    KeyControl getKeyControl();

}
