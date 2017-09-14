package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования для класса Max.
 * @author gkuznetsov.
 * @since 15.09.17.
 * @version 0.2.
 */
public class MaxTest {
    @Test
    public void whenOneAndTwoThenFive() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        int expected = 2;
        assertThat(result, is(expected));
    }
    @Test
    public void whenOneAndFiveAndTwoThenFive() {
        Max maxim = new Max();
        int result = maxim.max(1, 5, 2);
        int expected = 5;
        assertThat(result, is(expected));
    }
}
