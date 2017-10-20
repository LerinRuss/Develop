package ru.dgu.view.gui;

import javax.swing.*;

class Menu extends JPanel {
    private final JComponent[] labels = new JComponent[]{
            new JLabel("seed"),
            new JLabel("roughness"),
            new JLabel("Level of sea"),
            new JLabel("Level of shallow"),
            new JLabel("Level of land"),
            new JLabel("Level for hill"),
            new JLabel("Level for Mountains")
    };

    private final JComponent[] textFields = new JComponent[]{
            new JTextField("seed"),
            new JTextField("roughness"),
            new JTextField("sea"),
            new JTextField("shallow"),
            new JTextField("land"),
            new JTextField("hill"),
            new JTextField("mountain")
    };

    private final JComponent[] buttons = new JComponent[]{
            new JButton("Перегенерировать Нигга"),
            new JButton("Next Step")
    };

    private Menu(){
        super();
        additionComponents();
    }

    private void additionComponents(){
        for (JComponent label : labels) {
            add(label);
        }
        for (JComponent textField : textFields) {
            add(textField);
        }
        for (JComponent button : buttons) {
            add(button);
        }
    }

    static class Builder{
        private Builder(){}

        static JComponent generate(final int width,final int height){
            final Menu menu = new Menu();
            menu.setSize(width, height);

            final int widthComponent = 250, heightComponent = 25;
            final int delta = 35;
            int x = 0, y = 0;
            placeButtons(menu,x,y,width,height,delta);
            placeLabelsVertically(menu, x,y,widthComponent,heightComponent,delta);
            placeTextFieldsVertically(menu,x,y,width,height, delta);

            return menu;
        }

        private static void placeButtons(final Menu menu,final int x, final int y,
                                         final int width,final int height,final int delta){
            int yy = y;
            for (JComponent button : menu.buttons) {
                button.setBounds(x,yy, width, height);
                yy += height + delta;
            }
        }

        private static void placeTextFieldsVertically(final Menu menu, final int x, final int y,
                                                      final int width, final int height, final int delta){

            int yy = y;
            for (JComponent textField : menu.textFields) {
                textField.setBounds(x,yy, width,height);
                yy += height + delta;
            }
        }

        private static void placeLabelsVertically(final Menu menu, final int x, final int y,
                                                  final int width, final int height, final int delta){
            int yy = y;
            for (JComponent label : menu.labels) {
                label.setBounds(x,yy,width,height);
                yy += height + delta;
            }
        }
    }
}
