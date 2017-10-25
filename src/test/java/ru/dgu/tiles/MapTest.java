package ru.dgu.tiles;

import org.junit.Before;
import org.junit.Test;
import ru.dgu.model.map.Map;

import static org.junit.Assert.*;

public class MapTest {

    private Map map;
    private final int width = 25;
    private final int height = 10;

    @Before
    public void init() throws Exception {
        map = new Map(width,height);
    }

    @Test
    public void getWidthTest() throws Exception {
        assertEquals(width,map.getWidth());
    }
    @Test
    public void getHeightTest() throws Exception {
        assertEquals(height,map.getHeight());
    }
}