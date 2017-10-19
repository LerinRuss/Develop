package ru.dgu.gui;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame{
    private final BufferedImage desk;

    public Window(final int width, final int height) {
        super("Engine");
        desk = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public static class Builder{
        public static JFrame generate(final int width, final int height){
            JFrame window = new Window(width, height);
            window.setSize(width,height);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return window;
        }
    }
}
