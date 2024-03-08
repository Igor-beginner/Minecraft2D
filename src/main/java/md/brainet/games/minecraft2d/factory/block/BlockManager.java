package md.brainet.games.minecraft2d.factory.block;

import md.brainet.games.minecraft2d.factory.world.World;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class BlockManager {
    private final World level;

    public BlockManager(World level) {
        this.level = level;
    }

    public void create(Point point, Block block){
        level.addBlock(point, block);
    }

    public void destroy(Point point){
        level.removeBlock(point);
    }
}
