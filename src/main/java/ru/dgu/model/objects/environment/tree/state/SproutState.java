package ru.dgu.model.objects.environment.tree.state;


import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;

public class SproutState extends TreesState
{
    private SproutState(){}

    private static SproutState sproutState = new SproutState();

    public static SproutState get(){
        return sproutState;
    }

    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.SPROUT;
    }

    public static void rise(Tree tree)
    {
        tree.increaceGrowthPoint(Constants.GROW_POINT_PER_STEP);
        if(tree.getGrowthPoint() >= TreesState.SHRUB_POINT){
            tree.setState(ShrubState.get());
        }
    }
    @Override
    public void grow(Tree tree){
        rise(tree);
    }
}
