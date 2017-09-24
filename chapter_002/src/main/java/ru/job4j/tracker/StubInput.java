package ru.job4j.tracker;

/**
<<<<<<< HEAD
 * Class for answers to tests.
=======
 * Class for...
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class StubInput implements Input {
<<<<<<< HEAD
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

=======
    private String[] answers;
    private int position = 0;

>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    public StubInput(String[] answers) {
        this.answers = answers;
    }

<<<<<<< HEAD
    /**
     * Take question and return answers from answers arry.
     * @param question - question.
     * @return String.
     */
=======
>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    @Override
    public String ask(String question) {
        return answers[position++];
    }
<<<<<<< HEAD
    /**
     * Ask question and return answer.
     * @param question - question.
     * @param range - range of menu.
     * @return String.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return exist ? key : -1;
    }

    /**
     * No operation.
     * @param message - message.
     */
    @Override
    public void print(String message) {
        System.out.println(message);
=======

    @Override
    public void print(String message) {

>>>>>>> 95085e8e37bcdd5ff595144ad46f94165cb477bf
    }
}
