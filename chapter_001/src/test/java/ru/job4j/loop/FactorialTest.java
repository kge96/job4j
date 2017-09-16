package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования Factorial.
 * @author gkuznetsov.
 * @since 15.09.17.
 * @version 0.1.
 */
public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial f1 = new Factorial();
        long result = f1.calc(5);
        long expected = 120;
        assertThat(result, is(expected));
    }
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial f1 = new Factorial();
        long result = f1.calc(0);
        long expected = 1;
        assertThat(result, is(expected));
    }
    @Test
    public void whenCalculateFactorialForMinusSixThenMinusOne() {
        Factorial f1 = new Factorial();
        long result = f1.calc(-6);
        long expected = -1;
        assertThat(result, is(expected));
    }
}
