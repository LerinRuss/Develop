package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.KeySettingsStore;
import ru.dgu.controller.MapPutting;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.core.control.engine.AdditionControl;

public class AdditionBuilder {
    private AdditionBuilder() {}

    public static MultiAdapter build(MapPutting mapPutting, KeySettingsStore keySettingsStore) {

        final AdditionControl addControl = new AdditionControl();
        final MultiAdapter objectAdder = new ObjectAdditionHandler
                (addControl, mapPutting, keySettingsStore.getObjectAdditionKeysSetting());
        final MultiAdapter tileAdder = new TileAdditionHandler
                (addControl, mapPutting, keySettingsStore.getTileAdditionKeysSetting());

        AdditionStore.setObjectTypeChangingHandler(objectAdder);
        AdditionStore.setTileTypeAdditionHandler(tileAdder);

        addControl.setCurrent(tileAdder);

        return addControl;
    }
}
