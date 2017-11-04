package ru.dgu.model.map.tiles;

import java.awt.image.BufferedImage;

public enum TileType
{
    GRASS, DIRTY, SAND, WATER, SHALLOW, BEACH_SAND ,EMPTY;
    private BufferedImage texture;

    public void setTexture(BufferedImage texture){
        this.texture = texture;
    }

    public BufferedImage getTexture(){
        return texture;
    }
}
