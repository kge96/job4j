package ru.job4j.waitnotify.threadpool;

import org.junit.Test;

/**
 * Class for testing thread pool.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class ThreadPoolTest {
    /**
     * Testing thread pool.
     * @throws InterruptedException - exception.
     */
    @Test
    public void testingThreadPool() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        threadPool.startThreadPool();
        for (int i = 0; i < 15; i++) {
            threadPool.addWork(new Work("work - " + i));
            if (i % 3 == 0) {
                Thread.sleep(3000);
            }
        }
    }
}
