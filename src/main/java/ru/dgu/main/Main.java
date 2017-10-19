package ru.dgu.main;

import ru.dgu.gui.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final int width = 800, height = 600;

        JFrame jf = Window.Builder.generate(width, height);
        jf.setVisible(true);
    }
}
