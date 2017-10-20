package ru.dgu.view.gui;

import javax.swing.*;

public class Window extends JFrame{
    public Window(final int width, final int height) {
        super("Engine");
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
