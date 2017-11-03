package ru.dgu.controller;

import org.junit.Test;
import ru.dgu.core.loaders.TileTextureLoader;
import ru.dgu.core.Main;
import ru.dgu.model.map.tiles.TileType;

import static org.junit.Assert.assertNotNull;

public class TileByEnumTextureLoaderTest
{
    @Test
    public void load() throws Exception {
        TileTextureLoader.load(Main.TILE_SIZE);

        for (TileType tile : TileType.values()) {
            assertNotNull(TileTextureLoader.getTexture(tile));
        }
    }
}