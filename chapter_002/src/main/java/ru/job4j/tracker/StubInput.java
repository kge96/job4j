package ru.job4j.tracker;

/**
 * Class for...
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public void print(String message) {

    }
}
