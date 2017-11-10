package ru.dgu.controller.handler.switcher;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Changer;
import ru.dgu.core.controller.Loupe;
import ru.dgu.controller.handler.switcher.changing.ChangingHandler;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Switcher extends MultiAdapter{
    private static MultiAdapter walkingHandler;
    private static MultiAdapter additionHandler;
    private static MultiAdapter current;
    private boolean dragged;

    public Switcher(final Loupe loupe,
                    final Changer changer) {
        walkingHandler = new WalkingHandler(loupe);
        additionHandler = new ChangingHandler(changer);
        setCurrent(walkingHandler);
    }

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

    @Override
    public String toString() {
        return current.toString();
    }

    public static MultiAdapter getWalkingHandler() {
        return walkingHandler;
    }

    public static MultiAdapter getAdditionHandler() {
        return additionHandler;
    }

    public static void setCurrent(MultiAdapter current) {
        Switcher.current = current;
    }

}
