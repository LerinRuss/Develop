package ru.dgu.controller.core.control.engine;

import ru.dgu.controller.MultiAdapter;

public class EngineStore {

    private static MultiAdapter walkingHandler;
    private static MultiAdapter additionControl;

    static MultiAdapter getWalkingHandler() {
        assert walkingHandler != null;

        return walkingHandler;
    }

    static MultiAdapter getAdditionControl() {
        assert additionControl != null;

        return additionControl;
    }

    static void setWalkingHandler(MultiAdapter adapter) {
        assert walkingHandler == null;

        walkingHandler = adapter;
    }

    static void setAdditionControl(MultiAdapter adapter) {
        assert additionControl == null;

        additionControl = adapter;
    }

    private EngineStore() {}

}
