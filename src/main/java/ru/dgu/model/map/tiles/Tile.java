package ru.dgu.model.map.tiles;

public abstract class Tile
{
    private TileType type;
    private TileMark mark;


    public Tile(TileType type)
    {
        this.type = type;
    }

    public TileMark getMark()
    {
        return mark;
    }

    public void setMark(TileMark mark)
    {
        this.mark = mark;
    }

    public TileType getType()
    {
        return type;
    }

    public void setType(TileType type)
    {
        this.type = type;
    }
}
