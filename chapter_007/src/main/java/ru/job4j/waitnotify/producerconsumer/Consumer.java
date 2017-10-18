package ru.job4j.waitnotify.producerconsumer;

/**
 * Class - Consumer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class Consumer implements Runnable {
    /**
     * Data storage.
     */
    private final Buffer buff;

    /**
     * Consumer constructor.
     * @param buff - data storage.
     */
    public Consumer(Buffer buff) {
        this.buff = buff;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        try {
            while (true) {
                int value = buff.getValue();
                System.out.println(value + " consumed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
