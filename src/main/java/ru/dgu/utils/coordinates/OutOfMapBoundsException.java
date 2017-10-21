package ru.dgu.utils.coordinates;

public class OutOfMapBoundsException extends RuntimeException {
    public OutOfMapBoundsException(String message) {
        super(message);
    }
}
