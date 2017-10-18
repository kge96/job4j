package ru.job4j.waitnotify.producerconsumer;

import org.junit.Test;

/**
 * Class for testing producer/consumer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class BufferTest {
    /**
     * Testing producer/consumer.
     * @throws InterruptedException - exception.
     */
    @Test
    public void whenStartProducerConsumerThenProducedAndConsumedTheSameCountElements() throws InterruptedException {
        Buffer buffer = new Buffer();
        Thread t1 = new Thread(new Consumer(buffer));
        Thread t2 = new Thread(new Producer(buffer));
        t1.start();
        t2.start();

        Thread.sleep(7000);
    }
}
