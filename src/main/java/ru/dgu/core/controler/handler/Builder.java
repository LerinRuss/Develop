package ru.dgu.core.controler.handler;

import ru.dgu.controler.MultiAdapter;
import ru.dgu.controler.Switcher;
import ru.dgu.core.controler.Changer;
import ru.dgu.core.controler.mouse.*;
import ru.dgu.core.exceptions.CallMethodException;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.util.Map;

public class Builder {
    private static boolean built = false;

    private Builder() {
    }

    public static ControlsStorage build(final Scalable scalable,
                                final CursorMovable cursorMovable,
                                final Scrollable scrollable,
                                final Switcher switcher,
                                final Changer changer,
                                final Map<Integer, TileType> tileTypeMap,
                                final Map<Integer, ObjectType> objectTypeMap) {
        if (built)
            throw new CallMethodException("method build was called");

        final MouseScaleControl mouseScaleControl = new MouseScaleControl(scalable);
        final MouseMoveControl mouseMoveControl = new MouseMoveControl(cursorMovable);
        final MouseScrolling mouseScrolling = new MouseScrolling(scrollable);

        final MultiAdapter walkingControl = new WalkingControl(
                mouseScaleControl,
                mouseMoveControl,
                mouseScrolling,
                switcher);

        final MultiAdapter additionControl = new AdditionControl(
                mouseScaleControl,
                mouseMoveControl,
                switcher,
                changer,
                tileTypeMap,
                objectTypeMap
        );
        final ControlsStorage storage = new ControlsStorage(walkingControl, additionControl);
        built = true;
        return storage;
    }

    public static class ControlsStorage {
        private final MultiAdapter walkingControl, additionControl;

        private ControlsStorage(MultiAdapter walkingControl, MultiAdapter additionControl) {
            this.walkingControl = walkingControl;
            this.additionControl = additionControl;
        }

        public MultiAdapter getWalkingControl() {
            return walkingControl;
        }

        public MultiAdapter getAdditionControl() {
            return additionControl;
        }
    }
}
