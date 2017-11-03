package ru.dgu.utils.coordinates;

import ru.dgu.core.controller.Loupe;

public class Transfer {
    private Transfer(){}

    public static IntegerCoordinates transferLoupeCoordinates(final Loupe loupe, final int x, final int y){
        final int startX = loupe.getX() - (loupe.getWidth() >> 1);
        final int startY = loupe.getY() - (loupe.getHeight() >> 1);
        final int resultX = startX + x;
        final int resultY = startY + y;
        return new IntegerCoordinates() {
            @Override
            public int getX() {
                return resultX;
            }

            @Override
            public int getY() {
                return resultY;
            }
        };
    }

    public static IntegerCoordinates transferCoordinates(final int tileSize, final IntegerCoordinates coordinates){
        return transferCoordinates(tileSize, coordinates.getX(), coordinates.getY());
    }

    public static IntegerCoordinates transferCoordinates(final int tileSize, final int x, final int y){
        final int xx = x/tileSize;
        final int yy = y/tileSize;
        return new IntegerCoordinates() {
            @Override
            public int getX() {
                return xx;
            }

            @Override
            public int getY() {
                return yy;
            }
        };
    }
    public static IntegerCoordinates transferCoordinates(final int tileSize, final float x, final float y){
        final int xx = (int) (x/tileSize);
        final int yy = (int) (y/tileSize);
        return new IntegerCoordinates() {
            @Override
            public int getX() {
                return xx;
            }

            @Override
            public int getY() {
                return yy;
            }
        };
    }
}
