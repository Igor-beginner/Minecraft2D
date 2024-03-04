package md.brainet.games.minecraft2d.view;

import md.brainet.games.minecraft2d.block.Block;
import md.brainet.games.minecraft2d.block.BlockContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Level {
    private final BlockContext blockContext;
    private final Map<Point, Block> map;

    public Level(BlockContext blockContext) {
        this.blockContext = blockContext;
        this.map = new ConcurrentHashMap<>();
        build();
    }

    public void addBlock(Point position, Block block){
        map.put(position, block);
    }

    public void removeBlock(Point point){
        map.remove(point);
    }

    public Map<Point, Block> getAllBlocks(){
        return new HashMap<>(map);
    }

    private void build(){
        Block grass = blockContext.getBlockById("grass");
        Block dirt = blockContext.getBlockById("dirt");
        Block cobblestone = blockContext.getBlockById("cobblestone");

        for(int x = 5; x < 1000; x++){
            map.put(new Point(x, 6), grass);
        }

        for (int y = 5; y > 3; y--){
            for(int x = 5; x < 1000; x++){
                map.put(new Point(x, y), dirt);
            }
        }

        for (int y = 3; y > -5; y--){
            for(int x = 5; x < 1000; x++){
                map.put(new Point(x, y), cobblestone);
            }
        }
    }
}
