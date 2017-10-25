package ru.dgu.model.utils;

public class Pair<E>
{
    private E first;
    private E second;

    public Pair(E first, E second)
    {
        this.first = first;
        this.second = second;
    }

    public E getFirst()
    {
        return first;
    }

    public void setFirst(E first)
    {
        this.first = first;
    }

    public E getSecond()
    {
        return second;
    }

    public void setSecond(E second)
    {
        this.second = second;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?> pair = (Pair<?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;
    }

    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
