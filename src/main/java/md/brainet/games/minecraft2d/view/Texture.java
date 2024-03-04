package md.brainet.games.minecraft2d.view;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class Texture implements Icon {
    public static final int SIZE = 32;

    private final Icon texture;

    public Texture(Path res) {
        Image image = new ImageIcon(res.toString()).getImage();
        image = image.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
        texture = new ImageIcon(image);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        texture.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return SIZE;
    }

    @Override
    public int getIconHeight() {
        return SIZE;
    }
}
