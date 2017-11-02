package ru.dgu.core.controler;

import ru.dgu.controler.Dispatcher;
import ru.dgu.controler.State;
import ru.dgu.controler.Switcher;
import ru.dgu.core.controler.handler.Builder;
import ru.dgu.core.controler.mouse.CursorMovable;
import ru.dgu.core.controler.mouse.Scalable;
import ru.dgu.core.controler.mouse.Scrollable;

public class Core {
    private static Switcher method(final CursorMovable cursorMovable,
                               final Scalable scalable,
                               final Scrollable scrollable,
                               final Changer changer){
        final Switcher switcher = Dispatcher.init();
        final Builder.ControlsStorage storage = Builder.build(scalable,cursorMovable,scrollable, switcher, changer,
                KeySetting.getTileTypeKeysSetting(), KeySetting.getObjectTypeKeys());

        State.WALKING.setMouseAdapter(storage.getWalkingControl());
        State.WALKING.setKeyListener(storage.getWalkingControl());

        State.ADDITION.setMouseAdapter(storage.getAdditionControl());
        State.ADDITION.setKeyListener(storage.getAdditionControl());

        return switcher;
    }
}
