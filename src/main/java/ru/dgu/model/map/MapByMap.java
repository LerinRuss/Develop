package ru.dgu.model.map;


import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.utils.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erlan on 23.11.2016.
 */
public class MapByMap extends AbstractMap
{
    private Map<Pair<Integer>, Tile> map;

    public MapByMap()
    {
        map = new HashMap<>();
    }

    public void setTile(Tile tile, int x, int y)
    {
        map.put(new Pair<Integer>(x, y), tile);
    }

    public void setTile(Pair<Integer> coordinate, Tile tile)
    {
        map.put(coordinate, tile);
    }

    public Tile getTile(Pair<Integer> coordinate)
    {
        return map.get(coordinate);
    }

    public Tile getTile(int x, int y)
    {
        return map.get(new Pair<Integer>(x, y));
    }

    public int getSize()
    {
        return (int) Math.round(Math.sqrt(map.size()));
    }

    public int distance(int x1, int y1, int x2, int y2)
    {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

}
