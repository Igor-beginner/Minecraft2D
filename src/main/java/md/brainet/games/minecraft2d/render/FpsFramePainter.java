package md.brainet.games.minecraft2d.render;

import md.brainet.games.minecraft2d.adapter.JLabelCoordinateAdapter;

public class FpsFramePainter implements Runnable{

    private int fps;
    private final JLabelCoordinateAdapter jLabelCoordinateAdapter;

    public FpsFramePainter(JLabelCoordinateAdapter jLabelCoordinateAdapter) {
        this.jLabelCoordinateAdapter = jLabelCoordinateAdapter;
        this.fps = 60;
    }

    @Override
    public void run() {
        while (true){
            long spendMs = renderFrameAndGetRenderMs();
            sleepConsideringSpendMs(spendMs);
        }
    }

    private long renderFrameAndGetRenderMs() {
        long timeBeforeUpdate = System.currentTimeMillis();
        jLabelCoordinateAdapter.revalidate();
        jLabelCoordinateAdapter.repaint();
        return System.currentTimeMillis() - timeBeforeUpdate;
    }

    private void sleepConsideringSpendMs(long ms){
        delay(getRestDelay(ms));
    }

    private int getRestDelay(long ms){
        return (int)((1000 / fps) - ms);
    }

    private void delay(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public int getFps() {
        return fps;
    }
}
