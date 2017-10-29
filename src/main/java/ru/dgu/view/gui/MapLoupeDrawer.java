package ru.dgu.view.gui;

import ru.dgu.controler.TileTextureLoader;
import ru.dgu.model.modelcore.ModelCore;
import ru.dgu.utils.coordinates.IntegerCoordinates;
import ru.dgu.utils.coordinates.Transfer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapLoupeDrawer extends BufferedImage{
    private static MapLoupeDrawer mapLoupeDrawer;

    private final Loupe loupe;
    private final int tileSize;
    private Accentuation accentuation;
    private final int size; //!!!

    private MapLoupeDrawer(final  int size, final Loupe loupe, final int tileSize){
        super(size * tileSize, size * tileSize, BufferedImage.TYPE_INT_ARGB);
        if(tileSize <= 0)
            throw new IllegalArgumentException("TileSize must be greater 0");

        this.size = size;
        this.loupe = loupe;
        this.tileSize = tileSize;
    }

    public static MapLoupeDrawer create(final  int size, final Loupe loupe, final int tileSize){
        return mapLoupeDrawer == null ? mapLoupeDrawer = new MapLoupeDrawer(size,loupe, tileSize) : mapLoupeDrawer;
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

        final int xEnd = Math.min(size - 1, endCoordinates.getX());
        final int yEnd = Math.min(size - 1, endCoordinates.getY());

        Graphics g = getGraphics();
        for(int x = xStart; x <= xEnd; x++){
            for(int y = yStart; y <= yEnd; y++){
                final BufferedImage texture = TileTextureLoader.getTexture(ModelCore.getTileType(x,y));
                g.drawImage(texture, x * tileSize, y * tileSize, tileSize, tileSize, null);
            }
        }
        accentuation.paint(g);
    }

    public Loupe getLoupe() {
        return loupe;
    }

    public void setAccentuation(final Accentuation accentuation){
        this.accentuation = accentuation;
    }
}
