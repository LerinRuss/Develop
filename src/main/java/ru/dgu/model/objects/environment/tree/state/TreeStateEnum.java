package ru.dgu.model.objects.environment.tree.state;

public enum TreeStateEnum
{
    SPROUT(SproutState.get()), SHRUB(ShrubState.get()), TREE(TreeState.get()), DEAD_TREE(DeadTreeState.get());
    private TreesState state;
    TreeStateEnum(TreesState state){
        this.state = state;
    }

    public TreesState getState()
    {
        return state;
    }
}
