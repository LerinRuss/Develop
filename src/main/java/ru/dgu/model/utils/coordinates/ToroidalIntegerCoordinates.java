package ru.dgu.model.utils.coordinates;

import ru.dgu.tiles.Map;

public class ToroidalIntegerCoordinates implements IntegerCoordinates{

    private final int x, y;

    public ToroidalIntegerCoordinates(final Map map, final int x, final int y){
        if(x < 0 || x >= map.getWidth())
            throw new OutOfMapBoundsException("Coordinate x = " + x + " out of map width bound = " + map.getWidth());
        if(y < 0 || y >= map.getHeight())
            throw new OutOfMapBoundsException("Coordinate y = " + y + " out of map height bound = " + map.getHeight());

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
