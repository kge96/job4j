package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс для тестирования класса Point.
 * @author gkuznetsov.
 * @since 14.09.17.
 * @version 0.1.
 */
public class PointTest {
    /**
     * Testing class Point.
     */
    @Test
    public void whenPointOnLineThenTrue() {
        Point a = new Point(1, 1);
        boolean rsl = a.is(0, 1);
        assertThat(rsl, is(true));
    }
}
