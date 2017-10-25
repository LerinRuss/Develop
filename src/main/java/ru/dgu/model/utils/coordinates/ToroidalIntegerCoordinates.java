package ru.dgu.model.utils.coordinates;

import ru.dgu.model.map.MapByEnumArray;

public class ToroidalIntegerCoordinates implements IntegerCoordinates{

    private final int x, y;

    public ToroidalIntegerCoordinates(final MapByEnumArray mapByEnumArray, final int x, final int y){
        if(x < 0 || x >= mapByEnumArray.getWidth())
            throw new OutOfMapBoundsException("Coordinate x = " + x + " out of mapByEnumArray width bound = " + mapByEnumArray.getWidth());
        if(y < 0 || y >= mapByEnumArray.getHeight())
            throw new OutOfMapBoundsException("Coordinate y = " + y + " out of mapByEnumArray height bound = " + mapByEnumArray.getHeight());

        this.x = x;
        this.y = y;

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
