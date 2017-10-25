package ru.dgu.view.gui;

import ru.dgu.model.Loupe;
import ru.dgu.model.map.MapByEnumArray;
import ru.dgu.model.utils.Transfer;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer extends BufferedImage{
    private static Drawer drawer;

    private final MapByEnumArray mapByEnumArray;
    private final Loupe loupe;
    private final int tileSize;

    private Drawer(final MapByEnumArray mapByEnumArray, final Loupe loupe, final int tileSize){
        super(mapByEnumArray.getWidth() * tileSize, mapByEnumArray.getHeight() * tileSize, BufferedImage.TYPE_INT_ARGB);
        if(tileSize <= 0)
            throw new IllegalArgumentException("TileSize must be greater 0");

        this.mapByEnumArray = mapByEnumArray;
        this.loupe = loupe;
        this.tileSize = tileSize;
    }

    public static Drawer create(final MapByEnumArray mapByEnumArray, final Loupe loupe, final int tileSize){
        return drawer == null ? drawer = new Drawer(mapByEnumArray,loupe, tileSize) : drawer;
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

        final int xEnd = Math.min(mapByEnumArray.getWidth() - 1, endCoordinates.getX());
        final int yEnd = Math.min(mapByEnumArray.getHeight() - 1, endCoordinates.getY());

        Graphics g = getGraphics();
        for(int x = xStart; x < xEnd; x++){
            for(int y = yStart; y < yEnd; y++){
                final BufferedImage texture = mapByEnumArray.getTile(x,y).getTexture();
                g.drawImage(texture, x * tileSize, y * tileSize, tileSize, tileSize, null);
            }
        }
    }
}
