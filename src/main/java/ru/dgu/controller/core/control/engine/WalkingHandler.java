package ru.dgu.controller.core.control.engine;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.Switcher;
import ru.dgu.layer.Loupe;
import ru.dgu.core.exceptions.CallMethodException;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

class WalkingHandler extends MultiAdapter{
    private static boolean created = false;
    private final Switcher switcher;
    private int oldX, oldY;
    private Loupe loupe;

    WalkingHandler(Switcher switcher, Loupe loupe){
        if(created)
            throw new CallMethodException("WalkingHandler is already created");
        assert switcher != null;
        assert loupe != null;

        this.switcher = switcher;
        this.loupe = loupe;

        created = true;
    }

    //base control block
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
            switcher.setCurrent(EngineStore.getAdditionControl());
    }
    //end control block

    @Override
    public String toString() {
        return "Walking";
    }
}
