package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирования для класса Max.
 */
public class MaxTest {
    @Test
    public void whenOneAndFiveThenFive() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        int expected = 2;
        assertThat(result, is(expected));
    }
}
