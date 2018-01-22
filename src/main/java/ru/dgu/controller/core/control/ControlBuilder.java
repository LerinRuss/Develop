package ru.dgu.controller.core.control;

import ru.dgu.controller.Backbone;
import ru.dgu.controller.Changer;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.core.control.engine.EngineBuilder;
import ru.dgu.core.controller.Movable;
import ru.dgu.layer.Loupe;

public class ControlBuilder {

    private ControlBuilder(){}

    public static MultiAdapter create(final Movable movable,
                                      final Loupe loupe,
                                      final Changer changer){
        final MultiAdapter commonHandler = new CommonControl(movable);
        final MultiAdapter switcher = EngineBuilder.build(loupe, changer);
        final MultiAdapter backbone = new Backbone(commonHandler, switcher);
        return backbone;
    }
}
