package ru.job4j.calculator;

/**
 * Class for create ingineer calculator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public class EngineeringCalculator extends InteractCalc {
    /**
     * Result of calculation.
     */
    private double result;
    /**
     * Object with calc methods.
     */
    private Calculator calc = new Calculator();
    /**
     * Trigonometric module.
     */
    private TrigonometricOperations trig = new TrigonometricOperations();
    /**
     * Calculator menu.
     */
    private MenuShower menuShower = new MenuShower(calc.getMenuList(), trig.getMenuList());
    /**
     * Start calc with param. Method for testing.
     *
     * @param arg - argument.
     * @param operation - number of operation.
     * @return double.
     */
    public double startCalc(String arg, int operation) {
        if (operation == menuShower.getList().size() + 1) {
            showDialog("By");
        }
        this.result = doOperation(arg, operation);
        return this.result;
    }
    /**
     * Run operation.
     * @param arg - arg.
     * @param operation - operation.
     * @return double.
     */
    protected double doOperation(String arg, int operation) {
        double firstArg = parseStringToFloat(arg);
        switch (operation) {
            case 5:
                trig.sin(firstArg);
                break;
            case 6:
                trig.cos(firstArg);
                break;
            case 7:
                trig.log(firstArg);
                break;
            case 8:
                trig.log10(firstArg);
                break;
            default:
                break;
        }
        return trig.getResult();
    }
    @Override
    public double startCalc(String arg1, String arg2, int operation) {
        return super.startCalc(arg1, arg2, operation);
    }

    @Override
    protected double doOperation(String arg1, String arg2, int operation) {
        return super.doOperation(arg1, arg2, operation);
    }

    @Override
    protected MenuShower getMenuShower() {
        return this.menuShower;
    }
}
