package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class for input data.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 20.09.17.
 */
public class ConsoleInput implements Input {
    /**
     * Take data from console.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask question and return answer.
     * @param question - question.
     * @return String.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Ask question and return answer.
     * @param question - question.
     * @param range - range of menu.
     * @return String.
     */
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
           if (value == key) {
               exist = true;
               break;
           }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }

    /**
     * Print message at console.
     * @param message - message.
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
