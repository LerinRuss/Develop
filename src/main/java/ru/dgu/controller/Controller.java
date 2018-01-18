package ru.dgu.controller;

import ru.dgu.controller.handler.CommonHandler;
import ru.dgu.controller.handler.switcher.Switcher;
import ru.dgu.layer.Loupe;
import ru.dgu.core.controller.Movable;

public class Controller {

    private Controller(){}

    public static MultiAdapter create(final Movable movable,
                                      final Loupe loupe,
                                      final Changer changer){
        final MultiAdapter commonHandler = new CommonHandler(movable);
        final MultiAdapter switcher = new Switcher(loupe, changer);
        final MultiAdapter backbone = new Backbone(commonHandler, switcher);
        return backbone;
    }
}
