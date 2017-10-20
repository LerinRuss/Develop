package ru.dgu.controler;

import org.junit.Test;
import ru.dgu.tiles.TileType;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class TileTextureLoaderTest {
    @Test (expected = LoadingException.class)
    public void getTextureWithoutLoadingTest() throws Exception {
        TileTextureLoader.getTexture(TileType.Grass);
    }

    @Test
    public void load() throws Exception {
        TileTextureLoader.load();
        final BufferedImage[] textures = TileTextureLoader.getTextures();

        for (BufferedImage texture : textures) {
            assertNotNull(texture);
        }
    }
}