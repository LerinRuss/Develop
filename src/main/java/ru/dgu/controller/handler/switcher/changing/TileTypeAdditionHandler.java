package ru.dgu.controller.handler.switcher.changing;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.model.map.tiles.TileType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;

import static ru.dgu.controller.handler.switcher.changing.ChangingHandler.*;

public class TileTypeAdditionHandler extends MultiAdapter {

    private final Map<Integer, TileType> tileTypesMap;
    private TileType type;

    TileTypeAdditionHandler(Map<Integer, TileType> tileTypesMap) {
        this.tileTypesMap = tileTypesMap;
        type = tileTypesMap.values().iterator().next();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        setTileType(type, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        setTileType(type, e.getX(), e.getY());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        final TileType type = tileTypesMap.get(e.getKeyCode());
        setType(type);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_TAB)
            setCurrent(getObjectTypeAddition());
    }

    @Override
    public String toString() {
        return "Tile type addition. Type = " + type;
    }

    private void setType(final TileType type){
        if(type != null)
            this.type = type;
    }

}
