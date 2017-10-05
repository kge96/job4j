package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing CyclicalDetector.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.10.2017.
 */
public class CyclicalDetectorTest {
    /**
     * Testing when node has cyclical.
     */
    @Test
    public void whenNodeIsCyclicThenHasCycleReturnTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        boolean result = new CyclicalDetector<Node>().hasCycle(two);
        assertThat(result, is(true));
    }
    /**
     * Testing when node has not cyclical.
     */
    @Test
    public void whenNodeIsNotCyclicThenHasCycleReturnFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        third.setNext(four);
        four.setNext(first);

        boolean result = new CyclicalDetector<Node>().hasCycle(first);
        assertThat(result, is(false));
    }
}
