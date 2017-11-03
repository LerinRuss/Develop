package ru.dgu.core;

import ru.dgu.controller.MultiAdapter;
import ru.dgu.core.controller.Accentuation;
import ru.dgu.core.controller.Dispatcher;
import ru.dgu.core.controller.Loupe;
import ru.dgu.core.loaders.TileTextureLoader;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.modelcore.ModelCore;
import ru.dgu.view.gui.MapLoupeDrawer;
import ru.dgu.view.gui.Window;

import javax.swing.*;

public class Main {
    public final static int TILE_SIZE = 20;
    private static Object toString;
    public static void main(String[] args) {
        final int mapSize = 60;

        loadTextures();
        final int width = 600, height = 600;
        final Loupe loupe = Loupe.create(width/2,height/2,width,width);
        final Accentuation accentuation = Accentuation.create(TILE_SIZE);
        final Window window = createWindow(width, height,loupe,accentuation);
        ModelCore.createMap(mapSize);
        final MapLoupeDrawer mapLoupeDrawer = MapLoupeDrawer.create(mapSize,loupe,20);
        mapLoupeDrawer.setAccentuation(accentuation);
        window.setVisible(true);

        Timer timer = new Timer(20, a -> {
            System.out.println(toString.toString());
            mapLoupeDrawer.repaint();
            window.repaint(mapLoupeDrawer, mapSize);
        });
        timer.start();

    }

    private static void loadTextures(){
        TileTextureLoader.load(TILE_SIZE);

        for (TileType tile : TileType.values()) {
            tile.setTexture(TileTextureLoader.getTexture(tile));
        }
    }

    private static Window createWindow(final  int width, final int height, final Loupe loupe, final Accentuation accentuation){
        final Window window = Window.Builder.generate(width, height);

        final MultiAdapter multiAdapter = Dispatcher.create(ModelCore.init(), loupe, accentuation, TILE_SIZE);

        toString = multiAdapter;

        window.setFocusTraversalKeysEnabled(false);

        window.addKeyListener(multiAdapter);
        window.addMouseListener(multiAdapter);
        window.addMouseMotionListener(multiAdapter);
        window.addMouseWheelListener(multiAdapter);

        window.setUndecorated(true);
        return window;
    }
}
