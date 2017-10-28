package ru.dgu.utils.coordinates;

import ru.dgu.utils.coordinates.IntegerCoordinates;

public class Transfer {
    private Transfer(){}

    public static IntegerCoordinates transferCoordinates(final int tileSize, final int x, final int y){
        return new IntegerCoordinates() {
            @Override
            public int getX() {
                return x/tileSize;
            }

            @Override
            public int getY() {
                return y/tileSize;
            }
        };
    }
    public static IntegerCoordinates transferCoordinates(final int tileSize, final float x, final float y){
        return new IntegerCoordinates() {
            @Override
            public int getX() {
                return (int) (x/tileSize);
            }

            @Override
            public int getY() {
                return (int) (y/tileSize);
            }
        };
    }
}
