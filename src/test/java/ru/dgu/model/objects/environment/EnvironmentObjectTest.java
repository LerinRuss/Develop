package ru.dgu.model.objects.environment;

import org.junit.Test;
import ru.dgu.model.constants.Constants;
import ru.dgu.model.objects.environment.tree.Tree;
import ru.dgu.model.objects.environment.tree.state.ShrubState;
import ru.dgu.model.objects.environment.tree.state.SproutState;
import ru.dgu.model.objects.environment.tree.state.TreeState;

import static org.junit.Assert.assertEquals;

public class EnvironmentObjectTest
{
    @Test
    public void treeTest()
    {
        Tree tree = new Tree();
        assertEquals(new SproutState().getState(), tree.getState());
    }

    @Test
    public void treeGrowShrubStateTest()
    {
        Tree tree = new Tree();
        for (int i = 0; i < TreeState.SHRUB_POINT / Constants.GROW_POINT_PER_STEP; i++) {
            tree.grow();
        }
        assertEquals(new ShrubState().getState(), tree.getState());
    }

    @Test
    public void treeGrowTreeStateTest()
    {
        Tree tree = new Tree();
        for (int i = 0; i < TreeState.TREE_POINT / Constants.GROW_POINT_PER_STEP; i++) {
            tree.grow();
        }
        assertEquals(new TreeState().getState(), tree.getState());
    }
}