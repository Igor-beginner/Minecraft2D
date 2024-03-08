package md.brainet.games.minecraft2d.render;

import javax.swing.*;
import java.nio.file.Path;

public class Texture extends ImageIcon {
    public static final int SIZE = 32;

    public Texture(Path res) {
        super(res.toString());
    }
}
