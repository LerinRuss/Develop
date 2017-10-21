package ru.dgu.tiles;

import ru.dgu.controler.TileTextureLoader;

import java.awt.image.BufferedImage;

public enum Tile
{
    Grass, Sand, Water;
    private BufferedImage texture;

    public void setTexture(BufferedImage texture){
        this.texture = texture;
    }

    public BufferedImage getTexture(){
        return texture;
    }
}
