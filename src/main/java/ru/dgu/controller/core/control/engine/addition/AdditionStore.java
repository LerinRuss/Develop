package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.MultiAdapter;

public class AdditionStore {
    private static MultiAdapter objectTypeChangingHandler;
    private static MultiAdapter tileTypeAdditionHandler;

    static MultiAdapter getObjectTypeChangingHandler(){
        assert objectTypeChangingHandler != null;

        return objectTypeChangingHandler;
    }

    static MultiAdapter getTileTypeAdditionHandler() {
        assert tileTypeAdditionHandler != null;

        return tileTypeAdditionHandler;
    }

    static void setObjectTypeChangingHandler(MultiAdapter handler) {
        assert objectTypeChangingHandler == null;

        objectTypeChangingHandler = handler;
    }

    static void setTileTypeAdditionHandler(MultiAdapter handler) {
        assert tileTypeAdditionHandler == null;

        tileTypeAdditionHandler = handler;
    }

    private AdditionStore() {}
}
