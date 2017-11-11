package ru.dgu.model.objects.environment.tree.state;

import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;

public class ShrubState extends TreesState
{
    private ShrubState(){}
    private static ShrubState shrubState = new ShrubState();
    public static ShrubState get(){
        return shrubState;
    }
    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.SHRUB;
    }

    @Override
    public void grow(Tree tree)
    {
        tree.increaceGrowthPoint(Constants.GROW_POINT_PER_STEP);
        if(tree.getGrowthPoint() >= TreesState.TREE_POINT){
            tree.setState(TreeState.get());
        }
    }
}
