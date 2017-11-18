package ru.dgu.model.objects.environment.tree;

import ru.dgu.model.objects.environment.tree.state.TreesState;

import java.awt.image.BufferedImage;

public class TreeLoad {

    private TreeLoad(){}

    public static void load(){
        new TreeTexturesStorage(null);
    }

    static class TreeTexturesStorage {
        private static BufferedImage[] bufferedImages;

        private TreeTexturesStorage(BufferedImage[] textures){
            TreeTexturesStorage.bufferedImages = textures;
        }

        private static void load(){

        }

        static BufferedImage getBufferedImage(TreesState state) {
            return bufferedImages[state.getState().ordinal()];
        }
    }
}
