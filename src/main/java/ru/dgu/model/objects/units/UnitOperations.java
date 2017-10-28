package ru.dgu.model.objects.units;


import ru.dgu.model.map.tiles.Tile;
import ru.dgu.model.objects.units.imperium.ImperialGuard;

public class UnitOperations
{
    private UnitOperations()
    {
    }

    /**
    * Return true if and only if unit can go through
    * @param unit - unit
    * @param tile - tile for check
    * @return boolean answer
    */
    public boolean isPassable(Unit unit, Tile tile)
    {
        return true;//Пока будем считать, что все юниты могут ходить по всем тайлам
        //return unit.
    }
    public static Unit createImperialGuard(){
        return new ImperialGuard();
    }
}
