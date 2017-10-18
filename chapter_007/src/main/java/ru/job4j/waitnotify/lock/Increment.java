package ru.job4j.waitnotify.lock;

/**
 * Class for lock testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class Increment implements Runnable {
    /**
     * Lock object.
     */
    private Lock lock = new Lock();
    /**
     * Count.
     */
    private int count = 0;

    /**
     * Do count increment.
     * @throws InterruptedException - exception.
     */
    public void doInc() throws InterruptedException {
        lock.lock();
        ++count;
        lock.unlock();
    }

    /**
     * Return count.
     * @return int.
     */
    public int getCount() {
        return count;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        try {
            doInc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
