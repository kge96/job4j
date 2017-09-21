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
     * Print message at console.
     * @param message - message.
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
