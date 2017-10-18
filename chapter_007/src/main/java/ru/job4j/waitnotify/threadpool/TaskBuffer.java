package ru.job4j.waitnotify.threadpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for creating task buffer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class TaskBuffer {
    /**
     * Task storage.
     */
    private Queue<Work> taskQueue = new LinkedList<Work>();

    /**
     * Put task to collection.
     * @param work - work.
     * @throws InterruptedException - exception.
     */
    public synchronized void setTask(Work work) throws InterruptedException {
        while (taskQueue.size() > 10) {
            this.wait();
        }
        taskQueue.add(work);
        this.notifyAll();
    }

    /**
     * Return work.
     * @return Work.
     * @throws InterruptedException - exception.
     */
    public synchronized Work getTask() throws InterruptedException {
        while (taskQueue.size() == 0) {
            this.wait();
        }
        Work work = taskQueue.poll();
        this.notifyAll();
        return work;
    }
}
