package ru.dgu.model.modelcore;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import ru.dgu.model.constants.Constants;
import ru.dgu.model.exceptions.MapException;
import ru.dgu.model.exceptions.ModelException;
import ru.dgu.model.map.AbstractMap;
import ru.dgu.model.map.MapOperations;
import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.objects.AbstractObjectOnTile;
import ru.dgu.model.types.ObjectType;
import ru.dgu.model.utils.action.Action;
import ru.dgu.utils.coordinates.IntegerCoordinates;

import java.util.ArrayList;
import java.util.List;

public class ModelCore
{
    static {
        objectTileBidiMap = new DualHashBidiMap();
        actionList = new ArrayList<>();
    }

    private static BidiMap<Tile, AbstractObjectOnTile> objectTileBidiMap;
    private static AbstractMap currentMap;
    private static List<Action> actionList;

    /**
     * Return side length of square map
     * @return current map size
     */
    public static int getCurrentMapSize(){
        return currentMap.getSize();
    }

    /**
     * @param x - X coordinate of tile
     * @param y - Y coordinate of tile
     * @return type of tile by coordinate x, y.
     */
    public static TileType getTileType(int x, int y){
        return currentMap.getTileType(x,y);
    }

    /**
     * Now create default map. Later add possibility to tune creating map.
     * @param size - size of creating map.
     */
    public static void createMap(int size)
    {
        currentMap = MapOperations.createMap(size);
    }

    /**
     * @param coordinates
     * @return <tt>true</tt> if and only if coordinates is not belong current map
     */
    public static boolean outOfMapBound(IntegerCoordinates coordinates)
    {
        return outOfMapBound(coordinates.getX(), coordinates.getY());
    }

    /**
     * @param x - x coordinate
     * @param y - y coordinate
     * @return true if and only if coordinate is bot nelong current map
     */
    public static boolean outOfMapBound(int x, int y)
    {
        return x < 0 || x > currentMap.getSize() || y < 0 || y > currentMap.getSize();
    }

    /**
     * @param x - x coordinate
     * @param y - y coordinate
     * @throws MapException if and only if coordinate is not belong current map
     */
    private static void checkCoordinate(int x, int y) throws MapException
    {
        if (x < 0 || x > currentMap.getSize() || y < 0 || y > currentMap.getSize()) {
            throw new MapException(Constants.ILLEGAL_COORDINATE);
        }

    }

    /**
     * Setter for TileType by coordinates tile on current map
     * @param tileType - new TileType for setting
     * @param x - x coordinate of tile
     * @param y - y coordinate of tile
     * @throws MapException if and only if coordinate is not belong current map
     */
    public static void setTileType(TileType tileType, int x, int y) throws MapException
    {
        checkCoordinate(x, y);
        currentMap.setTileType(tileType, x, y);
    }

    /**
     * @param x - x coordinate of tile
     * @param y - y coordinate of tile
     * @return object on given coordinate
     * @throws MapException if and only if coordinate is bot belong current map
     */
    public static AbstractObjectOnTile getObjectOnTile(int x, int y) throws MapException
    {
        checkCoordinate(x, y);
        return objectTileBidiMap.get(currentMap.getTile(x, y));
    }

    /**
     * Create a new object and add it to the given coordinate
     * @param type - type for new object
     * @param x - x coordinate of tile
     * @param y - y coordinate of tile
     * @throws ModelException if and only if coordinate is bot belong current map
     */
    public static void addObjectOnTile(ObjectType type, int x, int y) throws ModelException
    {
        checkCoordinate(x, y);
        objectTileBidiMap.put(currentMap.getTile(x, y), ObjectType.createObject(type));
    }

    /**
     * Delete given object from map.
     * @param object - onject for deleting
     */
    public static void deleteObject(AbstractObjectOnTile object)
    {
        objectTileBidiMap.removeValue(object);
    }

    /**
     * Delete object on given coordinate
     * @param x
     * @param y
     */
    public static void deleteObject(int x, int y) throws MapException
    {
        checkCoordinate(x,y);
        deleteObject(currentMap.getTile(x, y));
    }

    /**
     * Delete object on given tile
     * @param tile - tile
     */
    public static void deleteObject(Tile tile)
    {
        objectTileBidiMap.remove(tile);
    }

    /**
     * Call this method to make the model one step
     */
    public static void doStep(){
        for(Action item: actionList){
            item.action();
        }
    }
}
