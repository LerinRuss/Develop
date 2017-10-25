package ru.dgu.model.units;


import ru.dgu.model.map.tiles.TileType;

/**
 * Created by Erlan on 23.11.2016.
 */
public abstract class Unit
{
    private int healthpoint;
    private int allhealthpoint;
    private int maxNumberOfWarrior;
    private int currentNumberOfWarrior;
    private int nearDamageUp;
    private int nearDamageDown;
    private int distanceDamageUp;
    private int distanceDamageDown;
    private int speed;
    private int distanceOfView;
    private int distanceOfShoot;
    private int morale;
    private int defence;
    private int x;
    private int y;
    public boolean wasNearBattle;



    public int distance(Unit a)
    {
        return Math.max(Math.abs(this.x - a.x), Math.abs(this.y - a.y));
    }

    public int distance(int x, int y)
    {
        return Math.max(Math.abs(x - this.x), Math.abs(y - this.y));
    }

    public boolean checkShoot(int x, int y)
    {
        return distance(x, y) < distanceOfShoot;
    }

    public int getHealthpoint()
    {
        return healthpoint;
    }

    public void setHealthpoint(int healthPoint)
    {
        this.healthpoint = healthPoint;
    }

    public int getMorale()
    {
        return morale;
    }

    public void setMorale(int morale)
    {
        this.morale = morale;
    }

    public int getDefence()
    {
        return defence;
    }

    public void setDefence(int defence)
    {
        this.defence = defence;
    }

    public abstract boolean movableTile(TileType type);
}
