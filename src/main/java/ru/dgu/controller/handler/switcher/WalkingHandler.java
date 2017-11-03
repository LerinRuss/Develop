package ru.dgu.controller.handler.switcher;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.core.controller.Loupe;
import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

class WalkingHandler extends MultiAdapter{
    private static boolean created = false;
    private int oldX, oldY;
    private Loupe loupe;

    WalkingHandler(final Loupe loupe){
        if(created)
            throw new CallMethodException("WalkingHandler is already created");
        this.loupe = loupe;

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

        loupe.move(dx, dy);

        oldX = e.getX();
        oldY = e.getY();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_TAB)
            Switcher.setCurrent(Switcher.getAdditionHandler());
    }

    @Override
    public String toString() {
        return "Walking";
    }
}
