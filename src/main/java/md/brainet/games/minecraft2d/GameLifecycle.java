package md.brainet.games.minecraft2d;

import jakarta.annotation.PostConstruct;
import md.brainet.games.minecraft2d.view.LevelRender;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class GameLifecycle extends Thread{
    private final LevelRender levelRender;
    private int fps = 59;

    public GameLifecycle(LevelRender levelRender) {
        this.levelRender = levelRender;
    }

    @Override
    @PostConstruct
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        try {
            cycle();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void cycle() throws InterruptedException {
        while (true){
            frameRender();
        }
    }

    private void frameRender() throws InterruptedException {
        long timeBeforeUpdate = System.currentTimeMillis();
        levelRender.updateFrame();
        long timeRender = System.currentTimeMillis() - timeBeforeUpdate;
        int delay = (int)((1000 / fps) - timeRender);
        Thread.sleep(delay);
    }

    public void setFps(int fps) {
        this.fps = fps;
    }
}
