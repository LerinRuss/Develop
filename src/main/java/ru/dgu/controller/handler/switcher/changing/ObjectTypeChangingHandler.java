package ru.dgu.controller.handler.switcher.changing;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;

import static ru.dgu.controller.handler.switcher.changing.ChangingHandler.*;

class ObjectTypeChangingHandler extends MultiAdapter {
    private final Map<Integer, ObjectType> objectTypeMap;
    private ObjectType type;

    ObjectTypeChangingHandler(Map<Integer, ObjectType> objectTypeMap) {
        this.objectTypeMap = objectTypeMap;
        type = objectTypeMap.values().iterator().next();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        final ObjectType type = objectTypeMap.get(e.getKeyCode());
        setType(type);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_TAB)
            setCurrent(getTileTypeAddition());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        add(type, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        add(type, e.getX(), e.getY());
    }

    @Override
    public String toString() {
        return "Object type addition. Type = " + type;
    }

    private void setType(ObjectType type) {
        if(type != null)
            this.type = type;
    }
}
