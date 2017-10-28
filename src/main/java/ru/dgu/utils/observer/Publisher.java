package ru.dgu.utils.observer;

public interface Publisher
{
    void subscribe(Subscriber subscriber);
    void ubsubscribe(Subscriber subscriber);
}
