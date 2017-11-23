package ru.dgu.model.map.tiles;

import ru.dgu.utils.coordinates.IntegerCoordinates;

public class ConcreteTile extends Tile
{
    private IntegerCoordinates coordinates;
    public ConcreteTile(TileType type, int x, int y)
    {
        super(type);
        coordinates = new IntegerCoordinates()
        {
            @Override
            public int getX()
            {
                return x;
            }

            @Override
            public int getY()
            {
                return y;
            }
        };
    }
    @Override
    public IntegerCoordinates getCoordinates(){
        return coordinates;
    }
}
