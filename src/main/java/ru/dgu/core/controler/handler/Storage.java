package ru.dgu.core.controler.handler;

import ru.dgu.controler.MultiAdapter;

public interface Storage {
    MultiAdapter getWalkingControl();
    MultiAdapter getAdditionControl();
}
