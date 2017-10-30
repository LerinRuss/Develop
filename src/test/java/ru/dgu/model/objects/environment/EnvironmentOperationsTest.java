package ru.dgu.model.objects.environment;

import org.junit.Test;
import ru.dgu.model.objects.environment.tree.Tree;

import static org.junit.Assert.assertEquals;

public class EnvironmentOperationsTest
{
    @Test
    public void createTreeTest()throws Exception
    {
        assertEquals(new Tree(), EnvironmentOperations.createTree());
    }

}