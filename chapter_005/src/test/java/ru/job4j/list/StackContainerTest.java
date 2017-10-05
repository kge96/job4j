package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing StackContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.10.2017.
 */
public class StackContainerTest {
    /**
     * Test String poll.
     */
    @Test
    public void whenAdd() {
        StackContainer<String> stackContainer = new StackContainer<>();
        stackContainer.push("A");
        stackContainer.push("B");
        stackContainer.push("C");
        stackContainer.poll();
        stackContainer.poll();
        String result = stackContainer.poll();
        assertThat(result, is("A"));
    }
    /**
     * Testing Integer poll.
     */
    @Test
    public void whenPollIntegerElementThenItReturn() {
        StackContainer<Integer> stackContainer = new StackContainer<>();
        stackContainer.push(1);
        stackContainer.push(2);
        stackContainer.push(3);
        stackContainer.poll();
        stackContainer.poll();
        int result = stackContainer.poll();
        assertThat(result, is(1));
    }
}
