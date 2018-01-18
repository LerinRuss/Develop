package ru.dgu.layer;

import ru.dgu.core.controller.Movable;
import ru.dgu.core.exceptions.CallMethodException;
import ru.dgu.utils.coordinates.IntegerCoordinates;

import java.awt.*;

public class Accentuation implements Movable {
    private int x, y;
    private final int size;
    private static boolean generated;

    private Accentuation(final int size){
        this.size = size;
    }

    public static Accentuation create(final int size){
        if(generated)
            throw new CallMethodException("Accentuation is already generated");
        final Accentuation accentuation = new Accentuation(size);
        generated = true;
        return accentuation;
    }

    public void paint(Graphics g){
        final Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(x  * size, y * size, size, size);
        g.setColor(color);
    }

    public void move(final IntegerCoordinates coordinates){
        move(coordinates.getX(), coordinates.getY());
    }
    public void move(final int x, final int y){
        setX(x);
        setY(y);
    }

    private void setX(final int x){
        this.x = x;
    }
    private void setY(final int y){
        this.y = y;
    }
}
