package ru.dgu.view.gui;

import ru.dgu.tiles.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer {
    private static Drawer drawer;

    private final BufferedImage desk;
    private final Graphics2D parent;
    private final Map map;
    private final int tileSize;

    private Drawer(final Graphics2D g,final Map map,final int tileSize){
        final int width = map.getWidth() * tileSize;
        final int height = map.getHeight() * tileSize;

        desk = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        parent = g;
        this.map = map;
        this.tileSize = tileSize;
    }

    public static Drawer create(final Graphics2D parent, final Map map, final int tileSize){
        return drawer == null ? drawer = new Drawer(parent,map, tileSize) : drawer;
    }

    public void repaint(){
        
    }
}
