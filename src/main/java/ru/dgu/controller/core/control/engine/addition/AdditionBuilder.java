package ru.dgu.controller.core.control.engine.addition;

import ru.dgu.controller.Changer;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.controller.ObjectAdditionKeysSetting;
import ru.dgu.controller.TileAdditionKeysSetting;
import ru.dgu.controller.core.control.engine.AdditionControl;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.types.ObjectType;

import java.awt.event.KeyEvent;
import java.util.Map;

public class AdditionBuilder {
    private AdditionBuilder() {}

    public static MultiAdapter build(Changer changer) {
        //Temporary
        final TemporaryObjectAdditionSetting objectAdditionSetting = new TemporaryObjectAdditionSetting();
        final TemporaryTileAdditionSetting temporaryTileAdditionSetting = new TemporaryTileAdditionSetting();

        objectAdditionSetting.map = KeySetting.getObjectKeys();
        temporaryTileAdditionSetting.map = KeySetting.getTileKeys();
        //
        final AdditionControl additionControl = new AdditionControl();
        final MultiAdapter objectTypeChangingHandler = new ObjectAdditionHandler(additionControl, changer, objectAdditionSetting);
        final MultiAdapter tileTypeAdditionHandler = new TileAdditionHandler(additionControl, changer, temporaryTileAdditionSetting);

        AdditionStore.setObjectTypeChangingHandler(objectTypeChangingHandler);
        AdditionStore.setTileTypeAdditionHandler(tileTypeAdditionHandler);

        additionControl.setCurrent(tileTypeAdditionHandler);

        return additionControl;
    }

    private static class TemporaryObjectAdditionSetting implements ObjectAdditionKeysSetting{

        Map<Integer, ObjectType> map;

        @Override
        public boolean hasSwitched(int keyCode) {
            return keyCode == KeyEvent.VK_TAB;
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public Map<Integer, ObjectType> getObjectKeysSetting() {
            return map;
        }

        @Override
        public ObjectType get(int keyCode) {
            return map.get(keyCode);
        }
    }
    private static class TemporaryTileAdditionSetting implements TileAdditionKeysSetting {
        Map<Integer, TileType> map;

        @Override
        public boolean hasSwitched(int keyCode) {
            return keyCode == KeyEvent.VK_TAB;
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public Map<Integer, TileType> getTileKeysSetting() {
            return map;
        }

        @Override
        public TileType get(int keyCode) {
            return map.get(keyCode);
        }
    }
}
