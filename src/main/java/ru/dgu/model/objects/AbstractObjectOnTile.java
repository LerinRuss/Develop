package ru.dgu.model.objects;

import ru.dgu.model.types.ObjectType;

public abstract class AbstractObjectOnTile
{
    private ObjectType type;

    public void setType(ObjectType type)
    {
        this.type = type;
    }

    public ObjectType getType()
    {
        return type;
    }

}
