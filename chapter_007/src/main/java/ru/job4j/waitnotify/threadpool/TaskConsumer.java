package ru.job4j.waitnotify.threadpool;

/**
 * Class - taskConsumer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 18.10.2017.
 */
public class TaskConsumer implements Runnable {
    /**
     * Work storage.
     */
    private TaskBuffer taskBuffer;

    /**
     * TaskConsumer constructor.
     * @param taskBuffer - work storage
     */
    public TaskConsumer(TaskBuffer taskBuffer) {
        this.taskBuffer = taskBuffer;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        try {
            while (true) {
               Work work = taskBuffer.getTask();
                System.out.println(String.format("%s get work %s", Thread.currentThread().getName(), work.getName()));
                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
