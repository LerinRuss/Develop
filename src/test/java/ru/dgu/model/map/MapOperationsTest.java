package ru.dgu.model.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapOperationsTest
{
    @Test
    public void createMapTest(){
        AbstractMap map = new MapByEnumArray(10);
        assertEquals(map.getSize(), MapOperations.createMap(10).getSize());
    }
}