package ru.dgu.controller;

import ru.dgu.model.map.tiles.TileType;

import java.util.Map;

public interface TileAdditionKeysSetting {
    boolean hasSwitched(int keyCode);
    boolean isEmpty();
    Map<Integer, TileType> getTileKeysSetting();
    TileType get(int keyCode);
}
