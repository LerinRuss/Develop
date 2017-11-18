package ru.dgu.model.texture_storage;

import ru.dgu.model.objects.environment.tree.Tree;

import java.awt.image.BufferedImage;

public class TreeTexturesStorage
{
    private static BufferedImage[] bufferedImages;

    public static BufferedImage getBufferedImage(int i)
    {
        return bufferedImages[i];
    }

    public static void setBufferedImages(BufferedImage bufferedImage, int i)
    {
        TreeTexturesStorage.bufferedImages[i] = bufferedImage;
    }

    public static void setTexture(Tree tree)
    {
        tree.setTexture(bufferedImages[tree.getState().ordinal()]);
    }

}
