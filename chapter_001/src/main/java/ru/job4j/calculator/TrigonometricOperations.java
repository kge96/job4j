package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for creation Trigonometric modules.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.11.2017.
 */
public class TrigonometricOperations {
    /**
     * List operation.
     */
    private List<String> operations = new ArrayList<>();
    /**
     * Calc result.
     */
    private double result;
    /**
     * Unmodified list operation.
     */
    private List<String> unmodifiedList;

    /**
     * Constructor.
     */
    public TrigonometricOperations() {
        operations.add("sin");
        operations.add("cos");
        operations.add("log");
        operations.add("log10");

        unmodifiedList = Collections.unmodifiableList(operations);
    }

    /**
     * Sin method.
     * @param first - first param.
     */
    public void sin(double first) {
        this.result = Math.sin(first);
    }

    /**
     * Cos method.
     * @param first - value.
     */
    public void cos(double first) {
        this.result = Math.sin(first);
    }

    /**
     * Log method.
     * @param first - value.
     */
    public void log(double first) {
        this.result = Math.log(first);
    }

    /**
     * Log10 method.
     * @param first - value.
     */
    public void log10(double first) {
        this.result = Math.log(first);
    }

    /**
     * Return calculation result.
     * @return double.
     */
    public double getResult() {
        return result;
    }

    /**
     * Return menu list.
     * @return List.
     */
    public List getMenuList() {
        return this.unmodifiedList;
    }
}
