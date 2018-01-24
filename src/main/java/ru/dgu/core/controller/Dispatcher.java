package ru.dgu.core.controller;

import ru.dgu.controller.*;
import ru.dgu.controller.core.control.ControlBuilder;
import ru.dgu.layer.Accentuation;
import ru.dgu.layer.Loupe;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.modelcore.ModelCore;
import ru.dgu.model.types.ObjectType;
import ru.dgu.utils.coordinates.IntegerCoordinates;
import ru.dgu.utils.coordinates.Transfer;

import java.awt.event.KeyEvent;
import java.util.Map;

public class Dispatcher {

    private Dispatcher(){}

    public static MultiAdapter create
            (MapPutting mapPutting, Loupe loupe, Accentuation accentuation, int tileSize) {

        //Temporary
        final TemporaryObjectAdditionSetting objectAdditionSetting = new TemporaryObjectAdditionSetting();
        final TemporaryTileAdditionSetting temporaryTileAdditionSetting = new TemporaryTileAdditionSetting();

        objectAdditionSetting.map = KeySetting.getObjectKeys();
        temporaryTileAdditionSetting.map = KeySetting.getTileKeys();

        final KeySettingsStore store = new KeySettingsStore() {
            @Override
            public ObjectAdditionKeysSetting getObjectAdditionKeysSetting() {
                return objectAdditionSetting;
            }

            @Override
            public TileAdditionKeysSetting getTileAdditionKeysSetting() {
                return temporaryTileAdditionSetting;
            }
        };
        //
        final AccentuationProxy accentuationProxy = new AccentuationProxy(accentuation, loupe, tileSize);
        final MapPuttingProxy changerProxy = new MapPuttingProxy(mapPutting,loupe, tileSize);
        return  ControlBuilder.create(accentuationProxy, loupe, changerProxy, store);
    }

    private static class TemporaryObjectAdditionSetting implements ObjectAdditionKeysSetting {

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

    private static class MapPuttingProxy implements MapPutting {
        private final MapPutting mapPutting;
        private final Loupe loupe;
        private final int tileSize;

        private MapPuttingProxy(final MapPutting mapPutting,
                                final Loupe loupe,
                                final int tileSize){
            this.mapPutting = mapPutting;
            this.loupe = loupe;
            this.tileSize = tileSize;
        }

        @Override
        public void setTile(TileType tileType, int x, int y) {
            final IntegerCoordinates loupeTransfer = Transfer.transferLoupeCoordinates(loupe, x ,y);
            final IntegerCoordinates mapTransfer = Transfer.transferCoordinates(tileSize, loupeTransfer.getX(), loupeTransfer.getY());
            if(ModelCore.outOfMapBound(mapTransfer))
                return;
            mapPutting.setTile(tileType, mapTransfer.getX(), mapTransfer.getY());
        }

        @Override
        public void addObject(ObjectType objectType, int x, int y) {
            final IntegerCoordinates loupeTransfer = Transfer.transferLoupeCoordinates(loupe, x ,y);
            final IntegerCoordinates mapTransfer = Transfer.transferCoordinates(tileSize, loupeTransfer.getX(), loupeTransfer.getY());
            if(ModelCore.outOfMapBound(mapTransfer))
                return;
            mapPutting.addObject(objectType, mapTransfer.getX(), mapTransfer.getY());
        }
    }

    private static class AccentuationProxy implements Movable {

        private final Movable movable;
        private final Loupe loupe;
        private final int tileSize;

        private AccentuationProxy(final Movable movable,
                                  final Loupe loupe,
                                  final int tileSize) {
            this.movable = movable;
            this.loupe = loupe;
            this.tileSize = tileSize;
        }


        @Override
        public void move(IntegerCoordinates coordinates) {
            throw new UnsupportedOperationException("There are no assumptions to call this method in the code");
        }

        @Override
        public void move(int x, int y) {
            final IntegerCoordinates loupeTransfer = Transfer.transferLoupeCoordinates(loupe, x, y);
            final IntegerCoordinates mapTransfer = Transfer.transferCoordinates(tileSize, loupeTransfer);
            movable.move(mapTransfer);
        }
    }
}
