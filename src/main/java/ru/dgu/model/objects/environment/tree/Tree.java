package ru.dgu.model.objects.environment.tree;

import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.objects.environment.EnvironmentObject;

import java.util.HashMap;
import java.util.Map;

public class Tree extends EnvironmentObject
{
    private static final Map<TileType, Integer> growPointFromTile;
    private Tile tile;
    private int growthPoint;

    static {
        growPointFromTile = new HashMap<>();
        growPointFromTile.put(TileType.GRASS, 25);
        growPointFromTile.put(TileType.WATER, 20);
        growPointFromTile.put(TileType.SAND, 5);
        growPointFromTile.put(TileType.EMPTY, 0);
    }

    private static final int SHRUB_POINT = 100;
    private static final int TREE_POINT = 300;

    public Tree(){
        this.growthPoint = 0;
    }

    public Tree(Tile tile)
    {
        this.tile = tile;
        this.growthPoint = 0;
    }

    public static void grow(Tree tree){
        tree.growthPoint += growPointFromTile.get(tree.tile.getType());

    }

}
