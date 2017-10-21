package ru.dgu.controler;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class TileTextureLoaderTest {
    @Test
    public void load() throws Exception {
        TileTextureLoader.load();
        final BufferedImage[] textures = TileTextureLoader.getTextures();

        for (BufferedImage texture : textures) {
            assertNotNull(texture);
        }
    }
}