package ru.dgu.core.controler.key;

import ru.dgu.core.exceptions.CallMethodException;
import ru.dgu.model.map.tiles.TileType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyAdditionControl extends KeyAdapter {
    private static boolean created;
    private final Map<Integer, TileType> keys;

    private KeyAdditionControl(final Map<Integer, TileType> keys){
        this.keys = keys;
    }

    public static KeyAdditionControl create(final Map<Integer, TileType> keys){
        if(created)
            throw new CallMethodException("KeyAdditionControl is already created");

        final KeyAdditionControl keyAdditionControl = new KeyAdditionControl(keys);
        created = true;
        return keyAdditionControl;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        final TileType type = keys.get(code);
    }
}
