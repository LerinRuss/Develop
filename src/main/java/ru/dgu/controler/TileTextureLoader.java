package ru.dgu.controler;

import ru.dgu.model.map.TileByEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileTextureLoader {
    private static final BufferedImage[] textures = new BufferedImage[TileByEnum.values().length];
    private static final File directoryPath = new File("src/main/resources/textures/tiles/");
    private static final String format = ".png";
    private static boolean loaded;

    public static void load() throws LoadingException {
        if(loaded)
            return;

        TileByEnum[] types = TileByEnum.values();
        for (int i = 0; i < types.length; i++) {
            final File file = new File(directoryPath,types[i].name().concat(format));
            try {
                textures[i] = ImageIO.read(file);
            } catch (IOException e) {
                final String massage = String.format("Couldn't upload %s file, maybe, it's not exist",file.toString());
                throw new LoadingException(massage,e);
            }
        }
        loaded = true;
    }

    public static BufferedImage getTexture(TileByEnum type){
        if(!loaded)
            throw new LoadingException("First, you need to load textures to get someone");
        return textures[type.ordinal()];
    }

    public static BufferedImage[] getTextures() {
        return textures;
    }
}
