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
     * @throws InterruptedException - exception.
     */
    public void analizeText() throws InterruptedException {
        System.out.println("Start analizing text");
        Thread t1 = new Thread(new LetterCounter(text));
        Thread t2 = new Thread(new SpacesCounter(text));
        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println("Finish analizing text");
    }
}
