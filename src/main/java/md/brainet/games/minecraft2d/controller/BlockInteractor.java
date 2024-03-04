package md.brainet.games.minecraft2d.controller;

import md.brainet.games.minecraft2d.block.BlockManager;
import md.brainet.games.minecraft2d.util.СoordinateСonverter;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class BlockInteractor extends MouseAdapter {

    private final BlockManager blockManager;
    private final ActiveBlockController player;
    private final СoordinateСonverter coordinateСonverter;

    public BlockInteractor(BlockManager blockManager, ActiveBlockController player, СoordinateСonverter coordinateСonverter) {
        this.blockManager = blockManager;
        this.player = player;
        this.coordinateСonverter = coordinateСonverter;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point coords = coordinateСonverter.toGameCoordinates(e.getPoint());
        switch (e.getButton()){
            case MouseEvent.BUTTON3 ->
                    blockManager.create(coords, player.getActiveBlock());
            case MouseEvent.BUTTON1 ->
                    blockManager.destroy(coords);
        }
    }
}
