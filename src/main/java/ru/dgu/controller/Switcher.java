package ru.dgu.controller;

/**
 * The class implementing this interface is a tree node having more child nodes.
 * Supposedly, only one its child node can be active/current.
 *
 * For example.
 * class MouseManager is switcher. It receives all events of {@link MultiAdapter}
 * and handles some mouse event for camera control. Then it push all event a current child node
 * (active child node).
 *
 * Class ObjectAdder is the control tree leaf. It's child of MouseManager and if it is current
 * for MouseManager it receives events after handling by MouseManager and handles them too.
 *
 * Class TileAdder is same what described above just for tiles.
 *
 * Supposedly, every switcher has more one child nodes. And child nodes receives instance of their
 * Switcher for switching a current child node via method setCurrent.
 *
 * Every child node knows about each other within their parent. Builder of current control state
 * put child node in the their store where they can use each other.
 */
public interface Switcher {
    void setCurrent(MultiAdapter multiAdapter);
}
