package ru.dgu.controller;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Arrays;

/**
 * This class is constant of an array of MultiAdapters.
 * Every array element will be called in the order in which it is in the array.
 */
public class Backbone extends MultiAdapter {

    private final MultiAdapter[] vertebrae;

    public Backbone(MultiAdapter... vertebrae) {
        this.vertebrae = Arrays.copyOf(vertebrae, vertebrae.length);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.keyTyped(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.keyReleased(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseExited(e);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseWheelMoved(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MultiAdapter vertebra : vertebrae) {
            vertebra.mouseMoved(e);
        }
    }
}
