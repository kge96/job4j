package ru.job4j.threads.threadproblems;

/**
 * Class for creating thread.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 16.10.2017.
 */
public class ProblemIllustrator implements Runnable {
    /**
     * Object for demonstrate thread problems.
     */
    Demonstrate d;

    /**
     * Constructor.
     * @param d - object link.
     */
    public ProblemIllustrator(Demonstrate d) {
        this.d = d;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            d.setA(d.getA() + 1);
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        d.b += 2;

    }
}
