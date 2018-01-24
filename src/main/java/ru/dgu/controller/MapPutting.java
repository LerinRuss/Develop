package ru.dgu.controller;

import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

/**
 * This interface represents a map capability for adding and setting
 * objects or tiles on the game map
 */
public interface MapPutting {
    void setTile(TileType tileType, int x, int y);
    void addObject(ObjectType objectType, int x, int y);
}
