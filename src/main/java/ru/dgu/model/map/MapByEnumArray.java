package ru.dgu.model.map;


import ru.dgu.model.constants.Constants;
import ru.dgu.model.map.tiles.ConcreteTile;
import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.map.tiles.TileType;

public class MapByEnumArray extends AbstractMap
{
    private final Tile[][] map;

    public MapByEnumArray(final int size)
    {
        if (size <= 0)
            throw new IllegalArgumentException("Size less or equal 0 ");

        map = new Tile[size][size];
        fillMap(Constants.DEFAULT_TILE_TYPE);
    }

    private void fillMap(final TileType type)
    {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                setTile(new ConcreteTile(type), x, y);
            }
        }
    }

    @Override
    public void setTile(Tile tile, int x, int y)
    {
        map[x][y] = tile;
    }

    public Tile getTile(final int x, final int y)
    {
        return map[x][y];
    }

    @Override
    public void setTileType(TileType newType, int x, int y)
    {
        map[x][y].setType(newType);
    }

    @Override
    public TileType getTileType(int x, int y)
    {
        return null;
    }

    @Override
    public int getSize()
    {
        return map.length;
    }
}
