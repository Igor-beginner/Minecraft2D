package md.brainet.games.minecraft2d.block;

import md.brainet.games.minecraft2d.view.Level;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class BlockManager {
    private final Level level;

    public BlockManager(Level level) {
        this.level = level;
    }

    public void create(Point point, Block block){
        level.addBlock(point, block);
    }

    public void destroy(Point point){
        level.removeBlock(point);
    }
}
