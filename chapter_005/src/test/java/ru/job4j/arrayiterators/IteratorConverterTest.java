package ru.job4j.arrayiterators;

import org.junit.Test;
import ru.job4j.arrayiteratos.IteratorConverter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing IteratorConverter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class IteratorConverterTest {

    /**
     * Iterator test.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDoNextForLastElementThenThrowNoSuchElementException() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        IteratorConverter converter = new IteratorConverter();
        Iterator<Integer> it = converter.convert(its);

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        it.next();
    }

    /**
     * ConvertIterator test.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDoNextForLastElementThenThrowNoSuchElementException2() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        IteratorConverter converter = new IteratorConverter();
        Iterator<Integer> it = converter.convert(its);

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * ConvertIterator test.
     */
    @Test
    public void whenAddOneElementAndOneArrayThenItAdded() {
        Iterator<Integer> it1 = Arrays.asList(1).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1).iterator();
        IteratorConverter converter = new IteratorConverter();
        Iterator<Integer> it = converter.convert(its);

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
    }
}

