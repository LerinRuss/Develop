package ru.dgu.model.objects.environment.tree;

import ru.dgu.model.objects.environment.EnvironmentObject;
import ru.dgu.model.objects.environment.tree.state.SproutState;
import ru.dgu.model.objects.environment.tree.state.TreesState;
import ru.dgu.model.objects.environment.tree.state.TreeStateEnum;

public class Tree extends EnvironmentObject
{
    private int growthPoint;
    private TreesState state;

    public Tree()
    {
        this.growthPoint = 0;
        this.state = new SproutState();
    }

    public void increaceGrowthPoint(int count)
    {
        growthPoint += count;
    }
    public int getGrowthPoint(){
        return growthPoint;
    }

    public TreeStateEnum getState()
    {
        return state.getState();
    }

    public void setState(TreesState state)
    {
        this.state = state;
    }

    public void grow()
    {

    }


}
