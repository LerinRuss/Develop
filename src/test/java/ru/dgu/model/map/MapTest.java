package ru.dgu.model.map;

import org.junit.Test;
import ru.dgu.model.exceptions.MapException;
import ru.dgu.model.map.tiles.TileType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MapTest
{
    public static final int SIZE = 20;

    @Test(expected = MapException.class)
    public void mapByEnumNegativeSize() throws Exception
    {
        AbstractMap map = new MapByEnumArray(-2);
        fail();
    }

    @Test
    public void mapByEnumFillTest() throws Exception
    {
        MapByEnumArray map = new MapByEnumArray(SIZE);
        map.fill(TileType.SAND);
        assertEquals(TileType.SAND, map.getTileType(3, 7));
    }

    @Test
    public void mapByEnumTest() throws Exception
    {
        MapByEnumArray map = new MapByEnumArray(SIZE);
        map.fill(TileType.EMPTY);
        map.setTileType(TileType.WATER, 2, 3);
        assertEquals(TileType.WATER, map.getTileType(2, 3));
    }

    @Test
    public void abstractMapSizeTest() throws Exception
    {
        AbstractMap map = new MapByEnumArray(SIZE);
        assertEquals(SIZE, map.getSize());
    }

    @Test
    public void abstractMapSetTileTypeTest() throws Exception
    {
        AbstractMap map = new MapByEnumArray(SIZE);
        map.setTileType(TileType.WATER, 2, 3);
        assertEquals(map.getTileType(2, 3), map.getTileType(2, 3));
    }

    @Test
    public void abstractMapDistanceTest() throws Exception
    {
        AbstractMap map = new MapByEnumArray(SIZE);
        assertEquals(1, map.distance(1, 1, 2, 2));
    }
}
