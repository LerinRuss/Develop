package ru.dgu.controler;

import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

class MouseControl extends MouseAdapter{
    private static boolean created = false;
    private MouseAdapter mouseAdapter;

    MouseControl(final MouseAdapter mouseAdapter){
        if(created)
            throw new CallMethodException("MouseControl is already created");
        setMouseAdapter(mouseAdapter);
        created = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       mouseAdapter.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseAdapter.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseAdapter.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseAdapter.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseAdapter.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        mouseAdapter.mouseWheelMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseAdapter.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseAdapter.mouseMoved(e);
    }

    void setMouseAdapter(MouseAdapter mouseAdapter) {
        this.mouseAdapter = mouseAdapter;
    }

}

