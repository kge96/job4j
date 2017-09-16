package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Сlass for testing Paint.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */

public class TestPaint {
    private final String line = System.getProperty("line.separator");
    @Test
    public void whenPiramidWithHeightThreeThenThreeRows() {
        Paint paint = new Paint();
        String result = paint.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", line, line, line);
        assertThat(result, is(expected));
    }
    @Test
    public void whenPiramidWithHeightTwoThenTowRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^%s", line, line, line);
        assertThat(result, is(expected));
    }

}
