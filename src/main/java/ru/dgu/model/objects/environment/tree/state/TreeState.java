package ru.dgu.model.objects.environment.tree.state;

import ru.dgu.model.objects.environment.tree.Tree;

public class TreeState extends TreesState
{
    public TreeState(){}
    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.TREE;
    }

    @Override
    public void grow(Tree tree)
    {

    }
}
