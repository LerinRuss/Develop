package ru.dgu.core.controler.handler;

import ru.dgu.controler.MultiAdapter;
import ru.dgu.controler.State;
import ru.dgu.controler.Switcher;
import ru.dgu.core.controler.mouse.MouseMoveControl;
import ru.dgu.core.controler.mouse.MouseScaleControl;
import ru.dgu.core.controler.mouse.MouseScrolling;
import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.*;

class WalkingControl extends MultiAdapter{
    private static boolean created = false;
    private final Switcher switcher;
    private final MouseScrolling mouseScrolling;
    private final MouseScaleControl mouseScaleControl;
    private final MouseMoveControl mouseMoveControl;

    WalkingControl(final MouseScaleControl mouseScaleControl,
                   final MouseMoveControl mouseMoveControl,
                   final MouseScrolling mouseScrolling,
                   final Switcher switcher){
        if(created)
            throw new CallMethodException("WalkingControl is already created");
        this.mouseMoveControl = mouseMoveControl;
        this.mouseScaleControl = mouseScaleControl;
        this.mouseScrolling = mouseScrolling;
        this.switcher = switcher;

        created = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseScrolling.mousePressed(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseScrolling.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMoveControl.mouseMoved(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        mouseScaleControl.mouseWheelMoved(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_TAB)
            switcher.switchState(State.ADDITION);
    }
}
