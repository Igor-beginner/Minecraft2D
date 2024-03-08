package md.brainet.games.minecraft2d.converter;

import md.brainet.games.minecraft2d.config.FrameDetails;
import md.brainet.games.minecraft2d.render.Texture;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class DisplayToGameCoordinatesConverter implements CoordinatesConverter{

    private final FrameDetails frameDetails;

    public DisplayToGameCoordinatesConverter(FrameDetails frameDetails) {
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
        int outX = (int) Math.floor((double) (inX - 7 + fp.x) / Texture.SIZE);
        int outY = (int) Math.ceil((inY - fp.y - fs.getHeight() + 9) / Texture.SIZE);
        return new Point(outX, outY * -1);
    }
}
