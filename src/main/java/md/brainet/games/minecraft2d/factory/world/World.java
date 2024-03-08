package md.brainet.games.minecraft2d.factory.world;

import md.brainet.games.minecraft2d.factory.block.Block;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private final Map<Point, Block> map;

    public World() {
        this.map = new ConcurrentHashMap<>();
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
}
