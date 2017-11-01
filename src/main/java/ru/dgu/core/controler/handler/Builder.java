package ru.dgu.core.controler.handler;

import ru.dgu.controler.MultiAdapter;
import ru.dgu.controler.Switcher;
import ru.dgu.core.controler.Addition;
import ru.dgu.core.controler.mouse.*;
import ru.dgu.core.exceptions.CallMethodException;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.util.Map;

public class Builder {
    private static boolean built = false;

    private Builder() {
    }

    public static Storage build(final Scalable scalable,
                                final CursorMovable cursorMovable,
                                final Scrollable scrollable,
                                final Switcher switcher,
                                final Addition addition,
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
                addition,
                tileTypeMap,
                objectTypeMap
        );
        final Storage storage = new ControlsStorage(walkingControl, additionControl);
        built = true;
        return storage;
    }

    private static class ControlsStorage implements Storage {
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
