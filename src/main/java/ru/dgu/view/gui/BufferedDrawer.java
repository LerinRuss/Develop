package ru.dgu.view.gui;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BufferedDrawer {
    private final BufferedImage bufferedImage;
    private final Queue<Drawable> queue = new LinkedList<>();

    private BufferedDrawer(int widht, int height) {
        bufferedImage = new BufferedImage(widht, height, BufferedImage.TYPE_INT_ARGB);
    }

    BufferedImage paint() {
        for (Drawable drawable : queue) {
            drawable.draw(bufferedImage.getGraphics());
        }

        return bufferedImage;
    }

}
