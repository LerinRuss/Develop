package ru.dgu.core.controler.mouse;

import ru.dgu.view.gui.Loupe;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseScaleControl implements MouseWheelListener {
    private Loupe loupe;


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        loupe.resize(e.getWheelRotation() << 5);
    }
}
