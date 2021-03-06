package ru.dgu.model.objects.units;


import ru.dgu.model.objects.AbstractObjectOnTile;

/**
 * Created by Erlan on 23.11.2016.
 */
public abstract class Unit extends AbstractObjectOnTile
{
    private int healthPoint;
    //int allhealthpoint;
    //int maxNumberOfWarrior;
    private int currentNumberOfWarrior;
    //int nearDamageUp;
    //int nearDamageDown;
    //int distanceDamageUp;
    //int distanceDamageDown;
    //int speed;
    //int distanceOfView;
    //int distanceOfShoot;
    //int maxMorale;
    private int currentMorale;
    //int maxDefence;
    private int currentDefence;
    public boolean wasNearBattle;

    public int getHealthPoint()
    {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint)
    {
        this.healthPoint = healthPoint;
    }

    public int getCurrentMorale()
    {
        return currentMorale;
    }

    public void setMorale(int morale)
    {
        this.currentMorale = morale;
    }

    public int getCurrentDefence()
    {
        return currentDefence;
    }

    public void setCurrentDefence(int currentDefence)
    {
        this.currentDefence = currentDefence;
    }
}
