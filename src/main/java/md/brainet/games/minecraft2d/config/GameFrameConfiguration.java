package md.brainet.games.minecraft2d.config;

import md.brainet.games.minecraft2d.adapter.JLabelCoordinateAdapter;
import md.brainet.games.minecraft2d.control.FrameNavigator;
import md.brainet.games.minecraft2d.factory.world.World;
import md.brainet.games.minecraft2d.factory.world.WorldMethodFactory;
import md.brainet.games.minecraft2d.time.GameTime;
import md.brainet.games.minecraft2d.render.FpsFramePainter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

@Configuration
public class GameFrameConfiguration {

    private static final Dimension FRAME_SIZE = new Dimension(900, 600);

    @Bean
    public JFrame gameFrame(JLabelCoordinateAdapter jLabelCoordinateAdapter,
                            FrameDetails frameDetails,
                            List<KeyAdapter> keyAdapters,
                            List<MouseListener> mouseListeners,
                            List<MouseMotionListener> mouseMotionListeners,
                            FrameNavigator frameNavigator) {

        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Minecraft2D");
        gameFrame.setLocation(frameDetails.getPosition());
        gameFrame.setSize(frameDetails.getSize());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.setFocusable(true);
        gameFrame.add(jLabelCoordinateAdapter);
        gameFrame.addKeyListener(frameNavigator);
        keyAdapters.forEach(gameFrame::addKeyListener);
        mouseListeners.forEach(gameFrame::addMouseListener);
        mouseMotionListeners.forEach(gameFrame::addMouseMotionListener);
        gameFrame.setVisible(true);
        return gameFrame;
    }

    @Bean
    public World world(WorldMethodFactory worldMethodFactory){
        return worldMethodFactory.build();
    }

    @Bean
    public FrameDetails frameDetails(){
        return FrameDetails.of(FRAME_SIZE);
    }

    @Bean
    public FpsFramePainter fpsFramePainter(JLabelCoordinateAdapter jLabelCoordinateAdapter){
        FpsFramePainter fpsFramePainter = new FpsFramePainter(jLabelCoordinateAdapter);
        new Thread(fpsFramePainter).start();
        return fpsFramePainter;
    }

    @Bean
    public GameTime time() {
        GameTime time = new GameTime();
        new Thread(time).start();
        return time;
    }
}