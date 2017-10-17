package ru.job4j.threads.threadsafe;

import org.junit.Test;
import ru.job4j.threads.treadsafe.ThreadSafe;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing thread safe.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 17.10.2017.
 */
public class ThreadSafeTest {
    /**
     *
     */
    @Test
    public void whenAddElementsThenItAddedToCollection() {
        ThreadSafe<Integer> threadSafe = new ThreadSafe<>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafe.add(0);
                threadSafe.add(1);
                threadSafe.contains(9);
                threadSafe.add(2);
                for (int val : threadSafe) {
                    System.out.println("thread-1 : " + val);
                }
                threadSafe.add(3);
                threadSafe.add(4);
                threadSafe.add(5);
                threadSafe.get(2);
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                threadSafe.add(6);
                threadSafe.add(7);

                for (int val : threadSafe) {
                    System.out.println("thread-2 : " + val);
                }

                threadSafe.add(8);
                threadSafe.remove(0);
            }
        });

        t1.start();
        t2.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThat(threadSafe.getSize(), is(8));
    }
}
