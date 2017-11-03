package ru.dgu.core.controller;

import ru.dgu.utils.coordinates.IntegerCoordinates;

public interface Movable {
    void move(IntegerCoordinates coordinates);
    void move(int x, int y);
}
