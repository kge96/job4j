package ru.job4j.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for creation handler.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public class UserInputHandler {
    /**
     * User answers.
     */
    private  String[] answer;

    /**
     * Method for reading user answer.
     * @return String[].
     */
    public String[] readUserAnswer() {
       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           answer = reader.readLine().split(" ");
       } catch (IOException e) {
           e.printStackTrace();
       }
        return answer;
   }
}
