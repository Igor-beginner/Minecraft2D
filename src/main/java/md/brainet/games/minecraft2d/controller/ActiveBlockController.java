package md.brainet.games.minecraft2d.controller;

import md.brainet.games.minecraft2d.block.Block;
import md.brainet.games.minecraft2d.block.BlockContext;
import org.springframework.stereotype.Component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Component
public class ActiveBlockController extends KeyAdapter {
    private BlockContext blockContext;
    private Block activeBlock;

    public ActiveBlockController(BlockContext blockContext) {
        this.blockContext = blockContext;
        activeBlock = blockContext.getBlockById("dirt");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        synchronized (this) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1 -> activeBlock = blockContext.getBlockById("grass");
                case KeyEvent.VK_2 -> activeBlock = blockContext.getBlockById("dirt");
                case KeyEvent.VK_3 -> activeBlock = blockContext.getBlockById("cobblestone");
            }
        }
    }

    public synchronized Block getActiveBlock(){
        return activeBlock;
    }
}
