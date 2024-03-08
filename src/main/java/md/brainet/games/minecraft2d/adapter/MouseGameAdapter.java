package md.brainet.games.minecraft2d.adapter;

import md.brainet.games.minecraft2d.adapter.api.input.FrameEvent;
import md.brainet.games.minecraft2d.adapter.api.input.MouseClickGameListener;
import md.brainet.games.minecraft2d.adapter.api.input.MouseMoveGameListener;
import md.brainet.games.minecraft2d.converter.CoordinatesConverter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Service
public class MouseGameAdapter extends MouseAdapter {
    private final List<MouseMoveGameListener> mouseMoveGameListeners;
    private final List<MouseClickGameListener> mouseClickGameListeners;
    private final CoordinatesConverter coordinateConverter;

    public MouseGameAdapter(List<MouseMoveGameListener> mouseMoveGameListeners, List<MouseClickGameListener> mouseClickGameListeners, CoordinatesConverter displayToGameCoordinatesConverter) {
        this.mouseMoveGameListeners = mouseMoveGameListeners;
        this.mouseClickGameListeners = mouseClickGameListeners;
        this.coordinateConverter = displayToGameCoordinatesConverter;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point gamePoint = coordinateConverter.convert(e.getPoint());
        mouseClickGameListeners.forEach(l ->
                l.onPressed(new FrameEvent(gamePoint, e.getButton())));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point gamePoint = coordinateConverter.convert(e.getPoint());
        mouseClickGameListeners.forEach(l ->
                l.onReleased(new FrameEvent(gamePoint, e.getButton())));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point gamePoint = coordinateConverter.convert(e.getPoint());
        mouseMoveGameListeners.forEach(l -> l.onMove(gamePoint));
    }
}
