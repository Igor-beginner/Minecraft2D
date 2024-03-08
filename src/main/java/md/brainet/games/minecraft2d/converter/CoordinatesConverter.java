package md.brainet.games.minecraft2d.converter;

import java.awt.*;

public interface CoordinatesConverter {
    Point convert(Point point);
    Point convert(int x, int y);
}
