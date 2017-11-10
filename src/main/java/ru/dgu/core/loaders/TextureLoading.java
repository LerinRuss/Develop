package ru.dgu.core.loaders;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.UnaryOperator;

public class TextureLoading {

    public static BufferedImage[] load(final String directoryPath, final String[] names, final String format) {
        final UnaryOperator<BufferedImage> unary = bufferedImage -> bufferedImage;
        return load(directoryPath, names, format, unary);
    }

    public static BufferedImage[] load(final String directoryPath, final String[] names, final String format,
                                       final int tileSize){
        final UnaryOperator<BufferedImage> unary = image -> {
            if(image.getWidth() != tileSize || image.getHeight() != tileSize)
                throw new LoadingException("Texture size doesn't math with tile size");
            return image;
        };
        return load(directoryPath, names,format,unary);
    }

    private static BufferedImage[] load(final String directoryPath, final String[] names, final String format,
                                       final UnaryOperator<BufferedImage> unaryOperator) {
        final BufferedImage[] textures = new BufferedImage[names.length];

        for (int i = 0; i < names.length; i++) {
            final File file = new File(directoryPath,names[i].concat(format));
            try {
                final BufferedImage texture =  ImageIO.read(file);
                textures[i] = unaryOperator.apply(texture);
            } catch (IOException e) {
                final String massage = String.format("Couldn't upload %s file, maybe, it's not exist",file.toString());
                throw new LoadingException(massage,e);
            }
        }
        return textures;
    }
}
