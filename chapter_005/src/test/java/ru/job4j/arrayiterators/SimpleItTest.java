package ru.job4j.arrayiterators;

import org.junit.Test;
import ru.job4j.arrayiteratos.SimpleIt;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing SimpleIt.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class SimpleItTest {
    /**
     * Testing next() method.
     */
    @Test
    public void whenGetNextCallShouldPointerForward3() {
        Iterator it = new SimpleIt((new int[] {3, 4, 5, 6, 7}));
        it.next();
        it.next();
        int result = (int) it.next();
        assertThat(result, is(7));
    }
    /**
     * Testing hasNext() method.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        Iterator it = new SimpleIt((new int[] {4, 1, 1, 1, 79}));
        it.next();

        boolean result = it.hasNext();
        assertThat(result, is(false));
    }
}
