package ru.job4j.arrayiterators;


import org.junit.Test;
import ru.job4j.arrayiteratos.TwodimensionalArrayIterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing TwodimensionalArrayIterator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class TwodimensionalArrayIteratorTest {
    /**
     * Testing next() method.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        TwodimensionalArrayIterator it = new TwodimensionalArrayIterator(new int[][] {{1, 2, 3}, {4, 5, 6, 7}});
        it.next();
        it.next();
        it.next();
        it.next();
        int result = (int) it.next();
        assertThat(result, is(5));
    }

    /**
     * Testing hasNext() method.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        TwodimensionalArrayIterator it = new TwodimensionalArrayIterator(new int[][] {{1}, {0}});
        it.next();
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(false));
    }
}
