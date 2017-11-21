package ru.dgu.model.objects.environment.tree.state;


import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;
import ru.dgu.model.texture_storage.TreeTexturesStorage;

import java.awt.image.BufferedImage;

public class SproutState extends TreesState
{
    private SproutState(){}
    private static TreeStateEnum state = TreeStateEnum.SPROUT;
    private static BufferedImage texture;
    private static SproutState sproutState = new SproutState();

    public static SproutState get(){
        texture = TreeTexturesStorage.getTexture(state);
        return sproutState;
    }

    @Override
    public TreeStateEnum getState()
    {
        return state;
    }

    public static void rise(Tree tree)
    {
        tree.increaseGrowthPoint(Constants.GROW_POINT_PER_STEP);
        if(tree.getGrowthPoint() >= TreesState.SHRUB_POINT){
            tree.setState(ShrubState.get());
        }
    }
    @Override
    public void grow(Tree tree){
        rise(tree);
    }
}
