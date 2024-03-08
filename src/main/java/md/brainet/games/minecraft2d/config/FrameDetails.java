package md.brainet.games.minecraft2d.config;

import java.awt.*;

public class FrameDetails {
    private final Dimension size;
    private final Point position;

    private FrameDetails(Dimension size, Point position) {
        this.size = size;
        this.position = position;
    }

    public Dimension getSize() {
        synchronized (size) {
            return (Dimension) size.clone();
        }
    }

    public void setSize(Dimension size) {
        synchronized (this.size) {
            this.size.setSize(size);
        }
    }

    public Point getPosition() {
        synchronized (position) {
            return (Point) position.clone();
        }
    }

    public void setPosition(Point position) {
        synchronized (this.position) {
            this.position.setLocation(position);
        }
    }

    public static FrameDetails of(Dimension dimension, Point position){
        return new FrameDetails(dimension, position);
    }

    public static FrameDetails of(Dimension dimension){
        return of(dimension, new Point());
    }

    public static FrameDetails empty(){
        return of(new Dimension());
    }
}
