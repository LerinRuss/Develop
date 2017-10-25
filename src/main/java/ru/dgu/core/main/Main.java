package ru.dgu.core.main;

import ru.dgu.controler.TileTextureLoader;
import ru.dgu.model.Loupe;
import ru.dgu.model.map.MapByEnumArray;
import ru.dgu.model.map.TileByEnum;
import ru.dgu.view.gui.Drawer;
import ru.dgu.view.gui.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TileTextureLoader.load();

        for (TileByEnum tile : TileByEnum.values()) {
            tile.setTexture(TileTextureLoader.getTexture(tile));
        }

        final int width = 800, height = 600;
        Window window = Window.Builder.generate(width, height);
        final MapByEnumArray mapByEnumArray = new MapByEnumArray(10,10);
        final Loupe loupe = Loupe.create(100,100,200,200);
        final Drawer drawer = Drawer.create(mapByEnumArray,loupe,20);
        window.setVisible(true);

        Timer timer = new Timer(20, a -> {
            drawer.repaint();
            window.repaint(drawer);
        });
        timer.start();
    }
}
