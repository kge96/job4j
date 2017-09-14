package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class Класс для тестирования простого калькулятора.
 * @author gkuznetsov.
 * @since 14.09.17.
 * @version 0.1.
 */
public class CalculatorTest {
    /**
     * Тестирование метода сложения калькулятора.
     */
    @Test
    public void whenAddOnePluseOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Тестирование метода вычитания калькулятора.
     */
    @Test
    public void whenSubtractThreeMinesOneThanZero() {
        Calculator calc = new Calculator();
        calc.subtract(3D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Тестирование метода умножения калькулятора.
     */
    @Test
    public void whenMultiplyTwoAndTwoThanFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4;
        assertThat(result, is(expected));
    }
    /**
     * Тестирование метода деления калькулятора.
     */
    @Test
    public void whenDivSixByTwoThanThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
}
