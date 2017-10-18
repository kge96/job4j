package ru.job4j.waitnotify.producerconsumer;

/**
 * Class - Producer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class Producer implements Runnable {
    /**
     * Start value.
     */
    private int startValue = 0;
    /**
     * Buffer.
     */
    private Buffer buffer;

    /**
     * Producer constructor.
     * @param buffer - data storage.
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(startValue + " produced");
                buffer.setValue(startValue++);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
