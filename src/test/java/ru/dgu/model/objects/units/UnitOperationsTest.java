package ru.dgu.model.objects.units;

import org.junit.Test;
import ru.dgu.model.objects.units.imperium.ImperialGuard;

import static org.junit.Assert.assertEquals;

public class UnitOperationsTest
{
    @Test
    public void createImperialGuardTest() throws Exception
    {
        assertEquals(new ImperialGuard(), UnitOperations.createImperialGuard());
    }
}