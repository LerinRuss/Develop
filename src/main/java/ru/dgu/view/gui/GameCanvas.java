package ru.dgu.view.gui;

import java.awt.*;

public class GameCanvas extends Canvas {

    private final Graphics saved;

    private GameCanvas(){
        final int width = getWidth();
        final int height = getHeight();

        if(!isDoubleBuffered()){
            final Image image = createImage(width, height);
            saved = image.getGraphics();
            return;
        }
        saved = getGraphics();
    }
    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
