package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.Changer;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Switcher;
import ru.dgu.model.map.tiles.TileType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;

class TileTypeAdditionHandler extends MultiAdapter {

    private final Map<Integer, TileType> tileTypesMap;//?
    private final Changer changer;
    private final Switcher switcher;
    private TileType type;//?

    TileTypeAdditionHandler(Switcher switcher, Changer changer) {
        if(KeySetting.getTileTypeKeysSetting().isEmpty())
            throw new IllegalArgumentException("Key codes for tile types are empty");
        this.switcher = switcher;
        this.changer = changer;
        this.tileTypesMap = KeySetting.getTileTypeKeysSetting();
        type = tileTypesMap.values().iterator().next();//?
    }


    @Override
    public void mousePressed(MouseEvent e) {
        changer.setTileType(type, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        changer.setTileType(type, e.getX(), e.getY());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        final TileType type = tileTypesMap.get(e.getKeyCode());
        setType(type);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_TAB)
            switcher.setCurrent(AdditionStore.getObjectTypeChangingHandler());
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
