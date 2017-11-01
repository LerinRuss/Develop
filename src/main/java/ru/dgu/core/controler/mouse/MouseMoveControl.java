package ru.dgu.core.controler.mouse;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMoveControl extends MouseAdapter {
    private static boolean created = false;
    private final CursorMovable movable;

    public MouseMoveControl(final CursorMovable movable){
        if(created)
            throw new CallMethodException("MouseMoveControl is already exist");
        this.movable = movable;
        created = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        movable.translate(e.getX(), e.getY());
    }
}
