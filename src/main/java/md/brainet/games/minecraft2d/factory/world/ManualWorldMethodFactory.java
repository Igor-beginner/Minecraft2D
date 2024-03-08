package md.brainet.games.minecraft2d.factory.world;

import md.brainet.games.minecraft2d.factory.block.Block;
import md.brainet.games.minecraft2d.factory.block.BlockContext;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class ManualWorldMethodFactory implements WorldMethodFactory {

    private final BlockContext blockContext;

    public ManualWorldMethodFactory(BlockContext blockContext) {
        this.blockContext = blockContext;
    }

    @Override
    public World build() {
        World world = new World();

        Block grass = blockContext.getBlockById("grass");
        Block dirt = blockContext.getBlockById("dirt");
        Block cobblestone = blockContext.getBlockById("cobblestone");

        for(int x = 5; x < 100_000; x++){
            world.addBlock(new Point(x, 6), grass);
        }

        for (int y = 5; y > 3; y--){
            for(int x = 5; x < 100_000; x++){
                world.addBlock(new Point(x, y), dirt);
            }
        }

        for (int y = 3; y > -20; y--){
            for(int x = 5; x < 100_000; x++){
                world.addBlock(new Point(x, y), cobblestone);
            }
        }
        return world;
    }
}
