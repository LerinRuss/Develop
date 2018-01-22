package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.Changer;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.core.control.engine.AdditionControl;

public class AdditionBuilder {
    private AdditionBuilder() {}

    public static MultiAdapter build(Changer changer) {
        final AdditionControl additionControl = new AdditionControl();
        final MultiAdapter objectTypeChangingHandler = new ObjectTypeChangingHandler(additionControl, changer);
        final MultiAdapter tileTypeAdditionHandler = new TileTypeAdditionHandler(additionControl, changer);

        AdditionStore.setObjectTypeChangingHandler(objectTypeChangingHandler);
        AdditionStore.setTileTypeAdditionHandler(tileTypeAdditionHandler);

        additionControl.setCurrent(tileTypeAdditionHandler);

        return additionControl;
    }
}
