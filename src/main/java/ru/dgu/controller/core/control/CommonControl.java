package ru.dgu.controller.core.control;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.core.controller.Movable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * this class is realization of common control ways.
 * it doesn't have any control states.
 * it doesn't affect other control states or uses.
 * For more efficient using you should put it first to the {@link ru.dgu.controller.Backbone}
 * otherwise other controls can affect one.
 */
public class CommonControl extends MultiAdapter{
    private final Movable movable;

    CommonControl(Movable movable) {
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
