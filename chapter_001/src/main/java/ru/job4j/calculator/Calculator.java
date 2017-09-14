package ru.job4j.calculator;

/**
 *Class Класс-калькулятор.
 * @author gkuznetsov.
 * @since 14.09.17.
 * @version 0.1.
 */
public class Calculator {
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
}
