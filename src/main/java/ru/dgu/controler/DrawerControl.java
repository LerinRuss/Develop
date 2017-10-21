package ru.dgu.controler;

import ru.dgu.view.gui.Drawer;

import javax.swing.*;

public class DrawerControl {
    private static boolean started;
    private DrawerControl(){}

    public static void start(Drawer drawer) throws StartException {
        if (started)
            throw new StartException("Drawer control already started");
        Timer timer = new Timer(20, (a) -> drawer.repaint());
        timer.start();
        started = true;
    }

}
