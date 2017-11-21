package ru.dgu.model.objects;

import java.awt.image.BufferedImage;

public abstract class AbstractObjectOnTile
{
    public abstract BufferedImage getTexture();

    public abstract void setTexture(BufferedImage texture);

}
