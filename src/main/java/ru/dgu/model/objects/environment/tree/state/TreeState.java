package ru.dgu.model.objects.environment.tree.state;

import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;

public class TreeState extends TreesState
{
    private TreeState(){}
    private static TreeState treeState = new TreeState();
    public static TreeState get(){
        return treeState;
    }

    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.TREE;
    }

    @Override
    public void grow(Tree tree)
    {
        tree.increaseGrowthPoint(Constants.GROW_POINT_PER_STEP);
        if(tree.getGrowthPoint() >= TreesState.DEAD_TREE_POINT){
            tree.setState(DeadTreeState.get());
        }
    }
}
