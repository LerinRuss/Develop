package ru.dgu.model.objects.units.imperium;

import ru.dgu.model.objects.units.Unit;

import java.awt.image.BufferedImage;

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
    public boolean wasNearBattle;
    private BufferedImage texture;
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
        setHealthPoint(ALL_HEALTH_POINT);
        currentNumberOfWarrior = MAX_NUMBER_OF_WARRIOR;
        setMorale(maxMorale);
        setCurrentDefence(maxDefence);
    }

    @Override
    public String toString()
    {
        return "ImperialGuard{" +
                "healthpoint=" + healthpoint +
                ", numberOfWarrior=" + currentNumberOfWarrior +
                ", wasNearBattle=" + wasNearBattle +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImperialGuard that = (ImperialGuard) o;

        if (healthpoint != that.healthpoint) return false;
        if (currentNumberOfWarrior != that.currentNumberOfWarrior) return false;
        return wasNearBattle == that.wasNearBattle;
    }

    @Override
    public int hashCode()
    {
        int result = healthpoint;
        result = 31 * result + currentNumberOfWarrior;
        result = 31 * result + (wasNearBattle ? 1 : 0);
        return result;
    }

    @Override
    public BufferedImage getTexture()
    {
        return texture;
    }

    @Override
    public void setTexture(BufferedImage texture)
    {
        this.texture = texture;
    }
}
