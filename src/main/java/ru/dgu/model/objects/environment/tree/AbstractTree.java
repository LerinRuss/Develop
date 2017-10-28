package ru.dgu.model.objects.environment.tree;

import ru.dgu.model.objects.environment.EnvironmentObject;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;

public abstract class AbstractTree extends EnvironmentObject
{
    private int growthPoint;
    private IntegerCoordinates coordinates;

    public int getX()
    {
        return coordinates.getX();
    }

    public int getY()
    {
        return coordinates.getY();
    }
    public void grow(){

    }
}
