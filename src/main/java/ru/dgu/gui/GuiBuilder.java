package ru.dgu.gui;

import javax.swing.*;

public interface GuiBuilder {
    JComponent generate(int width, int height);
}
