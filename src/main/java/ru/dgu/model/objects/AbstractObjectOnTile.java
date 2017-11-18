package ru.dgu.model.objects;

import ru.dgu.model.types.ObjectType;

import java.awt.image.BufferedImage;

public abstract class AbstractObjectOnTile
{
    private ObjectType type;
    private BufferedImage texture;

    public BufferedImage getTexture()
    {
        return texture;
    }

    public void setTexture(BufferedImage texture)
    {
        this.texture = texture;
    }

    public void setType(ObjectType type)
    {
        this.type = type;
    }

    public ObjectType getType()
    {
        return type;
    }

}
