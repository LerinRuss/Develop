package ru.dgu.model.texture_storage;

import ru.dgu.model.exceptions.ModelException;
import ru.dgu.model.objects.environment.tree.state.TreeStateEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TreeTexturesStorage
{
    private static final String PARENT_DIRECTORY_PATH = "src/main/resources/textures/enviroment/";
    private static final String DIRECTORY_PATH = "tree/";
    private static final String EXPANSION = ".jpg";
    private static BufferedImage[] bufferedImages;
    private static boolean loaded = false;
    private static void load(){
        for(TreeStateEnum item : TreeStateEnum.values()){
            try {
                bufferedImages[item.ordinal()] = ImageIO.read(new File(PARENT_DIRECTORY_PATH + DIRECTORY_PATH + item.name().toLowerCase() + EXPANSION));
            } catch (IOException e) {
                throw new ModelException("Can not load tree texture ");
            }
        }
        loaded = true;
    }

    public static BufferedImage getTexture(TreeStateEnum state)
    {
        if(!loaded){
            load();
        }
        return bufferedImages[state.ordinal()];
    }

}
