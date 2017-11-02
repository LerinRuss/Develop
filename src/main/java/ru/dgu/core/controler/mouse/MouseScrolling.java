package ru.dgu.core.controler.mouse;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseScrolling extends MouseAdapter {
    private static boolean created = false;

    private final Scrollable controllable;
    private int oldX, oldY;

    public MouseScrolling(final Scrollable controllable) {
        if(created)
            throw new CallMethodException("MouseScrolling is already exist");
        this.controllable = controllable;
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
}
