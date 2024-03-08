package md.brainet.games.minecraft2d.adapter.api.graphics;


import md.brainet.games.minecraft2d.adapter.api.graphics.Displayed;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameGraphics2DRender {
    private final Map<Point, Displayed> graphics;

    public GameGraphics2DRender() {
        this.graphics = new ConcurrentHashMap<>();
    }

    public abstract void render();

    public Map<Point, Displayed> getGraphics(){
        return graphics;
    }
}
