package ru.dgu.model.objects.units.imperium;

import ru.dgu.model.objects.units.Unit;
import ru.dgu.model.types.ObjectType;

public class ImperialGuard extends Unit
{
    private int healthpoint;
    private static final int ALL_HEALTH_POINT = 100;
    private static final int MAX_NUMBER_OF_WARRIOR = 9;
    private int currentNumberOfWarrior;
    private static final int NEAR_DAMAGE_UP = 15;
    private static final int NEAR_DAMAGE_DOWN = 10;
    private static final int DISTANCE_DAMAGE_UP = 50;
    private static final int DISTANCE_DAMAGE_DOWN = 30;
    private static final int SPEED = 1;
    private static final int DISTANCE_OF_VIEW = 5;
    private static final int DISTANCE_OF_SHOOT = 5;
    private static final int maxMorale = 100;
    private static final int maxDefence = 100;
    private int x;
    private int y;
    public boolean wasNearBattle;
    //Название - Отряд Имперских Гвардейцев
    //Количество здоровья - 100
    //Боевой дух - 100
    //Урон в дальнем бою - 30-50
    //Дальность атаки - 5
    //Урон в ближнем бою - 10-15
    //Броня - 20
    //Скорость - 1
    //Максимальное количество - 9
    public ImperialGuard(){
        setType(ObjectType.IMPERIAL_GUARD);
        setHealthpoint(ALL_HEALTH_POINT);
        currentNumberOfWarrior = MAX_NUMBER_OF_WARRIOR;
        setMorale(maxMorale);
        setCurrentDefence(maxDefence);
    }
}
