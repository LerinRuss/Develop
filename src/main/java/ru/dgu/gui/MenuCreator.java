package ru.dgu.gui;

import javax.swing.*;

public class MenuCreator {
    private MenuCreator(){
    }

    public static JComponent create(){
        return Menu.Builder.generate(800,600);
    }
}
