package ru.dgu.controller;

import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

public interface Changer {
    void setTileType(TileType tileType, int x, int y);
    void add(ObjectType objectType, int x, int y);
}
