package ru.dgu.core.controler.mouse;

import ru.dgu.utils.coordinates.IntegerCoordinates;

public interface CursorMovable {
    void translate(final IntegerCoordinates coordinates);
    void translate(int x, int y);
}
