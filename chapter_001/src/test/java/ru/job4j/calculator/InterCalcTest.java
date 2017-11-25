package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing calculator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.11.2017.
 */
public class InterCalcTest {
    /**
     * Testing 1 + 4.
     */
    @Test
    public void whenAddOneAndFourThenGetFivePointO() {
        InteractCalc calc = new InteractCalc();
        double result = calc.startCalc("1", "4", 1);
        assertThat(result, is(5.0));
    }
    /**
     * Testing 1 - 4.
     */
    @Test
    public void whenSubtractOneAndFourThenGetMinesThreePointO() {
        InteractCalc calc = new InteractCalc();
        double result = calc.startCalc("1", "4", 2);
        assertThat(result, is(-3.0));
    }
    /**
     * Testing 10/2.5.
     */
    @Test
    public void whenDivTenAndTowPointFiveThenGetFourPointO() {
        InteractCalc calc = new InteractCalc();
        double result = calc.startCalc("10", "2.5", 3);
        assertThat(result, is(4.0));
    }
    /**
     * Testing 2 * 5.
     */
    @Test
    public void whenMultiplyTowAndFiveThenGetTenPointO() {
        InteractCalc calc = new InteractCalc();
        double result = calc.startCalc("2", "5", 4);
        assertThat(result, is(10.0));
    }
    /**
     * Testing M = 5 + 5, then M + 5.
     */
    @Test
    public void whenAddMAndFiveThenGetFifteenPointO() {
        InteractCalc calc = new InteractCalc();
        calc.startCalc("5", "5", 1);
        double result = calc.startCalc("M", "5", 1);
        assertThat(result, is(15.0));
    }
}
