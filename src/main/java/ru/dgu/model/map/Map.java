package ru.dgu.model.map;

public class Map {
    private final TileByEnum[][] map;

    public Map(final int width,final int height){
        if(width <= 0)
            throw new IllegalArgumentException("width less or equal 0");
        if(height <= 0)
            throw new IllegalArgumentException("height less or equal 0");

        map = new TileByEnum[width][height];
        fillMap(TileByEnum.Grass);
    }

    private void fillMap(final TileByEnum type){
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                setTile(type, x,y);
            }
        }
    }

    public int getWidth(){
        return map.length;
    }

    public int getHeight(){
        return map[0].length;
    }

    public TileByEnum getTile(final int x, final int y){
        return map[x][y];
    }

    public void setTile(final TileByEnum tile, final int x, final int y){
        map[x][y] = tile;
    }
}
