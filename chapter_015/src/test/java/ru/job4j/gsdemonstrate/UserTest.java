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
        long start = System.currentTimeMillis();
        System.out.println("Start");
        User user = new User("Dima", 12, 1.78);
        System.out.println(user);
        user = null;

        for (int i = 0; i < 10000; i++) {
            if (i % 200 == 0) {
                System.out.println("Was created " + i + " Users");
                info();
            }
           new User("Dima", i, 1.78);

        }

        System.gc();

        info();
        System.out.println("finish");
        long total = System.currentTimeMillis() - start;
        System.out.println("Total time is " + total + " ms");
    }

    /**
     * Info method.
     */
    public void info() {
        /**
         * 1 Mb.
         */
        int kb = 1024;
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Heap utilization statistics [kb]");

        System.out.println("User Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / kb);

        System.out.println("Free Memory: " + runtime.freeMemory() / kb);

        System.out.println("Total Memory: " + runtime.totalMemory() / kb);

        System.out.println("Max Memory: " + runtime.maxMemory() / kb);
    }
}
