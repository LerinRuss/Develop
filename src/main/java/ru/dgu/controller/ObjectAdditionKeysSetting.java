package ru.dgu.controller;

import ru.dgu.model.types.ObjectType;

import java.util.Map;

/**
 * This interface represents setting for object addition control.
 * Supposedly, class implementing this interface is a cover of
 * {@link Map} where key is a Integer key code of keyboard and value is a appropriate object type.
 *
 * But some methods such as isEmpty are here for ease of use
 */
public interface ObjectAdditionKeysSetting {
    boolean hasSwitched(int keyCode);
    boolean isEmpty();
    Map<Integer, ObjectType> getObjectKeysSetting();
    ObjectType get(int keyCode);
}
