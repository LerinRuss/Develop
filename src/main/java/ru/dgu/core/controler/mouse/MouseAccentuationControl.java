package ru.dgu.core.controler.mouse;

import ru.dgu.core.exceptions.CallMethodException;
import ru.dgu.core.main.Main;
import ru.dgu.model.utils.Transfer;
import ru.dgu.model.utils.coordinates.IntegerCoordinates;
import ru.dgu.view.gui.Accentuation;
import ru.dgu.view.gui.Loupe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAccentuationControl extends MouseAdapter {
    private static boolean created = false;
    private final Accentuation accentuation;
    private final Loupe loupe;
    private final int mapSize;

    private MouseAccentuationControl(final Loupe loupe, final Accentuation accentuation, final int mapSize){
        this.accentuation = accentuation;
        this.loupe = loupe;
        this.mapSize = mapSize;
    }

    public static MouseAccentuationControl create(final Loupe loupe, final Accentuation accentuation, final int mapSize){
        if(created)
            throw new CallMethodException("MouseAccentuationControl is already exist");
        final MouseAccentuationControl control = new MouseAccentuationControl(loupe, accentuation, mapSize);
        created = true;
        return control;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        final int x = loupe.getX() - loupe.getWidth()/2 + e.getX();
        final int y = loupe.getY() - loupe.getHeight()/2 + e.getY();
        IntegerCoordinates coordinates = Transfer.transferCoordinates(Main.TILE_SIZE, x,y);
        if(coordinates.getX() < 0 || coordinates.getX() >= mapSize)
            return;
        if(coordinates.getY() < 0 || coordinates.getY() >= mapSize)
            return;

        accentuation.translate(coordinates);
    }
}
