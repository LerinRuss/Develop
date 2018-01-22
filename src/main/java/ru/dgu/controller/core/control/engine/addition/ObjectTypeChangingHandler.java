package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Changer;
import ru.dgu.controller.Switcher;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Map;

class ObjectTypeChangingHandler extends MultiAdapter {
    private final Map<Integer, ObjectType> objectTypeMap;
    private final Changer changer;
    private final Switcher switcher;
    private ObjectType type;

    ObjectTypeChangingHandler(Switcher switcher, Changer changer) {
        if(KeySetting.getObjectTypeKeys().isEmpty())
            throw new IllegalArgumentException("Key codes for object types are empty");
        this.switcher = switcher;
        this.changer = changer;
        this.objectTypeMap = KeySetting.getObjectTypeKeys();
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
            switcher.setCurrent(AdditionStore.getTileTypeAdditionHandler());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        changer.add(type, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        changer.add(type, e.getX(), e.getY());
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
