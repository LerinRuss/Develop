package ru.dgu.controller.core.control.engine;

import ru.dgu.controller.KeySettingsStore;
import ru.dgu.controller.MapPutting;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.core.control.engine.addition.AdditionBuilder;
import ru.dgu.layer.Loupe;

public class EngineBuilder {

    public static MultiAdapter build(Loupe loupe, MapPutting mapPutting, KeySettingsStore store) {
        final EngineControl engineControl = new EngineControl();

        final MultiAdapter walkingHandler = new WalkingHandler(engineControl, loupe);
        final MultiAdapter additionControl = AdditionBuilder.build(mapPutting, store);

        EngineStore.setWalkingHandler(walkingHandler);
        EngineStore.setAdditionControl(additionControl);

        engineControl.setCurrent(walkingHandler);

        return engineControl;
    }

    private EngineBuilder() {}
}
