package ru.dgu.controller.handler;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.core.controller.Movable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class CommonHandler extends MultiAdapter{
    private final Movable movable;

    public CommonHandler(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        movable.move(e.getX(), e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        //loupe.resize(e.getWheelRotation() << 5);
    }
}
