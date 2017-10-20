package ru.job4j.threads.searcher;

/**
 * Class for counting finished threads.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 20.10.2017.
 */
public class FinishedThreadsCounter {
    /**
     * Threads count.
     */
    private volatile int threadsCount = 0;

    /**
     * Set count of threads.
     * @param threadsCount  - count of threads.
     */
    public void setThreadsCount(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    /**
     * Down count if this thread was finished.
     */
    public synchronized void downCount() {
        threadsCount -= 1;
    }

    /**
     * Retrurn count of running threads.
     * @return int.
     */
    public int getThreadsCount() {
        return this.threadsCount;
    }
}
