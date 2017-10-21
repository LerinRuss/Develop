package ru.dgu.model.utils.coordinates;

public class OutOfMapBoundsException extends RuntimeException {
    public OutOfMapBoundsException(String message) {
        super(message);
    }
}
