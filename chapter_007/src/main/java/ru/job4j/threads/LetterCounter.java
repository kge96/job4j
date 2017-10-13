package ru.job4j.threads;

/**
 * Class for count letters.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */
public class LetterCounter implements Runnable {
    /**
     * Text.
     */
    private String text;
    /**
     * Count of letters.
     */
    private int letters = 0;

    /**
     * Constructor.
     * @param text - text.
     */
    public LetterCounter(String text) {
        this.text = text;
    }

    /**
     * Run method for start threading.
     */
    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != 32) {
                    letters++;
                }
            }
            System.out.println(String.format("Count of spaces - %s", letters));

        } else {
            System.err.println("System timeout from spaces counter");
            return;
        }

    }
}
