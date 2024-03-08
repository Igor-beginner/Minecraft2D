package md.brainet.games.minecraft2d.factory.block;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BlockContext {
    private Map<String, Block> registeredBlocks;

    public BlockContext(Map<String, Block> registeredBlocks) {
        this.registeredBlocks = registeredBlocks;
    }

    public Block getBlockById(String id) throws BlockNotFoundException{
        if(!registeredBlocks.containsKey(id)){
            throw new BlockNotFoundException(String
                    .format("Block with id %s has not found!", id));
        }
        return registeredBlocks.get(id);
    }
}
