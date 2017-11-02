package ru.dgu.core.controler;

import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeySetting {
    private static final Map<Integer, TileType> tileTypeKeys = new HashMap<>();
    static {
        tileTypeKeys.put(KeyEvent.VK_1,TileType.GRASS);
        tileTypeKeys.put(KeyEvent.VK_2,TileType.WATER);
        tileTypeKeys.put(KeyEvent.VK_3,TileType.SAND);
        tileTypeKeys.put(KeyEvent.VK_4,TileType.EMPTY);
    }
    private static final Map<Integer, ObjectType> objectTypeKeys = new HashMap<>();
    static {
        objectTypeKeys.put(KeyEvent.VK_1, ObjectType.IMPERIAL_GUARD);
        objectTypeKeys.put(KeyEvent.VK_2,ObjectType.IMPERIAL_GUARD);
    }
    private KeySetting(){}
    public static Map<Integer, TileType> getTileTypeKeysSetting(){
        return tileTypeKeys;
    }
    public static Map<Integer, ObjectType> getObjectTypeKeys(){ return  objectTypeKeys;}
}
