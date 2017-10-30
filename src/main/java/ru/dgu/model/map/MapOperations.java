package ru.dgu.model.map;


import ru.dgu.model.constants.Constants;

public class MapOperations
{
    private MapOperations()
    {
    }

    public static AbstractMap createMap(int size){
        MapByEnumArray map = new MapByEnumArray(size);
        map.fill(Constants.DEFAULT_TILE_TYPE);
        return map;
    }
}
