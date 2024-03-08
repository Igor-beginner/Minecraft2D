package md.brainet.games.minecraft2d.render;

import md.brainet.games.minecraft2d.adapter.api.graphics.Displayed;
import md.brainet.games.minecraft2d.adapter.api.graphics.GameGraphics2DRender;
import md.brainet.games.minecraft2d.factory.block.Block;
import md.brainet.games.minecraft2d.factory.world.World;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
public class FramePainter extends GameGraphics2DRender {
    private final World world;
    private final FrameVisibilityDefinition frameVisibilityBlockDefinition;
    public FramePainter(FrameVisibilityDefinition frameVisibilityBlockDefinition, World world) {
        this.world = world;
        this.frameVisibilityBlockDefinition = frameVisibilityBlockDefinition;
    }

    @Override
    public void render() {
        Map<Point, Block> blocks = world.getAllBlocks();
        Map<Point, Displayed> graphics = getGraphics();

        frameVisibilityBlockDefinition
                .calculateGameCoordinatesOfVisibleScope();

        List<Point> vScope = frameVisibilityBlockDefinition
                .getVisibleScope();

        vScope.forEach(pos -> {
                    Block vBlock = blocks.get(pos);
                    if(Objects.nonNull(vBlock)){
                        graphics.put(pos, blocks.get(pos));
                    }
                });

        vScope.clear();
    }
}
