package ru.dgu.model.modelcore;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import ru.dgu.model.constants.Constants;
import ru.dgu.model.exceptions.MapException;
import ru.dgu.model.exceptions.ObjectOnTileException;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.objects.AbstractObjectOnTile;
import ru.dgu.model.map.AbstractMap;
import ru.dgu.model.map.MapByEnumArray;
import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.types.ObjectType;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;

public class ModelCore
{
    static {
        unitTileBidiMap = new DualHashBidiMap();
        currentMap = new MapByEnumArray(10, 10);
    }

    private static BidiMap<Tile, AbstractObjectOnTile> unitTileBidiMap;
    private static AbstractMap currentMap;

    public static AbstractMap getCurrentMap()
    {
        return currentMap;
    }

    public static boolean outOfMapBound(IntegerCoordinates coordinates){
        return outOfMapBound(coordinates.getX(), coordinates.getY());
    }
    public static boolean outOfMapBound(int x, int y){
        return x < 0 || x > currentMap.getSize() || y < 0 || y > currentMap.getSize();
    }
    private static void checkCoordinate(int x, int y) throws MapException
    {
        if (x < 0 || x > currentMap.getSize() || y < 0 || y > currentMap.getSize()) {
            throw new MapException(Constants.ILLEGAL_COORDINATE);
        }

    }

    public static void setTileType(TileType tileType, int x, int y) throws MapException
    {
        checkCoordinate(x, y);
        currentMap.setTileType(tileType, x, y);
    }

    public static AbstractObjectOnTile objectOnTile(int x, int y) throws MapException
    {
        checkCoordinate(x,y);
        return unitTileBidiMap.get(currentMap.getTile(x, y));
    }

    public static void addObjectOnTile(ObjectType type, int x, int y) throws ObjectOnTileException
    {
        unitTileBidiMap.put(currentMap.getTile(x, y), ObjectType.createObject(type));
    }

}
