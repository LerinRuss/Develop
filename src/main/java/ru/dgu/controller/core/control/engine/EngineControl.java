package ru.dgu.controller.core.control.engine;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Switcher;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
/**
 * This class is realisation control of two states:
 * walking and addition. what is more only one of two can be called at the same time.
 *
 * One more, in order to indicate what state is
 *
 * Dragging can be used only after press LKM button.
 */
class EngineControl extends MultiAdapter implements Switcher{
    private MultiAdapter current;
    private boolean dragged;

    EngineControl() {
    }

    //base control block
    @Override
    public void keyTyped(KeyEvent e) {
        current.keyTyped(e);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        current.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        current.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        current.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1)
            return;
        current.mousePressed(e);
        dragged = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() != MouseEvent.BUTTON1)
            return;
        current.mouseReleased(e);
        dragged = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        current.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        current.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        current.mouseWheelMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!dragged)
            return;
        current.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        current.mouseMoved(e);
    }
    //end control block

    public void setCurrent(MultiAdapter current) {
        assert this.current != null;

        this.current = current;
    }

}
