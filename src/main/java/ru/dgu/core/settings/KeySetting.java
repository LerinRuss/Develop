package ru.dgu.core.settings;

import ru.dgu.model.map.tiles.TileType;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeySetting {
    private static final HashMap<Integer, TileType> keys = new HashMap<>();
    static {
        keys.put(KeyEvent.VK_1,TileType.GRASS);
        keys.put(KeyEvent.VK_2,TileType.WATER);
        keys.put(KeyEvent.VK_3,TileType.SAND);
        keys.put(KeyEvent.VK_4,TileType.EMPTY);

    }
    private KeySetting(){}

    public static HashMap<Integer, TileType> getKeysSetting(){
        return keys;
    }
}
