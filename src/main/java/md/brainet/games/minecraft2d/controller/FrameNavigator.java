package md.brainet.games.minecraft2d.controller;

import md.brainet.games.minecraft2d.view.GameFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@Component
public class FrameNavigator extends KeyAdapter {

    private GameFrame gameFrame;
    private static final int STEP = 15;

    @Autowired
    @Lazy
    public void setGameFrame(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point windP = gameFrame.getLocation();
        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> windP.y += STEP;
            case KeyEvent.VK_A -> windP.x -= STEP;
            case KeyEvent.VK_D -> windP.x += STEP;
            case KeyEvent.VK_S -> windP.y -= STEP;
        }
    }
}
