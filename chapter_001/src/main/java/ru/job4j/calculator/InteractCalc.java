package ru.job4j.calculator;

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
    private Calculator calc = new Calculator();
    /**
     * Calculation result.
     */
    private double result;
    /**
     * Calculator menu.
     */
    private MenuShower menuShower = new MenuShower(calc.getMenuList());
    /**
     * User input handler.
     */
    private UserInputHandler handler = new UserInputHandler();

    /**
     * Method for starting calculator.
     * @param menu menu.
     */
    public void startCalc(MenuShower menu) {
        while (true) {
            try {
                String[] answer;
                menu.showCalcMenu();
                showDialog("Choose operation: ");
                answer = handler.readUserAnswer();
                int operation = Integer.parseInt(answer[0]);

                if (operation == menu.getList().size() + 1) {
                    break;
                }
                showDialog("Enter two values");
                answer = handler.readUserAnswer();
                doOperation(answer[0], answer[1], operation);
                showDialog("Result is : " + this.result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Start calc with param. Method for testing.
     *
     * @param arg1      - first argument.
     * @param arg2      - second argument.
     * @param operation - number of operation.
     * @return double.
     */
    public double startCalc(String arg1, String arg2, int operation) {
        if (operation == menuShower.getList().size() + 1) {
            showDialog("By");
        }
        this.result = doOperation(arg1, arg2, operation);
        return this.result;
    }

    /**
     * Method for showing dialog.
     *
     * @param question - question or phrase.
     */
    protected void showDialog(String question) {
        System.out.println(question);
    }

    /**
     * Parse string to double.
     *
     * @param str - string.
     * @return double.
     */
    protected double parseStringToFloat(String str) {
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
     *
     * @param arg1      - first argument.
     * @param arg2      - second argument.
     * @param operation - operation.
     * @return double.
     */
    protected double doOperation(String arg1, String arg2, int operation) {
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

    /**
     * Return menu shower.
     * @return MenuShower.
     */
    protected MenuShower getMenuShower() {
        return this.menuShower;
    }
}
