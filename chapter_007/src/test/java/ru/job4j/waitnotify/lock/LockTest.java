package ru.job4j.waitnotify.lock;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Lock.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class LockTest {
    /**
     * Testing lock.
     * @throws InterruptedException - exception.
     */
    @Test
    public void whenDoIncrementInDifferentThreadThenItIsThree() throws InterruptedException {
        Increment increment = new Increment();
        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        Thread t3 = new Thread(increment);

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(300);
        int result = increment.getCount();

        assertThat(result, is(3));
    }
}
