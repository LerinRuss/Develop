package ru.dgu.tiles;

public class Map {
    private final Tile[][] map;

    public Map(final int width,final int height){
        map = new Tile[width][height];
        fillMap(Tile.Grass);
    }

    private void fillMap(final Tile type){
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                setTile(TileChoicer.choice(type), x,y);
            }
        }
    }

    public int getWidth(){
        return map.length;
    }

    public int getHeight(){
        return map[0].length;
    }

    public Tile getTile(final int x, final int y){
        return map[x][y];
    }

    public void setTile(final Tile tile, final int x, final int y){
        map[x][y] = tile;
    }
}
