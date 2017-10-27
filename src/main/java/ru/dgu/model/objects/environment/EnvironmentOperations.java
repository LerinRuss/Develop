package ru.dgu.model.objects.environment;

import ru.dgu.model.objects.environment.tree.ConcreteTree;

public class EnvironmentOperations
{
    private EnvironmentOperations(){

    }
    public static EnvironmentObject createConcreateTree(){
        return new ConcreteTree();
    }

}
