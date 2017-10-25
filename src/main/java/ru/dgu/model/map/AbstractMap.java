package ru.dgu.model.map;


import ru.dgu.model.map.tiles.Tile;

public abstract class AbstractMap
{
    public abstract void setTile(Tile tile, int x, int y);
    public abstract Tile getTile(int x, int y);
    public abstract int getSize();
    public abstract int distance(int x1, int y1, int x2, int y2);
}
