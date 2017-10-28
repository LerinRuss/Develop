package ru.dgu.model.objects.environment.tree.state;


import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;

public class SproutState extends TreesState
{
    public SproutState(){

    }
    @Override
    public TreeStateEnum getState()
    {
        return TreeStateEnum.SPROUT;
    }

    @Override
    public void grow(Tree tree)
    {
        tree.increaceGrowthPoint(Constants.GROW_POINT_PER_STEP);
        if(tree.getGrowthPoint() >= TreesState.SHRUB_POINT){
            tree.setState(new ShrubState());
        }
    }
}
