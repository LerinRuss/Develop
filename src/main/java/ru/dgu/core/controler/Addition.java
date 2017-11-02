package ru.dgu.core.controler;

import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

public interface Addition {
    void add(TileType tileType);
    void add(ObjectType objectType);
}
