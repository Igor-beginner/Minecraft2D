package md.brainet.games.minecraft2d.render;

import md.brainet.games.minecraft2d.config.FrameDetails;
import md.brainet.games.minecraft2d.converter.CoordinatesConverter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FrameVisibilityDefinition {
    private final CoordinatesConverter coordinatesConverter;
    private final FrameDetails frameDetails;
    private final List<Point> visibleScope;

    public FrameVisibilityDefinition(CoordinatesConverter displayToGameCoordinatesConverter, FrameDetails frameDetails) {
        this.coordinatesConverter = displayToGameCoordinatesConverter;
        this.frameDetails = frameDetails;
        this.visibleScope = new ArrayList<>();
    }

    public void calculateGameCoordinatesOfVisibleScope(){
        Point[] peaks = calculatePeaks();
        for (int x = peaks[0].x; x <= peaks[1].x; x++){
            for(int y = peaks[0].y; y <= peaks[1].y; y++){
                visibleScope.add(new Point(x, y));
            }
        }
    }

    public List<Point> getVisibleScope() {
        return visibleScope;
    }

    public boolean isVisible(Point el){
        Point left = calculateLeftDownCornerOfFrameToGameCoordinates();
        Point right = calculateTopRightCornerOfFrameToGameCoordinates();
        return isVisible(el, left, right);
    }

    private Point[] calculatePeaks(){
        return new Point[]{
          calculateLeftDownCornerOfFrameToGameCoordinates(),
          calculateTopRightCornerOfFrameToGameCoordinates()
        };
    }

    private Point calculateLeftDownCornerOfFrameToGameCoordinates(){
        Dimension d = frameDetails.getSize();
        return coordinatesConverter
                .convert(new Point(0,(int)d.getHeight()));
    }

    private Point calculateTopRightCornerOfFrameToGameCoordinates(){
        Dimension d = frameDetails.getSize();
        return coordinatesConverter
                .convert(new Point((int)d.getWidth(),0));
    }

    private boolean isVisible(Point el, Point leftDown, Point topRight) {
        return leftDown.x <= el.x && el.x <= topRight.x &&
                leftDown.y <= el.y && el.y <= topRight.y;
    }
}
