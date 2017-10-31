package ru.dgu.core.controler;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseScrolling extends MouseAdapter {
    private static boolean created = false;

    private Scrollable controllable;
    private int oldX, oldY;

    MouseScrolling(final Scrollable controllable) {
        if(created)
            throw new CallMethodException("MouseScrolling is already exist");
        setControllable(controllable);
        created = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        final int dx = -e.getX() + oldX;
        final int dy = -e.getY() + oldY;

        controllable.move(dx, dy);

        oldX = e.getX();
        oldY = e.getY();
    }

    private void setControllable(final Scrollable controllable){
        this.controllable = controllable;
    }
}
