package ru.dgu.view.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Temp extends JPanel {
    private Queue<Drawable> list = new LinkedList<>();

    private Temp(int width, int height) {
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        if(list.isEmpty())
            Thread.yield();

        Drawable drawable;
        while ((drawable = list.poll()) != null) {
            drawable.draw(g);
        }
    }

    private void add(Drawable drawable) {
        list.add(drawable);
    }
}
