package md.brainet.games.minecraft2d.time;

import java.util.concurrent.atomic.AtomicInteger;

public class GameTime implements Runnable {

    private static final int TICK_DURATION_IN_MS = 20;
    private static final int DAY_DURATION_IN_TICKS = 20_000;

    private final AtomicInteger ticks;
    private final AtomicInteger days;

    public GameTime() {
        this.ticks = new AtomicInteger();
        this.days = new AtomicInteger();
    }

    @Override
    public void run() {
        while (true) {
            performTick();
        }
    }

    private void performTick() {
        incrementTickOrDay();
        delay();
    }

    private void incrementTickOrDay(){
        ticks.incrementAndGet();
        if (isNextDay()) {
            incrementDay();
        }
    }

    private void incrementDay() {
        days.incrementAndGet();
        ticks.set(0);
    }

    private boolean isNextDay() {
        return ticks.get() >= DAY_DURATION_IN_TICKS;
    }

    private void delay() {
        try {
            Thread.sleep(TICK_DURATION_IN_MS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTicks() {
        return ticks.get();
    }

    public int getDays() {
        return days.get();
    }

    public void setTicks(int ticks) {
        this.ticks.set(ticks);
    }

    public void setDays(int days) {
        this.days.set(days);
    }
}
