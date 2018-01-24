package ru.dgu.controller.core.control;

import ru.dgu.controller.Backbone;
import ru.dgu.controller.KeySettingsStore;
import ru.dgu.controller.MapPutting;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.core.control.engine.EngineBuilder;
import ru.dgu.core.controller.Movable;
import ru.dgu.layer.Loupe;

public class ControlBuilder {

    private ControlBuilder(){}

    public static MultiAdapter create
            (Movable movable, Loupe loupe, MapPutting mapPutting, KeySettingsStore store){

        final MultiAdapter commonHandler = new CommonControl(movable);
        final MultiAdapter switcher = EngineBuilder.build(loupe, mapPutting, store);
        return new Backbone(commonHandler, switcher);
    }
}
