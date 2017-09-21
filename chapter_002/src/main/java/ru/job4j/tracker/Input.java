package ru.job4j.tracker;

/**
 * Interface for input data.
 *
 * @author gkuznetsov.
 * @since 20.09.17.
 * @version 0.1.
 */
public interface Input {
    /**
     * Ask question and return answer.
     * @param question - question.
     * @return String.
     */
    String ask(String question);

    /**
     * Print message at console.
     * @param message - message.
     */
    void print(String message);
}
