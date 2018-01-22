package ru.dgu.controller.core.control.engine;

import ru.dgu.controller.Changer;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.core.control.engine.addition.AdditionBuilder;
import ru.dgu.layer.Loupe;

public class EngineBuilder {

    public static MultiAdapter build(Loupe loupe, Changer changer) {
        final EngineControl engineControl = new EngineControl();

        final MultiAdapter walkingHandler = new WalkingHandler(engineControl, loupe);
        final MultiAdapter additionControl = AdditionBuilder.build(changer);

        EngineStore.setWalkingHandler(walkingHandler);
        EngineStore.setAdditionControl(additionControl);

        engineControl.setCurrent(walkingHandler);

        return engineControl;
    }

    private EngineBuilder() {}
}
