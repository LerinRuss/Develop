package ru.dgu.utils.coordinates;

import ru.dgu.utils.coordinates.IntegerCoordinates;

public class Transfer {
    private Transfer(){}

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
