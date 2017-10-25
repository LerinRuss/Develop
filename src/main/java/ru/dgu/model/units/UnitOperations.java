package ru.dgu.model.units;


import ru.dgu.model.map.tiles.Tile;

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
    }

}
