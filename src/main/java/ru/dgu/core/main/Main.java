package ru.dgu.core.main;

import ru.dgu.controler.KeyControl;
import ru.dgu.controler.MouseControl;
import ru.dgu.controler.TileTextureLoader;
import ru.dgu.core.settings.KeySetting;
import ru.dgu.model.map.MapByEnumArray;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.view.gui.Accentuation;
import ru.dgu.view.gui.Loupe;
import ru.dgu.view.gui.MapLoupeDrawer;
import ru.dgu.view.gui.Window;

import javax.swing.*;

public class Main {
    public final static int TILE_SIZE = 20;
    public static void main(String[] args) {
        final int mapSize = 60;

        loadTextures();

        final int width = 600, height = 600;
        final Accentuation accentuation = Accentuation.create(TILE_SIZE);
        final Loupe loupe = Loupe.create(width/2,height/2,width,width);
        final Window window = createWindow(width, height, loupe, accentuation, mapSize);
        final MapByEnumArray mapByEnumArray = new MapByEnumArray(mapSize);
        final MapLoupeDrawer mapLoupeDrawer = MapLoupeDrawer.create(mapByEnumArray,loupe,20);
        mapLoupeDrawer.setAccentuation(accentuation);
        window.setVisible(true);

        Timer timer = new Timer(20, a -> {
            mapLoupeDrawer.repaint();
            window.repaint(mapLoupeDrawer, mapByEnumArray);
        });
        timer.start();

    }

    private static void loadTextures(){
        TileTextureLoader.load(TILE_SIZE);

        for (TileType tile : TileType.values()) {
            tile.setTexture(TileTextureLoader.getTexture(tile));
        }
    }

    private static Window createWindow(final  int width, final int height, final Loupe loupe,
                                       final Accentuation accentuation, final int mapSize){
        final Window window = Window.Builder.generate(width, height);
        final MouseControl mouseControl = new MouseControl(loupe, accentuation, mapSize);
        final KeyControl keyControl = new KeyControl(KeySetting.getKeysSetting());
        window.addMouseWheelListener(mouseControl);
        window.addMouseMotionListener(mouseControl);
        window.addMouseListener(mouseControl);
        window.addKeyListener(keyControl);
        window.setUndecorated(true);
        return window;
    }
}
