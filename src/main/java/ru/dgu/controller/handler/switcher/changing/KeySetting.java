package ru.dgu.controller.handler.switcher.changing;

import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeySetting {
    private static final Map<Integer, TileType> tileTypeKeys = new HashMap<>();
    static {
        tileTypeKeys.put(KeyEvent.VK_1,TileType.GRASS);
        tileTypeKeys.put(KeyEvent.VK_2,TileType.DIRTY);
        tileTypeKeys.put(KeyEvent.VK_3,TileType.WATER);
        tileTypeKeys.put(KeyEvent.VK_4,TileType.SHALLOW);
        tileTypeKeys.put(KeyEvent.VK_5,TileType.SAND);
        tileTypeKeys.put(KeyEvent.VK_6,TileType.BEACH_SAND);
        tileTypeKeys.put(KeyEvent.VK_7,TileType.EMPTY);
    }
    private static final Map<Integer, ObjectType> objectTypeKeys = new HashMap<>();
    static {
        objectTypeKeys.put(KeyEvent.VK_1, ObjectType.IMPERIAL_GUARD);
        objectTypeKeys.put(KeyEvent.VK_2, ObjectType.TREE);
    }
    private KeySetting(){}
    static Map<Integer, TileType> getTileTypeKeysSetting(){
        return tileTypeKeys;
    }
    static Map<Integer, ObjectType> getObjectTypeKeys(){ return  objectTypeKeys;}
}
