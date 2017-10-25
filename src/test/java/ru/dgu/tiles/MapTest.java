package ru.dgu.tiles;

import org.junit.Before;
import org.junit.Test;
import ru.dgu.model.map.MapByEnumArray;

import static org.junit.Assert.*;

public class MapTest {

    private MapByEnumArray mapByEnumArray;
    private final int width = 25;
    private final int height = 10;

    @Before
    public void init() throws Exception {
        mapByEnumArray = new MapByEnumArray(width,height);
    }

    @Test
    public void getWidthTest() throws Exception {
        assertEquals(width, mapByEnumArray.getWidth());
    }
    @Test
    public void getHeightTest() throws Exception {
        assertEquals(height, mapByEnumArray.getHeight());
    }
}