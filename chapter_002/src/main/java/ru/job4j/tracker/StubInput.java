package ru.job4j.tracker;

/**
 * Class for answers to tests.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class StubInput implements Input {
    /**
     * Answers array.
     */
    private String[] answers;
    /**
     * Answer position in array.
     */
    private int position = 0;

    /**
     * Constructor.
     * @param answers - answers array.
     */

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Take question and return answers from answers arry.
     * @param question - question.
     * @return String.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * No operation.
     * @param message - message.
     */
    @Override
    public void print(String message) {
        //NOP
    }
}
