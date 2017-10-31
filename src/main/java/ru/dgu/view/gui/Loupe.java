package ru.dgu.view.gui;

import ru.dgu.core.controler.Scrollable;
import ru.dgu.core.exceptions.CallMethodException;

public class Loupe implements Scrollable {
    private int width, height;
    private int x, y;
    private static boolean generated;

    private Loupe(final int x, final int y, final int width, final int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }
    public static Loupe create(final int x, final int y, final int width, final int height) {
        if(generated)
            throw new CallMethodException("Loupe is already generated");
        final Loupe loupe = new Loupe(x, y, width, height);
        generated = true;
        return loupe;
    }

    public void resize(final int delta){
        setWidth(getWidth() + delta + delta);
        setHeight(getHeight() + delta + delta);
    }

    public void move(final int dx, final int dy){
        addX(dx);
        addY(dy);
    }

    public void addX(final int dx){
        setX(getX() + dx);
    }

    public void addY(final int dy){
        setY(getY() + dy);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Loupe{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
