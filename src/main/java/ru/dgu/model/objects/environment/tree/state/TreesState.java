package ru.dgu.model.objects.environment.tree.state;


import ru.dgu.model.objects.environment.tree.Tree;

import java.awt.image.BufferedImage;

public abstract class TreesState
{
    private BufferedImage texture;

    public BufferedImage getTexture()
    {
        return texture;
    }

    public void setTexture(BufferedImage texture)
    {
        this.texture = texture;
    }

    public static final int SHRUB_POINT = 100;
    public static final int TREE_POINT = 300;
    public static final int DEAD_TREE_POINT = 700;
    public abstract TreeStateEnum getState();
    public abstract void grow(Tree tree);
}
