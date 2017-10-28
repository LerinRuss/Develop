package ru.dgu.model.types;

import ru.dgu.model.constants.Constants;
import ru.dgu.model.exceptions.ObjectOnTileException;
import ru.dgu.model.objects.AbstractObjectOnTile;
import ru.dgu.model.objects.environment.EnvironmentOperations;
import ru.dgu.model.objects.units.UnitOperations;

public enum ObjectType
{
    IMPERIAL_GUARD, TREE;
    public static AbstractObjectOnTile createObject(ObjectType type) throws ObjectOnTileException
    {
        switch (type){
            case TREE:{
                return EnvironmentOperations.createTree();
            }
            case IMPERIAL_GUARD:{
                return UnitOperations.createImperialGuard();
            }
            default:{
                throw new ObjectOnTileException(Constants.OBJECT_NOT_REALIZE);
            }
        }
    }
}
