package ru.dgu.core.controler.handler;

import ru.dgu.controler.MultiAdapter;
import ru.dgu.controler.State;
import ru.dgu.controler.Switcher;
import ru.dgu.core.controler.Addition;
import ru.dgu.core.controler.mouse.MouseMoveControl;
import ru.dgu.core.controler.mouse.MouseScaleControl;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Map;

class AdditionControl extends MultiAdapter{
    private final MouseScaleControl mouseScaleControl;
    private final MouseMoveControl mouseMoveControl;
    private final Switcher switcher;
    private final Addition addition;
    private final Map<Integer, TileType> tileTypesMap;
    private final Map<Integer, ObjectType> objectTypeMap;

    private final MultiAdapter objectTypeAddition = new ObjectTypeAddition();
    private final MultiAdapter tileTypeAddition = new TileTypeAddition();
    private MultiAdapter current = objectTypeAddition;

    AdditionControl(MouseScaleControl mouseScaleControl,
                           MouseMoveControl mouseMoveControl,
                           Switcher switcher, Addition addition,
                           Map<Integer, TileType> tileTypesMap,
                           Map<Integer, ObjectType> objectTypeMap) {
        if(tileTypesMap.isEmpty())
            throw new IllegalArgumentException("Key codes for tile types are empty");
        if(objectTypeMap.isEmpty())
            throw new IllegalArgumentException("Key codes for object types are empty");

        this.mouseScaleControl = mouseScaleControl;
        this.mouseMoveControl = mouseMoveControl;
        this.switcher = switcher;
        this.addition = addition;
        this.tileTypesMap = tileTypesMap;
        this.objectTypeMap = objectTypeMap;
    }

    private void setCurrent(MultiAdapter current) {
        this.current = current;
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
    public void mouseMoved(MouseEvent e) {
        mouseMoveControl.mouseMoved(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        mouseScaleControl.mouseWheelMoved(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON2)
            switcher.switchState(State.WALKING);
    }

    private class ObjectTypeAddition extends MultiAdapter{
        private ObjectType type = objectTypeMap.values().iterator().next();

        @Override
        public void keyPressed(KeyEvent e) {
            final ObjectType type = objectTypeMap.get(e.getKeyCode());
            setType(type);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)
                addition.add(type);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)
                addition.add(type);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_TAB)
                setCurrent(tileTypeAddition);
        }

        private void setType(ObjectType type) {
            if(type != null)
                this.type = type;
        }
    }

    private class TileTypeAddition extends MultiAdapter{
        private TileType type = tileTypesMap.values().iterator().next();

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)
                addition.add(type);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)
                addition.add(type);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            final TileType type = tileTypesMap.get(e.getKeyCode());
            setType(type);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_TAB)
                setCurrent(tileTypeAddition);
        }

        private void setType(final TileType type){
            if(type != null)
                this.type = type;
        }
    }
}
