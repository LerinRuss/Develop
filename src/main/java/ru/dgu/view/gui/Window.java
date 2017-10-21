package ru.dgu.view.gui;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame{
    public Window() {
        super("Engine");
    }

    public void repaint(BufferedImage desk){
        //super.repaint();
        getGraphics().drawImage(desk,0,0, getWidth(), getHeight(), null);
    }

    public static class Builder{
        public static Window generate(final int width, final int height){
            Window window = new Window();
            window.setSize(width,height);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return window;
        }
    }
}
