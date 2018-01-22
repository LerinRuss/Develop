package ru.dgu.controller.core.control.engine;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Switcher;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AdditionControl extends MultiAdapter implements Switcher{
    private MultiAdapter current;

    public AdditionControl() {}

    public void setCurrent(MultiAdapter current) {
        assert current != null;

        this.current = current;
    }

    //base control block
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3)
            this.setCurrent(EngineStore.getWalkingHandler());
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
    public void keyTyped(KeyEvent e) {
        current.keyTyped(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        current.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        current.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        current.mouseDragged(e);
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
    public void mouseMoved(MouseEvent e) {
        current.mouseMoved(e);
    }
    //end control block

    @Override
    public String toString() {
        return current.toString();
    }
}
