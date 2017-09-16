package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test тест класса Counter.
 * @author gkuznetsov.
 * @since 15.09.17.
 * @version 0.1.
 */
public class CounterTest {
    @Test
    public void whenOneAndTenThenThirty() {
        Counter c1 = new Counter();
        int result = c1.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
    @Test
    public void whenTenAndOneThenThirty() {
        Counter c1 = new Counter();
        int result = c1.add(10, 1);
        int expected = 30;
        assertThat(result, is(expected));
    }
    @Test
    public void whenOneAndTwoThenTwo() {
        Counter c1 = new Counter();
        int result = c1.add(1, 2);
        int expected = 2;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFiveAndMinesFiveThenThirty() {
        Counter c1 = new Counter();
        int result = c1.add(5, -10);
        int expected = -24;
        assertThat(result, is(expected));
    }
    @Test
    public void whenZeroAndOneThenZero() {
        Counter c1 = new Counter();
        int result = c1.add(0, 1);
        int expected = 0;
        assertThat(result, is(expected));
    }
}
