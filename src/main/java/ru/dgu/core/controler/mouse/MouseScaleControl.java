package ru.dgu.core.controler.mouse;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseScaleControl implements MouseWheelListener {
    private static boolean created = false;
    private Scalable scalable;

    public MouseScaleControl(final Scalable scalable){
        if(created)
            throw new CallMethodException("MouseScaleControl is already created");
        this.scalable = scalable;
        created = true;
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scalable.resize(e.getWheelRotation() << 5);
    }
}
