package ru.dgu.controler;

import ru.dgu.model.map.tiles.TileType;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class KeyControl implements KeyListener {
    private final Map<Integer, TileType> keys;

    public KeyControl(final Map<Integer, TileType> keys){
        this.keys = keys;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        final TileType type = keys.get(code);
        MouseControl.type = type;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
