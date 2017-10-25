package ru.dgu.model.map;



import ru.dgu.model.units.Unit;
import ru.dgu.model.utils.Pair;

import java.util.LinkedList;
import java.util.List;

public class MapOperations
{
    private MapOperations(){}
    //Return shortest way from unit to position (x,y) as list of coordinates.

    /**
     *
     * @param unit - unit, that want to move
     * @param x - x coordinate dis
     * @param y
     * @return
     */
    public static List<Pair<Integer>> shortestWay(Unit unit, int x, int y){
        List<Pair<Integer>> shortestWay = new LinkedList<>();
        return shortestWay;
    }
}
