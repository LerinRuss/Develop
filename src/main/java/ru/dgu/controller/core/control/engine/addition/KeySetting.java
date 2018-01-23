package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Key setting is class that describes keys and for what they are used
 */
class KeySetting {
    private static final Map<Integer, TileType> tileKeys = new HashMap<>();
    static {
        tileKeys.put(KeyEvent.VK_1,TileType.GRASS);
        tileKeys.put(KeyEvent.VK_2,TileType.DIRTY);
        tileKeys.put(KeyEvent.VK_3,TileType.WATER);
        tileKeys.put(KeyEvent.VK_4,TileType.SHALLOW);
        tileKeys.put(KeyEvent.VK_5,TileType.SAND);
        tileKeys.put(KeyEvent.VK_6,TileType.BEACH_SAND);
        tileKeys.put(KeyEvent.VK_7,TileType.EMPTY);
    }
    private static final Map<Integer, ObjectType> objectKeys = new HashMap<>();
    static {
        objectKeys.put(KeyEvent.VK_1, ObjectType.IMPERIAL_GUARD);
        objectKeys.put(KeyEvent.VK_2, ObjectType.TREE);
    }

    private KeySetting(){}

    static Map<Integer, TileType> getTileKeys(){
        return tileKeys;
    }
    static Map<Integer, ObjectType> getObjectKeys(){ return objectKeys;}
}
