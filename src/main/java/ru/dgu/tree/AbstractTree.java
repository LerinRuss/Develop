package ru.omsu.imit.erlan_momonov.other.vitalys.tree;

import ru.omsu.imit.erlan_momonov.other.vitalys.AbstractObjectOnTile;
import ru.omsu.imit.erlan_momonov.other.vitalys.tiles.Tile;
import ru.omsu.imit.erlan_momonov.other.vitalys.tiles.TileType;

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

    public abstract Set<TileType> getPossibleTypes();

}
