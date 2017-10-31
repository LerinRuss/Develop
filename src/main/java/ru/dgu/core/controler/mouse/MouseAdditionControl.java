package ru.dgu.core.controler.mouse;

import ru.dgu.model.map.tiles.TileType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseAdditionControl extends MouseAdapter{
    private TileType type;

    MouseAdditionControl(){}

    @Override
    public void mousePressed(MouseEvent e) {
        if(type == null)
            return;
        //IntegerCoordinates coords = coordinator.transfer(e);
        //IntegerCoordinates coordinates = Transfer.transferCoordinates(Main.TILE_SIZE, coords.getX(),coords.getY());

//        if(ModelCore.outOfMapBound(coordinates))
//            return;
//
//        ModelCore.setTileType(type, coordinates.getX(), coordinates.getY());
    }

    private void setType(TileType type) {
        this.type = type;
    }
}
