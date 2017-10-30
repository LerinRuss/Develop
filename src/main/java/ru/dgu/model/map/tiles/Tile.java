package ru.dgu.model.map.tiles;

public abstract class Tile
{
    private TileType type;


    public Tile(TileType type)
    {
        this.type = type;
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
