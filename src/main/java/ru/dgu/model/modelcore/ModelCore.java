package ru.dgu.model.modelcore;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import ru.dgu.model.constants.Constants;
import ru.dgu.model.exceptions.MapException;
import ru.dgu.model.exceptions.ModelException;
import ru.dgu.model.map.AbstractMap;
import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.objects.AbstractObjectOnTile;
import ru.dgu.model.types.ObjectType;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;

public class ModelCore
{
    static {
        objectTileBidiMap = new DualHashBidiMap();

    }

    private static BidiMap<Tile, AbstractObjectOnTile> objectTileBidiMap;
    private static AbstractMap currentMap;

    public static AbstractMap getCurrentMap()
    {
        return currentMap;
    }

    public static void setCurrentMap(AbstractMap map){
        currentMap = map;
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
        checkCoordinate(x, y);
        return objectTileBidiMap.get(currentMap.getTile(x, y));
    }

    public static void addObjectOnTile(ObjectType type, int x, int y) throws ModelException
    {
        checkCoordinate(x, y);
        objectTileBidiMap.put(currentMap.getTile(x, y), ObjectType.createObject(type));
    }

    public static void deleteObjectIfExist(AbstractObjectOnTile object)
    {
        if (objectTileBidiMap.containsValue(object)) {
            deleteObject(object);
        }
    }

    public static void deleteObject(AbstractObjectOnTile object)
    {
        objectTileBidiMap.removeValue(object);
    }

    public static void deleteObjectIfExist(int x, int y) throws MapException
    {
        checkCoordinate(x, y);
        Tile tile = currentMap.getTile(x, y);
        if (objectTileBidiMap.containsKey(tile)) {
            deleteObject(tile);
        }
    }

    public static void deleteObject(int x, int y)
    {
        deleteObject(currentMap.getTile(x, y));
    }

    public static void deleteObject(Tile tile)
    {
        objectTileBidiMap.remove(tile);
    }
}
