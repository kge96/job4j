package ru.job4j.arrayiterators;

import org.junit.Test;
import ru.job4j.arrayiteratos.EvenIt;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for tasting simple even numbers iterator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class EvenItTest {
    /**
     * Testing next() method.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        Iterator it = new EvenIt((new int[] {4, 2, 1, 1, 6}));
        it.next();
        it.next();
        int result = (int) it.next();
        assertThat(result, is(6));
    }
    /**
     * Testing next() method.
     */
    @Test
    public void whenGetNextCallShouldPointerForward2() {
        Iterator it = new EvenIt((new int[] {4, 2, 1, 1 }));
        it.next();
        int result = (int) it.next();
        assertThat(result, is(2));
    }
    /**
     * Testing next() method.
     */
    @Test
    public void whenGetNextCallShouldPointerForward3() {
        Iterator it = new EvenIt((new int[] {1, 3, 5, 4, 2, 1, 1 }));
        int result = (int) it.next();
        assertThat(result, is(4));
    }
    /**
     * Testing hasNext() method.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        Iterator it = new EvenIt((new int[] {4, 2, 1, 1}));
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(true));
    }
    /**
     * Testing hasNext() method.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue2() {
        Iterator it = new EvenIt((new int[] {1, 2, 3, 5, 6}));
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(true));
    }
    /**
     * Testing hasNext() method.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue3() {
        Iterator it = new EvenIt((new int[] {1, 2, 3, 5, 7}));
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(false));
    }
}
