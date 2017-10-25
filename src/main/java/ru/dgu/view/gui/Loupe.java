package ru.dgu.view.gui;

public class Loupe {
    private static Loupe loupe;

    private final int width, height;
    private int x, y;

    private Loupe(final int x, final int y, final int width, final int height){
        setX(x);
        setY(y);
        this.width = width;
        this.height = height;
    }
    public static Loupe create(final int x, final int y, final int width, final int height) {
        return loupe == null ? loupe = new Loupe(x, y, width, height) : loupe;
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
}
