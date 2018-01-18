package ru.dgu.core.controller;

import ru.dgu.controller.Changer;
import ru.dgu.controller.Controller;
import ru.dgu.controller.MultiAdapter;
import ru.dgu.layer.Accentuation;
import ru.dgu.layer.Loupe;
import ru.dgu.model.map.tiles.TileType;
import ru.dgu.model.modelcore.ModelCore;
import ru.dgu.model.types.ObjectType;
import ru.dgu.utils.coordinates.IntegerCoordinates;
import ru.dgu.utils.coordinates.Transfer;

public class Dispatcher {

    private Dispatcher(){}

    public static MultiAdapter create(final Changer changer,
                                      final Loupe loupe,
                                      final Accentuation accentuation,
                                      final int tileSize){
        final AccentuationProxy accentuationProxy = new AccentuationProxy(accentuation, loupe, tileSize);
        final ChangerProxy changerProxy = new ChangerProxy(changer,loupe, tileSize);
        return  Controller.create(accentuationProxy, loupe, changerProxy);
    }

    private static class ChangerProxy implements Changer {
        private final Changer changer;
        private final Loupe loupe;
        private final int tileSize;

        private ChangerProxy(final Changer changer,
                             final Loupe loupe,
                             final int tileSize){
            this.changer = changer;
            this.loupe = loupe;
            this.tileSize = tileSize;
        }

        @Override
        public void setTileType(TileType tileType, int x, int y) {
            final IntegerCoordinates loupeTransfer = Transfer.transferLoupeCoordinates(loupe, x ,y);
            final IntegerCoordinates mapTransfer = Transfer.transferCoordinates(tileSize, loupeTransfer.getX(), loupeTransfer.getY());
            if(ModelCore.outOfMapBound(mapTransfer))
                return;
            changer.setTileType(tileType, mapTransfer.getX(), mapTransfer.getY());
        }

        @Override
        public void add(ObjectType objectType, int x, int y) {
            final IntegerCoordinates loupeTransfer = Transfer.transferLoupeCoordinates(loupe, x ,y);
            final IntegerCoordinates mapTransfer = Transfer.transferCoordinates(tileSize, loupeTransfer.getX(), loupeTransfer.getY());
            if(ModelCore.outOfMapBound(mapTransfer))
                return;
            changer.add(objectType, mapTransfer.getX(), mapTransfer.getY());
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
