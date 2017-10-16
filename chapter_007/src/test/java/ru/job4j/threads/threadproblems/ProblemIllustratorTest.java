package ru.job4j.threads.threadproblems;

import org.junit.Test;

/**
 * Class for testing thread problems.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 16.10.2017.
 */
public class ProblemIllustratorTest {
    /**
     * Testing thread problems.
     */
    @Test
    public void whenStartThreadThenVariableAMastBeTenVariableBMustBeFour() {
        Demonstrate d = new Demonstrate();
        Thread t1 = new Thread(new ProblemIllustrator(d));
        Thread t2 = new Thread(new ProblemIllustrator(d));
        t1.start();
        t2.start();
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(d.getA());
        System.out.println(d.b);
    }

}
