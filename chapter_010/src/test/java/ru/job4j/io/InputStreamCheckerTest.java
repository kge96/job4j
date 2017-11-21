package ru.job4j.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing InputStreamChecker.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 21.11.2017.
 */
public class InputStreamCheckerTest {
    /**
     * Test when number is odd.
     */
    @Test
    public void whenNumberIsOddThenResultIsTrue() {
        int number = 8;
        byte[] bytes = String.valueOf(number).getBytes();
        InputStream in = new ByteArrayInputStream(bytes);
        InputStreamChecker checker = new InputStreamChecker();
        boolean result = checker.isNumber(in);

        assertThat(result, is(true));
    }

    /**
     * Test when number is even.
     */
    @Test
    public void whenNumberIsEvenThenResultIsTrue() {
        int number = 1201;
        byte[] bytes = String.valueOf(number).getBytes();
        InputStream in = new ByteArrayInputStream(bytes);
        InputStreamChecker checker = new InputStreamChecker();
        boolean result = checker.isNumber(in);

        assertThat(result, is(false));
    }
}
