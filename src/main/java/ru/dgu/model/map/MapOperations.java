package ru.dgu.model.map;


public class MapOperations
{
    private MapOperations()
    {
    }

    public static AbstractMap createMap(int size){
        return new MapByEnumArray(size);
    }
}
