package ru.dgu.view.gui;

import ru.dgu.core.Main;
import ru.dgu.layer.Loupe;
import ru.dgu.core.exceptions.CallMethodException;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    private final Loupe loupe;

    public Window(Loupe loupe) {
        super("Engine");
        this.loupe = loupe;
    }

    public void repaint(final MapLoupeDrawer desk,final int size) {
        //super.repaint();
        Graphics g = getGraphics();
        final int luX = loupe.getX() - getWidth()/2;
        final int luY = loupe.getY() - getHeight()/2;
        final int rdX = loupe.getX() + loupe.getWidth()/2;
        final int rdY = loupe.getY() + loupe.getHeight()/2;

        paintBorder(g, size, luX, luY, rdX, rdY);

        g.drawImage(
                desk,
                0,0, getWidth(), getHeight(),
                luX, luY, rdX,rdY,
                null
        );
    }

    private void paintBorder(final Graphics g, final int size,
                             final int luX, final int luY,
                             final int rdX, final int rdY) {

        final Color oldColor = g.getColor();
        final Color color = Color.BLACK;
        g.setColor(color);

//        g.fillRect(0,0,getWidth(),getHeight());
        g.fillRect(0,0,getWidth(),-luY);
        g.fillRect(0, 0, -luX, getHeight());
        final int x = getWidth() - (rdX - size * Main.TILE_SIZE);
        if(x > 0)
            g.fillRect(x, 0, getWidth() - x, getHeight());
        final int y = getHeight() - (rdY - size * Main.TILE_SIZE);
        if(y > 0)
            g.fillRect(0, y, getWidth(), getHeight() - y);

        g.setColor(oldColor);
    }

    public static class Builder{
        private static boolean generated;
        public static Window generate(Loupe loupe, final int width, final int height){
            if(generated)
                throw new CallMethodException("Window is already generated");
            Window window = new Window(loupe);
            window.setSize(width,height);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            generated = true;

            return window;
        }
    }
}
