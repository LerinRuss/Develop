package ru.dgu.model.exceptions;

public class ObjectOnTileException extends ModelException
{
    public ObjectOnTileException()
    {
        super();
    }

    public ObjectOnTileException(String message)
    {
        super(message);
    }

    public ObjectOnTileException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ObjectOnTileException(Throwable cause)
    {
        super(cause);
    }
}
