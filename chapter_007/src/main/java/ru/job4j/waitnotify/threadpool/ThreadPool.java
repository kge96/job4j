package ru.job4j.waitnotify.threadpool;

import java.util.ArrayList;

/**
 * Class for creating ThreadPool.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class ThreadPool {
    /**
     * Count of computer processors.
     */
    private int consumersCount;

    /**
     * Task storage.
     */
    private TaskBuffer taskBuffer = new TaskBuffer();

    /**
     * Threads storage.
     */
    private ArrayList<Thread> threads = new ArrayList<>();

    /**
     * Thread pool constructor.
     */
    public ThreadPool() {
        this.consumersCount =  Runtime.getRuntime().availableProcessors();
    }

    /**
     * Starting thread pool.
     */
    public void startThreadPool() {
        for (int i = 0; i < consumersCount; i++) {
            threads.add(new Thread(new TaskConsumer(taskBuffer)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    /**
     * Add new work task.
     * @param work - work.
     * @throws InterruptedException - exception.
     */
    public void addWork(Work work) throws InterruptedException {
        taskBuffer.setTask(work);
    }
}
