package md.brainet.games.minecraft2d.converter;

import md.brainet.games.minecraft2d.config.FrameDetails;
import md.brainet.games.minecraft2d.render.Texture;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class GameToDisplayСoordinatesСonverter implements CoordinatesConverter{

    private final FrameDetails frameDetails;

    public GameToDisplayСoordinatesСonverter(FrameDetails frameDetails) {
        this.frameDetails = frameDetails;
    }
    @Override
    public Point convert(Point point) {
        return convert(point.x, point.y);
    }

    @Override
    public Point convert(int inX, int inY) {
        Point fp = frameDetails.getPosition();
        Dimension fs = frameDetails.getSize();
        int outX = inX * Texture.SIZE - fp.x;
        int outY = (inY + 1) * Texture.SIZE - fp.y;
        return new Point(outX, -1 * outY + (int)fs.getHeight() - 39);
    }
}
