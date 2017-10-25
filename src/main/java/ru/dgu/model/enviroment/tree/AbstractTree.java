package ru.dgu.model.enviroment.tree;

import ru.dgu.model.AbstractObjectOnTile;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;

public abstract class AbstractTree extends AbstractObjectOnTile
{
    private IntegerCoordinates coordinates;

    public int getX()
    {
        return coordinates.getX();
    }

    public int getY()
    {
        return coordinates.getY();
    }
}
