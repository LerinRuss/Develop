package ru.dgu.model.exceptions;

public class MapException extends ModelException
{
    public MapException()
    {
        super();
    }

    public MapException(String message)
    {
        super(message);
    }

    public MapException(Throwable cause)
    {
        super(cause);
    }

    public MapException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
