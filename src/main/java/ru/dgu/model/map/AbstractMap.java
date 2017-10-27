package ru.dgu.model.map;

import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.map.tiles.TileType;

public abstract class AbstractMap
{
    public abstract void setTile(Tile tile, int x, int y);

    public abstract Tile getTile(int x, int y);

    public abstract void setTileType(TileType newType, int x, int y);

    public abstract TileType getTileType(int x, int y);

    public abstract int getSize();

    public int distance(int x1, int y1, int x2, int y2)
    {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
