package ru.dgu.core.controler;

import java.awt.event.*;
import java.util.Collections;
import java.util.List;

public class MouseGroup extends MouseAdapter{
    private final List<MouseListener> mouseListeners;
    private final List<MouseMotionListener> mouseMotionListeners;
    private final List<MouseWheelListener> mouseWheelListeners;

    public MouseGroup(final List<MouseListener> mouseListeners,
                      final List<MouseMotionListener> mouseMotionListeners,
                      final List<MouseWheelListener> mouseWheelListeners) {
        this.mouseListeners = mouseListeners == null ? Collections.emptyList() : Collections.unmodifiableList(mouseListeners);
        this.mouseMotionListeners = mouseMotionListeners == null ? Collections.emptyList()
                : Collections.unmodifiableList(mouseMotionListeners);
        this.mouseWheelListeners = mouseWheelListeners == null ?
                Collections.emptyList() : Collections.unmodifiableList(mouseWheelListeners);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (MouseListener mouseListener : mouseListeners) {
            mouseListener.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MouseListener mouseListener : mouseListeners) {
            mouseListener.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MouseListener mouseListener : mouseListeners) {
            mouseListener.mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (MouseListener mouseListener : mouseListeners) {
            mouseListener.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (MouseListener mouseListener : mouseListeners) {
            mouseListener.mouseExited(e);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        for (MouseWheelListener mouseWheelListener : mouseWheelListeners) {
            mouseWheelListener.mouseWheelMoved(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (MouseMotionListener mouseMotionListener : mouseMotionListeners) {
            mouseMotionListener.mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MouseMotionListener mouseMotionListener : mouseMotionListeners) {
            mouseMotionListener.mouseMoved(e);
        }
    }

}
