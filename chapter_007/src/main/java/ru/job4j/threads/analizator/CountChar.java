package ru.job4j.threads.analizator;

/**
 * Class for creating char counter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */
public class CountChar implements Runnable {
    /**
     * Text.
     */
    private String text;
    /**
     * Space count.
     */
    private int spaces = 0;
    /**
     * Letters count.
     */
    private int letters = 0;

    /**
     * Constructor.
     * @param text - text.
     */
    public CountChar(String text) {
        this.text = text;
    }

    /**
     * Run.
     */
    @Override
    public void run() {

        for (int i = 0; i < text.length(); i++) {
            if (!Thread.currentThread().isInterrupted()) {
                if (text.charAt(i) == 32) {
                    spaces++;
                } else {
                    letters++;
                }
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {
                    System.err.println("System timeout");
                    return;
                }
            } else {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(String.format("Count of space is - %s, count of other symboll is - %s", spaces, letters));
    }
}
