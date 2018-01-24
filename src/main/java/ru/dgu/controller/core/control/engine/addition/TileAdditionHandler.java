package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.MapPutting;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Switcher;
import ru.dgu.controller.TileAdditionKeysSetting;
import ru.dgu.model.map.tiles.TileType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

class TileAdditionHandler extends MultiAdapter {

    private final TileAdditionKeysSetting tileKeysSetting;
    private final MapPutting mapPutting;
    private final Switcher switcher;
    private TileType type;

    TileAdditionHandler(Switcher switcher,
                        MapPutting mapPutting,
                        TileAdditionKeysSetting tileKeysSetting) {

        if(tileKeysSetting.isEmpty())
            throw new IllegalArgumentException("Key codes for tile types are empty");

        this.switcher = switcher;
        this.mapPutting = mapPutting;
        this.tileKeysSetting = tileKeysSetting;

        setType(tileKeysSetting.getTileKeysSetting().values().iterator().next());

    }
    //start control block
    @Override
    public void mousePressed(MouseEvent e) {
        mapPutting.setTile(type, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mapPutting.setTile(type, e.getX(), e.getY());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        final TileType type = tileKeysSetting.get(e.getKeyCode());
        setType(type);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(tileKeysSetting.hasSwitched(e.getKeyCode()))
            switcher.setCurrent(AdditionStore.getObjectTypeChangingHandler());
    }
    //end block

    @Override
    public String toString() {
        return "Tile type addition. Type = " + type;
    }

    private void setType(final TileType type){
        if(type != null)
            this.type = type;
    }
}
