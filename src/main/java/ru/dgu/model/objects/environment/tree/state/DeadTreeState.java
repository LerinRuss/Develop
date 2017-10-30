package ru.dgu.model.objects.environment.tree.state;

import ru.dgu.model.objects.environment.tree.Tree;

public class DeadTreeState extends TreesState
{
    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.DEAD_TREE;
    }

    @Override
    public void grow(Tree tree)
    {}
}
