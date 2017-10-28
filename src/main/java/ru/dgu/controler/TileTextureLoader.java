package ru.dgu.controler;

import ru.dgu.model.map.tiles.TileType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileTextureLoader {
    private static final BufferedImage[] textures = new BufferedImage[TileType.values().length];
    private static final File directoryPath = new File("src/main/resources/textures/tiles/");
    private static final String format = ".png";
    private static boolean loaded;

    public static void load(final int tileSize) {
        if(loaded)
            throw new CallMethodException("Textures are already leaded");

        TileType[] types = TileType.values();
        for (int i = 0; i < types.length; i++) {
            final File file = new File(directoryPath,types[i].name().toLowerCase().concat(format));
            try {
                final BufferedImage texture = ImageIO.read(file);
                checkTexture(texture, tileSize);
                textures[i] = texture;
            } catch (IOException e) {
                final String massage = String.format("Couldn't upload %s file, maybe, it's not exist",file.toString());
                throw new LoadingException(massage,e);
            }
        }
        loaded = true;
    }
    private static void checkTexture(final BufferedImage texture, final int tileSize) {
        if(texture.getWidth() != tileSize || texture.getHeight() != tileSize)
            throw new LoadingException("Texture size doesn't math with tile size");
    }

    public static BufferedImage getTexture(TileType type) {
        if (!loaded)
            throw new LoadingException("First, you need to load textures to get someone");
        return textures[type.ordinal()];
    }
}
