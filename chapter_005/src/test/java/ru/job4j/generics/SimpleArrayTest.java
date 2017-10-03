package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing simple array.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public class SimpleArrayTest {
    /**
     * Add Integer element in array.
     */
    @Test
    public void whenAddNewIntegerElementThenItInArray() {
        SimpleArray<Integer> array = new SimpleArray();
        array.add(10);
        assertThat(array.get(0), is(10));
    }

    /**
     * Update Integer element.
     */
    @Test
    public void whenUpdateIntegerElementThenItInUpdated() {
        SimpleArray<Integer> array = new SimpleArray();
        array.add(10);
        array.add(18);
        array.update(0, 5);
        assertThat(array.get(0), is(5));
    }

    /**
     * Delete Integer element.
     */
    @Test
    public void whenDeleteIntegerElementThenItInUpdated() {
        SimpleArray<Integer> array = new SimpleArray();
        array.add(10);
        array.add(18);
        array.add(15);
        array.delete(1);
        System.out.println(array.size());
        assertThat(array.get(1), is(15));
    }

    /**
     * Add String element.
     */
    @Test
    public void whenAddNewStringElementThenItInArray() {
        SimpleArray<String> array = new SimpleArray();
        array.add("111");
        assertThat(array.get(0), is("111"));
    }
}
