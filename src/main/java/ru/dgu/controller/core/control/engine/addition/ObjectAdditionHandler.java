package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.MapPutting;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.ObjectAdditionKeysSetting;
import ru.dgu.controller.Switcher;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

class ObjectAdditionHandler extends MultiAdapter {
    private final ObjectAdditionKeysSetting objectKeysSetting;
    private final MapPutting mapPutting;
    private final Switcher switcher;
    private ObjectType type;

    ObjectAdditionHandler(Switcher switcher,
                          MapPutting mapPutting,
                          ObjectAdditionKeysSetting objectKeysSetting) {

        if(objectKeysSetting.isEmpty())
            throw new IllegalArgumentException("Key codes for object types are empty");

        this.switcher = switcher;
        this.mapPutting = mapPutting;
        this.objectKeysSetting = objectKeysSetting;

        type = objectKeysSetting.getObjectKeysSetting().values().iterator().next();
    }

    //start control block
    @Override
    public void keyPressed(KeyEvent e) {
        final ObjectType type = objectKeysSetting.get(e.getKeyCode());
        setType(type);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(objectKeysSetting.hasSwitched(e.getKeyCode()))
            switcher.setCurrent(AdditionStore.getTileTypeAdditionHandler());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mapPutting.addObject(type, e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mapPutting.addObject(type, e.getX(), e.getY());
    }
    //end control block

    @Override
    public String toString() {
        return "Object type addition. Type = " + type;
    }

    private void setType(ObjectType type) {
        if(type != null)
            this.type = type;
    }
}
