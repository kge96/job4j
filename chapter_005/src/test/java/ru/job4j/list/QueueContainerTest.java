package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing QueueContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.10.2017.
 */
public class QueueContainerTest {
    /**
     * Test String poll.
     */
    @Test
    public void whenPollStringElementThenItReturn() {
        QueueContainer<String> queueContainer = new QueueContainer<>();
        queueContainer.push("A");
        queueContainer.push("B");
        queueContainer.push("C");
        queueContainer.poll();
        queueContainer.poll();
        String result = queueContainer.poll();
        assertThat(result, is("C"));
    }

    /**
     * Testing Integer poll.
     */
    @Test
    public void whenPollIntegerElementThenItReturn() {
        QueueContainer<Integer> queueContainer = new QueueContainer<>();
        queueContainer.push(1);
        queueContainer.push(2);
        queueContainer.push(3);
        queueContainer.poll();
        queueContainer.poll();
        int result = queueContainer.poll();
        assertThat(result, is(3));
    }
}
