package ru.dgu.model.objects.environment.tree;

import ru.dgu.model.objects.environment.EnvironmentObject;
import ru.dgu.model.objects.environment.tree.state.SproutState;
import ru.dgu.model.objects.environment.tree.state.TreeStateEnum;
import ru.dgu.model.objects.environment.tree.state.TreesState;
import ru.dgu.model.texture_storage.TreeTexturesStorage;
import ru.dgu.model.utils.action.Action;

import java.awt.image.BufferedImage;

public class Tree extends EnvironmentObject implements Action
{
    private int growthPoint;
    private TreesState state;

    public Tree()
    {
        this.growthPoint = 0;
        setState(SproutState.get());
        setTexture(TreeTexturesStorage.getTexture(getState()));
    }

    public void increaseGrowthPoint(int count)
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
        state.grow(this);
    }

    @Override
    public BufferedImage getTexture(){
        return state.getTexture();
    }

    @Override
    public void setTexture(BufferedImage texture){
        state.setTexture(texture);
    }

    @Override
    public void action()
    {
        grow();
        setTexture(TreeTexturesStorage.getTexture(getState()));
    }

    @Override
    public String toString()
    {
        return "Tree{" +
                "growthPoint=" + growthPoint +
                ", state=" + state.getState() +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (growthPoint != tree.growthPoint) return false;
        return state.getState() != null ? state.getState().equals(tree.state.getState()) : tree.state == null;
    }

    @Override
    public int hashCode()
    {
        int result = growthPoint;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
