package ru.job4j.threads.threadproblems;

/**
 * Class for demonstrate thread access problems.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 16.10.2017.
 */
public class Demonstrate {
    /**
     * Variable a.
     */
    private int a = 0;

    /**
     * Return a.
     * @return a.
     */
    public int getA() {
        return this.a;
    }

    /**
     * Set value for a.
     * @param a - value.
     */
    public void setA(int a) {
        this.a = a;
    }
}
