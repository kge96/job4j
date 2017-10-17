package ru.job4j.threads.analizator;

/**
 * Class for time count.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */
public class Time implements Runnable {
    /**
     * Work time.
     */
    private long time;

    /**
     * Constructor.
     * @param time - work time.
     */
    public Time(long time) {
        this.time = time;
    }

    /**
     * Run.
     */
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(time);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
