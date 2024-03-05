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
public class LevelRender extends JLabel{
    private final Level level;
    private final GameFrame gameFrame;
    private final СoordinateСonverter coordinateConverter;

    public LevelRender(Level level, GameFrame gameFrame, СoordinateСonverter coordinateConverter) {
        this.level = level;
        this.gameFrame = gameFrame;
        this.coordinateConverter = coordinateConverter;
        gameFrame.add(this);
        setLayout(null);
        setSize(gameFrame.getSize());
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension d = gameFrame.getSize();

        Point fLoc = coordinateConverter
                .toGameCoordinates(new Point(0,(int)d.getHeight()));

        Point fLocEnd = coordinateConverter
                .toGameCoordinates(new Point((int)d.getWidth(),0));

        Map<Point, Block> blocks = level.getAllBlocks();
        blocks.keySet()
                .parallelStream()
                .filter(p -> isVisible(p, fLoc, fLocEnd))
                .forEach(gp -> {
                    Point dp = coordinateConverter.toDisplayCoordinates(gp);
                    g2d.drawImage(blocks.get(gp).texture().getImage(), dp.x, dp.y, Texture.SIZE, Texture.SIZE, this);
                });
    }

    private boolean isVisible(Point curr, Point left, Point right){
        return left.x <= curr.x && curr.x <= right.x &&
                left.y <= curr.y && curr.y <= right.y;
    }

    public void updateFrame(){
        revalidate();
        repaint();
    }
}
