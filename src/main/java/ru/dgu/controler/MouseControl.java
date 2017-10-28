package ru.dgu.controler;

import ru.dgu.core.main.Main;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.modelcore.ModelCore;
import ru.dgu.utils.coordinates.Transfer;
import ru.dgu.utils.coordinates.IntegerCoordinates;
import ru.dgu.view.gui.Accentuation;
import ru.dgu.view.gui.Loupe;

import java.awt.event.*;

/*
    this control is added to component
 */
public class MouseControl implements MouseMotionListener, MouseListener, MouseWheelListener {
    private final Loupe loupe;
    private final Accentuation accentuation;
    private int oldX, oldY;
    private final int mapSize;
    public static TileType type;

    /*
        loupe witch sees at component
     */
    public MouseControl(final Loupe loupe, final Accentuation accentuation, final int mapSize){
        this.loupe = loupe;
        this.accentuation = accentuation;
        this.mapSize = mapSize;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        final int dx = -e.getX() + oldX;
        final int dy = -e.getY() + oldY;

        loupe.addX(dx);
        loupe.addY(dy);

        oldX = e.getX();
        oldY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        final int x = loupe.getX() - loupe.getWidth()/2 + e.getX();
        final int y = loupe.getY() - loupe.getHeight()/2 + e.getY();
        IntegerCoordinates coordinates = Transfer.transferCoordinates(Main.TILE_SIZE, x,y);
        if(coordinates.getX() < 0 || coordinates.getX() >= mapSize)
            return;
        if(coordinates.getY() < 0 || coordinates.getY() >= mapSize)
            return;

        accentuation.translate(coordinates);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
        if(type == null)
            return;

        final int x = loupe.getX() - loupe.getWidth()/2 + oldX;
        final int y = loupe.getY() - loupe.getHeight()/2 + oldY;

        IntegerCoordinates coordinates = Transfer.transferCoordinates(Main.TILE_SIZE, x,y);

        if(ModelCore.outOfMapBound(coordinates))
            return;

        ModelCore.setTileType(type, coordinates.getX(), coordinates.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
//        final int x = loupe.getX() - loupe.getWidth()/2 + e.getX();
//        final int y = loupe.getY() - loupe.getHeight()/2 + e.getY();
//        loupe.resize(x,y,e.getWheelRotation() << 2);
    }
}
