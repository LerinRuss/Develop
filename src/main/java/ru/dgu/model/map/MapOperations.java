package ru.dgu.model.map;


import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.units.Unit;
import ru.dgu.model.utils.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapOperations
{
    private MapOperations()
    {
    }
    //Maybe use pattern Strategy for different algorithm.

    /**
     * Return shortest way from unit to position (x,y) as list of coordinates.
     * Use a Moore neighborhood
     *
     * @param unit - unit, that want to move
     * @param x    - x coordinate dis
     * @param y
     * @return
     */
    public static List<Pair<Integer>> shortestWay(Unit unit, int x, int y)
    {
        List<Pair<Integer>> shortestWay = new LinkedList<>();
        //Map<Pair<Integer>, Integer> map = castMap();
        return shortestWay;
    }

    //Cast (слепок) from map
    private static Map<Pair<Integer>, Integer> castMap(AbstractMap map)
    {
        Map<Pair<Integer>, Integer> castMap = new HashMap<>();
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if (map.getTile(i, j).getType() != TileType.EMPTY) {
                    castMap.put(new Pair<>(i, j), 0);
                }
            }
        }
        return castMap;
    }
}
