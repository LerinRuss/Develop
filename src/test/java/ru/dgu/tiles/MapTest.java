package ru.dgu.tiles;

import org.junit.Before;
import org.junit.Test;
import ru.dgu.model.map.MapByEnumArray;

import static org.junit.Assert.*;

public class MapTest {

    private MapByEnumArray mapByEnumArray;
    private final int size = 25;

    @Before
    public void init() throws Exception {
        mapByEnumArray = new MapByEnumArray(size);
    }

    @Test
    public void getSizeTest() throws Exception {
        assertEquals(size, mapByEnumArray.getSize());
    }
}