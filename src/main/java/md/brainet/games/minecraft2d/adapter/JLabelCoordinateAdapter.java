package md.brainet.games.minecraft2d.adapter;

import md.brainet.games.minecraft2d.adapter.api.graphics.Displayed;
import md.brainet.games.minecraft2d.adapter.api.graphics.GameGraphics2DRender;
import md.brainet.games.minecraft2d.config.FrameDetails;
import md.brainet.games.minecraft2d.converter.CoordinatesConverter;
import md.brainet.games.minecraft2d.converter.GameToDisplayСoordinatesСonverter;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;


@Service
public class JLabelCoordinateAdapter extends JLabel {

    private final List<GameGraphics2DRender> renders;
    private final CoordinatesConverter gameToDisplay;
    private Graphics graphics;

    public JLabelCoordinateAdapter(List<GameGraphics2DRender> graphics,
                                   GameToDisplayСoordinatesСonverter gameToDisplay,
                                   FrameDetails frameDetails) {
        this.renders = graphics;
        this.gameToDisplay = gameToDisplay;
        setSize(frameDetails.getSize());
        setLayout(null);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.graphics = g;
        long b = System.currentTimeMillis();
        activateAllRenders();
        System.out.print("\r" + (System.currentTimeMillis() - b));
    }
    
    private void activateAllRenders(){
        renders.parallelStream()
                .forEach(this::activateRender);
    }

    private void activateRender(GameGraphics2DRender gg2d){
        gg2d.render();
        Map<Point, Displayed> frame = gg2d.getGraphics();
        render(frame);
        frame.clear();
    }

    private void render(Map<Point, Displayed> frame){
        frame.keySet()
                .parallelStream()
                .forEach(p -> convertCoordsAndDrawDisplayed(p, frame.get(p)));
    }

    private void convertCoordsAndDrawDisplayed(Point coords, Displayed displayed){
        Point convertedPos = gameToDisplay.convert(coords);
        drawDisplayed(convertedPos, displayed);
    }

    private void drawDisplayed(Point dp, Displayed displayed){
        graphics.drawImage(displayed.getTexture().getImage(),
                dp.x, dp.y,
                (int) displayed.getDimension().getWidth(),
                (int) displayed.getDimension().getHeight(),
                this);
    }
}
