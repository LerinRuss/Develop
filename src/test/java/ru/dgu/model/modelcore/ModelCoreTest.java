package ru.dgu.model.modelcore;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.objects.units.imperium.ImperialGuard;
import ru.dgu.model.types.ObjectType;

import static junit.framework.TestCase.*;

public class ModelCoreTest
{
    @BeforeClass
    public static void beforeClass()
    {
        final int SIZE = 20;
        ModelCore.createMap(SIZE);
    }

    @Test
    public void mapSizeTest()
    {
        assertTrue(ModelCore.getCurrentMapSize() == 20);
    }

    @Test
    public void changeTileTypeTest()
    {
        ModelCore.setTileType(TileType.WATER, 1, 1);
        assertEquals(TileType.WATER, ModelCore.getTileType(1, 1));
    }

    @Test
    public void mapBoundFalseXTest()
    {
        assertFalse(!ModelCore.outOfMapBound(-1, 1));
    }

    @Test
    public void mapBoundFalseYTest()
    {
        assertFalse(!ModelCore.outOfMapBound(1, -1));
    }

    @Test
    public void mapBoundTrueTest()
    {
        assertTrue(!ModelCore.outOfMapBound(15, 1));
    }

    @Test
    public void addObjectTest()
    {
        ModelCore.addObjectOnTile(ObjectType.IMPERIAL_GUARD, 2, 5);
        assertEquals(new ImperialGuard(), ModelCore.getObjectOnTile(2,5));
    }
    @Test
    public void deleteObjectTest(){
        ModelCore.deleteObject(2,5);
        assertNull(ModelCore.getObjectOnTile(2,5));
    }

}