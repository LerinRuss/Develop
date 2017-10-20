package ru.dgu.controler;

import javax.swing.*;

public class DrawControl{
    private DrawControl(){}

    public static void start(Painted picture){
        Timer timer = new Timer(20, (a) -> picture.repaint());
        timer.start();
    }

    private interface Painted {
        void repaint();
    }
}
