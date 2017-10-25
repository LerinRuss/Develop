package ru.dgu.model.map;

import ru.dgu.controler.TileTextureLoader;

import java.awt.image.BufferedImage;

public enum TileByEnum
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
