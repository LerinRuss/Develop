package ru.dgu.core.exceptions;

/*
    thrown when method is been called invalid times.
 */
public class CallMethodException extends RuntimeException{

    public CallMethodException(String message) {
        super(message);
    }
}
