package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing SetArrayContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 */
public class SetArrayContainerTest {
    /**
     * Testing add new elements to container.
     */
    @Test
    public void whenAddNewElementThenItAdded() {
        SetArrayContainer<Integer> container = new SetArrayContainer<>(1);
        container.add(1);
        container.add(2);
        container.add(3);
        assertThat(container.get(2), is(3));
    }

    /**
     * Testing add the same elements.
     */
    @Test
    public void whenAddNewElementAndTheSameThenTheSameNotAdded() {
        SetArrayContainer<Integer> container = new SetArrayContainer<>(1);
        container.add(1);
        container.add(2);
        container.add(1);
        container.add(3);
        assertThat(container.get(2), is(3));
    }
}

