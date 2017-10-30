package ru.dgu.model.objects.units;

import org.junit.Test;
import ru.dgu.model.objects.units.imperium.ImperialGuard;

import static org.junit.Assert.assertEquals;

public class UnitTest
{
    @Test
    public void unitDefenceTest()
    {
        Unit unit = new ImperialGuard();
        unit.setCurrentDefence(30);
        assertEquals(30,unit.getCurrentDefence());
    }
    @Test
    public void unitHealthPointTest(){
        Unit unit = new ImperialGuard();
        unit.setHealthPoint(10);
        assertEquals(10, unit.getHealthPoint());
    }
    @Test
    public void unitMoraleTest()
    {
        Unit unit = new ImperialGuard();
        unit.setMorale(90);
        assertEquals(90,unit.getCurrentMorale());
    }

}