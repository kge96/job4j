package ru.job4j.waitnotify.lock;

/**
 * Class for locking.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class Lock {
    /**
     * Lock flag.
     */
    private boolean isLocked = false;

    /**
     * Lock current thread.
     * @throws InterruptedException - exception.
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    /**
     * Unlock current thread.
     */
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
