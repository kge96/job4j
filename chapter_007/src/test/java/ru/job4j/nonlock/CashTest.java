package ru.job4j.nonlock;

import org.junit.Test;

/**
 * Class for testing Cash.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 19.10.2017.
 */
public class CashTest {
    /**
     * Update data testing.
     * @throws InterruptedException - exception.
     */
    @Test
    public void whenToThreadsModifyTheSameObjectThenRuntimeException() throws InterruptedException {
        Cash cash = new Cash();
        cash.add(new Task(1, "A"));
        cash.add(new Task(2, "B"));
        cash.add(new Task(3, "C"));
        cash.add(new Task(4, "D"));


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Task newTask = new Task(1, "User-1");

                cash.update(newTask);
                System.out.println(Thread.currentThread().getName() + " is finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Task newTask = new Task(1, "User-2");
                cash.update(newTask);
                System.out.println(Thread.currentThread().getName() + " is finished");
            }
        });
        t1.start();
        t2.start();

        Thread.sleep(600);
        System.out.println(cash.getTask(1).getName());
    }
}
