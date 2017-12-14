package ru.job4j.gsdemonstrate;

import org.junit.Test;

/**
 * Class for testing garbage collector.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.12.2017.
 */
public class UserTest {
    /**
     * Test.
     */
    @Test
    public void testGC() {
        System.out.println("Start");
        User user = new User("Dima", 12, 1.78);
        System.out.println(user);
        user = null;

        for (int i = 0; i < 1000; i++) {
            if (i == 250 || i == 500 || i == 750) {
                info();
            }
            System.out.println(new User("Dima", i, 1.78));

        }

        System.gc();

        System.out.println("finish");
        info();

    }

    /**
     * Info method.
     */
    public void info() {
        /**
         * 1 Mb.
         */
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Heap utilization statistics [Mb]");

        System.out.println("User Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        System.out.println("Free Memory: " + runtime.freeMemory() / mb);

        System.out.println("Total Memory: " + runtime.totalMemory() / mb);

        System.out.println("Max Memory: " + runtime.maxMemory() / mb);
    }
}
