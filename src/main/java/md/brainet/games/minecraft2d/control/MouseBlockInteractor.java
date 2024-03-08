package md.brainet.games.minecraft2d.control;

import md.brainet.games.minecraft2d.adapter.api.input.FrameEvent;
import md.brainet.games.minecraft2d.adapter.api.input.MouseClickGameListener;
import md.brainet.games.minecraft2d.factory.block.BlockManager;
import org.springframework.stereotype.Component;

import java.awt.event.MouseEvent;

@Component
public class MouseBlockInteractor implements MouseClickGameListener {

    private final BlockManager blockManager;
    private final ActiveBlockController player;

    public MouseBlockInteractor(BlockManager blockManager, ActiveBlockController player) {
        this.blockManager = blockManager;
        this.player = player;
    }

    @Override
    public void onPressed(FrameEvent frameEvent) {
        switch (frameEvent.button()){
            case MouseEvent.BUTTON3 ->
                    blockManager.create(frameEvent.pos(), player.getActiveBlock());
            case MouseEvent.BUTTON1 ->
                    blockManager.destroy(frameEvent.pos());
        }
    }

    @Override
    public void onReleased(FrameEvent frameEvent) {

    }
}
