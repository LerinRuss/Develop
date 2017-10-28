package ru.dgu.model.objects.environment.tree.state;

import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;

public class ShrubState extends TreesState
{
    public ShrubState(){}
    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.TREE;
    }

    @Override
    public void grow(Tree tree)
    {
        tree.increaceGrowthPoint(Constants.GROW_POINT_PER_STEP);
        if(tree.getGrowthPoint() >= TreesState.TREE_POINT){
            tree.setState(new TreeState());
        }
    }
}
