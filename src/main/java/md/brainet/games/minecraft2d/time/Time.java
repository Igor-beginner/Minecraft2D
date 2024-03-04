package md.brainet.games.minecraft2d.time;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Time extends Thread{

    private static final int TICK_VALUE_MS = 20;
    private static final int DAY_MS = 20_000;
    private final AtomicInteger ticks;
    private final AtomicInteger days;


    public Time() {
        this.ticks = new AtomicInteger();
        this.days = new AtomicInteger();
    }

    @Override
    @PostConstruct
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                tick();
                if (ticks.get() >= DAY_MS) {
                    days.incrementAndGet();
                    ticks.set(0);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void tick() throws InterruptedException {
        ticks.incrementAndGet();
        Thread.sleep(1000 / TICK_VALUE_MS);
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
