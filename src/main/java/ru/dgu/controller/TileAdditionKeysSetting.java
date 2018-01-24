package ru.dgu.controller;

import ru.dgu.model.map.tiles.TileType;

import java.util.Map;

/**
 * This interface represents setting for tile addition control.
 * Supposedly, class implementing this interface is a cover of
 * {@link Map} where key is a Integer key code of keyboard and value is a appropriate tile type.
 *
 * But some methods such as isEmpty are here for ease of use
 */
public interface TileAdditionKeysSetting {
    boolean hasSwitched(int keyCode);
    boolean isEmpty();
    Map<Integer, TileType> getTileKeysSetting();
    TileType get(int keyCode);
}
