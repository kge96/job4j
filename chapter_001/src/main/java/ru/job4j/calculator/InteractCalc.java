package ru.job4j.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for creating interuct calc.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 22.11.2017.
 */
public class InteractCalc {
    /**
     * Object with calc methods.
     */
    private final Calculator calc = new Calculator();
    /**
     * Calculation result.
     */
    private double result;
    /**
     * Reader for getting data from user.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Calculator menu.
     */
    private String menu = "1)add\n2)subtract\n3)div\n4)Multiple\n5) Quit\n*For using old result enter M";

    /**
     * Method for starting calculator.
     */
    public void startCalc() {
        while (true) {
            try {
                showCalcMenu();

                showDialog("Choose operation: ");
                String answer = reader.readLine();
                int operation = Integer.parseInt(answer);
                if (operation == 5) {
                    break;
                }
                showDialog("Enter two numbers");
                String[] numbers = reader.readLine().split(" ");
                doOperation(numbers[0], numbers[1], operation);
                showDialog("Result is : " + this.result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Start calc with param. Method for testing.
     * @param arg1 - first argument.
     * @param arg2 - second argument.
     * @param operation - number of operation.
     * @return double.
     */
    public double startCalc(String arg1, String arg2, int operation) {

        showDialog("Was choosed operation: " + operation);
        if (operation == 5) {
            showDialog("By");
        }
        this.result = doOperation(arg1, arg2, operation);
        return this.result;
    }

    /**
     * Show calculator menu.
     */
    private void showCalcMenu() {
        System.out.println(menu);
    }

    /**
     * Method for showing dialog.
     * @param question - question or phrase.
     */
    private void showDialog(String question) {
        System.out.println(question);
    }

    /**
     * Parse string to double.
     * @param str - string.
     * @return double.
     */
    private double parseStringToFloat(String str) {
        double result = 0;
        if (str.equals("M")) {
            result = this.result;
        } else {
            try {
                result = Double.parseDouble(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
      return result;
    }

    /**
     * Method for running choosen operation.
     * @param arg1 - first argument.
     * @param arg2 - second argument.
     * @param operation - operation.
     * @return double.
     */
    private double doOperation(String arg1, String arg2, int operation) {
        double firstArg = parseStringToFloat(arg1);
        double secondArg = parseStringToFloat(arg2);

        if (operation == 1) {
            calc.add(firstArg, secondArg);
        } else if (operation == 2) {
            calc.subtract(firstArg, secondArg);
        } else if (operation == 3) {
            calc.div(firstArg, secondArg);
        } else if (operation == 4) {
            calc.multiple(firstArg, secondArg);
        }
        return calc.getResult();
    }
}
