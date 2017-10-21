package ru.dgu.tree;

import ru.dgu.AbstractObjectOnTile;
import ru.dgu.tiles.Tile;

import java.util.Set;

public abstract class AbstractTree extends AbstractObjectOnTile
{
    private Tile tile;

    public Tile getTile()
    {
        return tile;
    }

    public void setTile(Tile tile)
    {
        this.tile = tile;
    }

    public abstract Set<Tile> getPossibleTypes();

}
