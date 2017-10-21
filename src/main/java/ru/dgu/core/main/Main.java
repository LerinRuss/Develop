package ru.dgu.core.main;

import ru.dgu.controler.TileTextureLoader;
import ru.dgu.model.Loupe;
import ru.dgu.tiles.Map;
import ru.dgu.tiles.Tile;
import ru.dgu.view.gui.Drawer;
import ru.dgu.view.gui.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TileTextureLoader.load();

        for (Tile tile : Tile.values()) {
            tile.setTexture(TileTextureLoader.getTexture(tile));
        }

        final int width = 800, height = 600;
        Window window = Window.Builder.generate(width, height);
        final Map map = new Map(10,10);
        final Loupe loupe = Loupe.create(100,100,200,200);
        final Drawer drawer = Drawer.create(map,loupe,20);
        window.setVisible(true);

        Timer timer = new Timer(20, a -> {
            drawer.repaint();
            window.repaint(drawer);
        });
        timer.start();
    }
}
