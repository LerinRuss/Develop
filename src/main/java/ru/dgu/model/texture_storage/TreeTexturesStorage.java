package ru.dgu.model.texture_storage;

import ru.dgu.model.objects.environment.tree.state.TreeStateEnum;

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

    public static void setTexture()
    {
        for(TreeStateEnum item : TreeStateEnum.values()){
            item.getState().setTexture(bufferedImages[item.ordinal()]);
        }
    }

}
