package md.brainet.games.minecraft2d.view;

import md.brainet.games.minecraft2d.block.Block;
import md.brainet.games.minecraft2d.util.СoordinateСonverter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Component
public class LevelRender {
    private final Level level;
    private final GameFrame gameFrame;
    private final СoordinateСonverter coordinateConverter;

    public LevelRender(Level level, GameFrame gameFrame, СoordinateСonverter coordinateConverter) {
        this.level = level;
        this.gameFrame = gameFrame;
        this.coordinateConverter = coordinateConverter;
    }

    public void render(){
        Dimension d = gameFrame.getSize();

        Point fLoc = coordinateConverter.toGameCoordinates(new Point(0,(int)d.getHeight()));

        Point fLocEnd = coordinateConverter
                .toGameCoordinates(new Point((int)d.getWidth(),0));

        Map<Point, Block> blocks = level.getAllBlocks();
        Set<Point> pointsVisibleForFrame = blocks.keySet()
                .parallelStream()
                .filter(p -> fLoc.x <= p.x && p.x < fLocEnd.x &&
                        fLoc.y <= p.y && p.y <= fLocEnd.y)
                .collect(Collectors.toSet());
        Map<Point, Block> blocksVisibleForFrame = new HashMap<>();
        pointsVisibleForFrame
                .forEach(p -> blocksVisibleForFrame.put(p, blocks.get(p)));

        pushBlocksToFrame(blocksVisibleForFrame);
        updateFrame();
    }

    public void clean(){
        gameFrame.getContentPane().removeAll();
    }

    private void pushBlocksToFrame(Map<Point, Block> blocks){
        blocks.keySet().parallelStream().forEach(blockPosition -> {
            Block block = blocks.get(blockPosition);
            gameFrame.add(toJLabel(blockPosition, block.texture()));
        });
    }

    private void updateFrame(){
        gameFrame.revalidate();
        gameFrame.repaint();
    }

    private JLabel toJLabel(Point point, Texture texture){
        point = coordinateConverter.toDisplayCoordinates(point);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(texture);
        jLabel.setLocation(point);
        jLabel.setSize(texture.getIconWidth(), texture.getIconHeight());
        return jLabel;
    }
}
