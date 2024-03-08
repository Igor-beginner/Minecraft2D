package md.brainet.games.minecraft2d.control;

import md.brainet.games.minecraft2d.config.FrameDetails;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@Component
public class FrameNavigator extends KeyAdapter {

    private final FrameDetails frameDetails;
    private static final int STEP = 15;

    public FrameNavigator(FrameDetails frameDetails) {
        this.frameDetails = frameDetails;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        Point fp = frameDetails.getPosition();

        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> fp.y += STEP;
            case KeyEvent.VK_A -> fp.x -= STEP;
            case KeyEvent.VK_D -> fp.x += STEP;
            case KeyEvent.VK_S -> fp.y -= STEP;
        }

        frameDetails.setPosition(fp);
    }
}
