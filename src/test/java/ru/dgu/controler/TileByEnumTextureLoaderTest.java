package ru.dgu.controler;

import org.junit.Test;
import ru.dgu.core.main.Main;
import ru.dgu.tiles.Tile;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class TileByEnumTextureLoaderTest
{
    @Test
    public void load() throws Exception {
        TileTextureLoader.load(Main.TILE_SIZE);

        for (Tile tile : Tile.values()) {
            assertNotNull(TileTextureLoader.getTexture(tile));
        }
    }
}