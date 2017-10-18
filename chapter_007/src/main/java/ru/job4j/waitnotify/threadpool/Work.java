package ru.job4j.waitnotify.threadpool;

/**
 * Class for creating task.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class Work {
    /**
     * Work name.
     */
    private String workName;

    /**
     * Work constructor.
     * @param workName - work name.
     */
    public Work(String workName) {
        this.workName = workName;
    }

    /**
     * Do some work.
     * @throws InterruptedException - exception.
     */
    public void doWork() throws InterruptedException {
        Thread.sleep(100);
    }

    /**
     * Return work name.
     * @return String.
     */
    public String getName() {
        return this.workName;
    }

}
