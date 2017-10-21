package ru.dgu.view.gui;

import ru.dgu.model.Loupe;
import ru.dgu.model.utils.Transfer;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;
import ru.dgu.tiles.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer extends BufferedImage{
    private static Drawer drawer;

    private final Map map;
    private final Loupe loupe;
    private final int tileSize;

    private Drawer(final Map map,final Loupe loupe, final int tileSize){
        super(map.getWidth() * tileSize, map.getHeight() * tileSize, BufferedImage.TYPE_INT_ARGB);
        if(tileSize <= 0)
            throw new IllegalArgumentException("TileSize must be greater 0");

        this.map = map;
        this.loupe = loupe;
        this.tileSize = tileSize;
    }

    public static Drawer create(final Map map,final Loupe loupe, final int tileSize){
        return drawer == null ? drawer = new Drawer(map,loupe, tileSize) : drawer;
    }

    /*
        I can optimize it if to do window size equals 2^n.
     */
    public void repaint(){
        final float loupeStartX = loupe.getX() - (loupe.getWidth()/2);
        final float loupeStartY = loupe.getY() - (loupe.getHeight()/2);
        final IntegerCoordinates startCoordinates = Transfer.transferCoordinates(tileSize,loupeStartX, loupeStartY);

        final int xStart = Math.max(0,startCoordinates.getX());
        final int yStart = Math.max(0,startCoordinates.getY());

        final int loupeEndX = loupe.getX() + (loupe.getWidth()/2);
        final int loupeEndY = loupe.getY() + (loupe.getHeight()/2);
        final IntegerCoordinates endCoordinates = Transfer.transferCoordinates(tileSize, loupeEndX, loupeEndY);

        final int xEnd = Math.min(map.getWidth() - 1, endCoordinates.getX());
        final int yEnd = Math.min(map.getHeight() - 1, endCoordinates.getY());

        Graphics g = getGraphics();
        for(int x = xStart; x < xEnd; x++){
            for(int y = yStart; y < yEnd; y++){
                final BufferedImage texture = map.getTile(x,y).getTexture();
                g.drawImage(texture, x * tileSize, y * tileSize, tileSize, tileSize, null);
            }
        }
    }
}
