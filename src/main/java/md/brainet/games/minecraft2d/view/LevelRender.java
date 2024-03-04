package md.brainet.games.minecraft2d.view;

import md.brainet.games.minecraft2d.block.Block;
import md.brainet.games.minecraft2d.util.СoordinateСonverter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


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
        Map<Point, Block> blocks = level.getAllBlocks();
        pushBlocksToFrame(blocks);
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
