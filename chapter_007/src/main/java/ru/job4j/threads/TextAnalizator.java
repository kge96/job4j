package ru.job4j.threads;

/**
 * Class for start analize.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */
public class TextAnalizator {
    /**
     * Text.
     */
    private String text;

    /**
     * Constructor.
     * @param text - text.
     */
    public TextAnalizator(String text) {
        this.text = text;
    }

    /**
     * Start analize.
     */
    public void analizeText() {
        Thread t1 = new Thread(new LetterCounter(text));
        Thread t2 = new Thread(new SpacesCounter(text));
        try {
            t1.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();
    }
}
