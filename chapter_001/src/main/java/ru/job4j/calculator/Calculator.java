package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Класс-калькулятор.
 * @author gkuznetsov.
 * @since 14.09.17.
 * @version 0.1.
 */
public class Calculator {
    /**
     * List operation.
     */
    private List<String> operations = new ArrayList<>();

    /**
     * Calculator constructor.
     */
    public Calculator() {
        operations.add("add");
        operations.add("sub");
        operations.add("div");
        operations.add("mult");
    }
    /**
     * @param result - Результат вычисления.
     */
    private double result;
    /**
     * Метод для сложения двух чисел.
     * @param first первое число.
     * @param second второе число.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Метод для вычитания двух чисел.
     * @param first первое число.
     * @param second второе число.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Метод для деления двух чисел.
     * @param first делимое.
     * @param second делитель.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Метод для умножения двух чисел.
     * @param first первое число.
     * @param second второе число.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Метод для умножения двух чисел.
     * @return result возвращает значение переменной result.
     */
    public double getResult() {
        return result;
    }
    /**
     * Return List of operation.
     * @return List.
     */
    public List getMenuList() {
        return this.operations;
    }
}
