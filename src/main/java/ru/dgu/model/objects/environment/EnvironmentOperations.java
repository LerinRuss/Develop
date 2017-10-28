package ru.dgu.model.objects.environment;

import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.objects.environment.tree.Tree;

public class EnvironmentOperations
{
    private EnvironmentOperations(){

    }
    public static EnvironmentObject createTree(Tile tile){
        return new Tree(tile);
    }

}
