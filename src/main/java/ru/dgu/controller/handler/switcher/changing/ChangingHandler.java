package ru.dgu.controller.handler.switcher.changing;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Changer;
import ru.dgu.controller.handler.switcher.Switcher;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ChangingHandler extends MultiAdapter{
    private static Changer changer;
    private static MultiAdapter objectTypeAddition;
    private static MultiAdapter tileTypeAddition;
    private static MultiAdapter current;

    public ChangingHandler(Changer changer) {
        if(KeySetting.getTileTypeKeysSetting().isEmpty())
            throw new IllegalArgumentException("Key codes for tile types are empty");
        if(KeySetting.getObjectTypeKeys().isEmpty())
            throw new IllegalArgumentException("Key codes for object types are empty");

        ChangingHandler.changer = changer;
        objectTypeAddition = new ObjectTypeChangingHandler(KeySetting.getObjectTypeKeys());
        tileTypeAddition  = new TileTypeAdditionHandler(KeySetting.getTileTypeKeysSetting());

        setCurrent(tileTypeAddition);
    }

    static void setCurrent(MultiAdapter current) {
        ChangingHandler.current = current;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        current.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        current.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        current.keyTyped(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        current.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        current.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        current.mouseDragged(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3)
            Switcher.setCurrent(Switcher.getWalkingHandler());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        current.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        current.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        current.mouseWheelMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        current.mouseMoved(e);
    }

    @Override
    public String toString() {
        return current.toString();
    }

    static MultiAdapter getObjectTypeAddition() {
        return objectTypeAddition;
    }

    static MultiAdapter getTileTypeAddition() {
        return tileTypeAddition;
    }

    static void setTileType(TileType tileType, int x, int y){
        changer.setTileType(tileType, x, y);
    }

    static void add(ObjectType objectType, int x, int y){
        changer.add(objectType, x, y);
    }
}
