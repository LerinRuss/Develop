package ru.dgu.controller;

import ru.dgu.model.types.ObjectType;

import java.util.Map;

public interface ObjectAdditionKeysSetting {
    boolean hasSwitched(int keyCode);
    boolean isEmpty();
    Map<Integer, ObjectType> getObjectKeysSetting();
    ObjectType get(int keyCode);
}
