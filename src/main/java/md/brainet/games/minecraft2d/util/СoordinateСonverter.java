package md.brainet.games.minecraft2d.util;

import md.brainet.games.minecraft2d.view.GameFrame;
import md.brainet.games.minecraft2d.view.Texture;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class СoordinateСonverter {

    private final Point framePosition;
    private final Dimension frameSize;

    public СoordinateСonverter(GameFrame gameFrame) {
        this.frameSize = gameFrame.getSize();
        this.framePosition = gameFrame.getLocation();
    }

    public Point toGameCoordinates(Point displayCoordinates){
        int x = (int) Math.floor((double) (displayCoordinates.x - 7 + framePosition.x) / Texture.SIZE);
        int y = (int) Math.ceil((displayCoordinates.y - framePosition.y - frameSize.getHeight() + 9) / Texture.SIZE);
        return new Point(x, y * -1);
    }
    public Point toDisplayCoordinates(Point gameCoordinates){
        int x = gameCoordinates.x * Texture.SIZE - framePosition.x;
        int y = (gameCoordinates.y + 1) * Texture.SIZE - framePosition.y;
        return new Point(x, -1 * y + (int)frameSize.getHeight() - 39);
    }
}
