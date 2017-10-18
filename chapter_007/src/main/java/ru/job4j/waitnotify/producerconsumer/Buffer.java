package ru.job4j.waitnotify.producerconsumer;

/**
 * Class - buffer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class Buffer {
    /**
     * Value.
     */
    private Integer value = null;

    /**
     * Set value.
     * @param newValue - new value.
     * @throws InterruptedException - exception.
     */
    public synchronized void setValue(int newValue) throws InterruptedException {
        while (value != null) {
            this.wait();
        }
        this.value = newValue;
        this.notify();
    }

    /**
     * Get value.
     * @return value.
     * @throws InterruptedException - exception.
     */
    public synchronized int getValue() throws InterruptedException {
        while (value == null) {
            this.wait();
        }
        int result = this.value;
        this.value = null;
        this.notify();
        return result;
    }
}
