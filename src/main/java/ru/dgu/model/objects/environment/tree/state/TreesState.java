package ru.dgu.model.objects.environment.tree.state;


import ru.dgu.model.objects.environment.tree.Tree;

public abstract class TreesState
{
    public static final int SHRUB_POINT = 100;
    public static final int TREE_POINT = 300;
    public abstract TreeStateEnum getState();
    public abstract void grow(Tree tree);

}
