package ru.dgu.core.main;

import ru.dgu.controler.Dispatcher;
import ru.dgu.core.controler.key.KeyAdditionControl;
import ru.dgu.controler.workSpace.MouseControl;
import ru.dgu.core.loaders.TileTextureLoader;
import ru.dgu.core.controler.KeySetting;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.modelcore.ModelCore;
import ru.dgu.core.controler.Accentuation;
import ru.dgu.core.controler.Loupe;
import ru.dgu.view.gui.MapLoupeDrawer;
import ru.dgu.view.gui.Window;

import javax.swing.*;

public class Main {
    public final static int TILE_SIZE = 20;
    public static void main(String[] args) {
        final int mapSize = 60;

        loadTextures();
        //final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        //final int width = (int)size.getHeight(), height = (int) size.getHeight();
        final int width = 600, height = 600;
        final Accentuation accentuation = Accentuation.create(TILE_SIZE);
        final Loupe loupe = Loupe.create(width/2,height/2,width,width);
        final Window window = createWindow(width, height, loupe, accentuation, mapSize);
        ModelCore.createMap(mapSize);
        final MapLoupeDrawer mapLoupeDrawer = MapLoupeDrawer.create(mapSize,loupe,20);
        mapLoupeDrawer.setAccentuation(accentuation);
        window.setVisible(true);

        Timer timer = new Timer(20, a -> {
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

    private static Window createWindow(final  int width, final int height, final Loupe loupe,
                                       final Accentuation accentuation, final int mapSize){
        final Window window = Window.Builder.generate(width, height);
        final KeyAdditionControl keyAdditionControl = KeyAdditionControl.create(KeySetting.getTileTypeKeysSetting());
        final MouseControl mouseControl = Dispatcher.initMouseControl(loupe);
        window.addMouseWheelListener(mouseControl);
        window.addMouseListener(mouseControl);
        window.addMouseMotionListener(mouseControl);
        window.addKeyListener(keyAdditionControl);
        window.setUndecorated(true);
        return window;
    }
}
