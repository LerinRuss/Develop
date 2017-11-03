package ru.dgu.controller;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Backbone extends MultiAdapter {

    private final MultiAdapter cervicalVertebra;
    private final MultiAdapter vertebra;

    public Backbone(final MultiAdapter vertebra,
                    final MultiAdapter cervicalVertebra){
        this.vertebra = vertebra;
        this.cervicalVertebra = cervicalVertebra;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        vertebra.keyTyped(e);
        cervicalVertebra.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        vertebra.keyPressed(e);
        cervicalVertebra.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        vertebra.keyReleased(e);
        cervicalVertebra.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        vertebra.mouseClicked(e);
        cervicalVertebra.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        vertebra.mousePressed(e);
        cervicalVertebra.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        vertebra.mouseReleased(e);
        cervicalVertebra.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vertebra.mouseEntered(e);
        cervicalVertebra.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vertebra.mouseExited(e);
        cervicalVertebra.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        vertebra.mouseWheelMoved(e);
        cervicalVertebra.mouseWheelMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        vertebra.mouseDragged(e);
        cervicalVertebra.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        vertebra.mouseMoved(e);
        cervicalVertebra.mouseMoved(e);
    }

    @Override
    public String toString() {
        return cervicalVertebra.toString();
    }
}
