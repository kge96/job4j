package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class for testing Turn.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */

public class TurnTest {
    /**
     * Testing array with even amount of elements.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{4, 1, 6, 2});
        int[] expected = new int[] {2, 6, 1, 4};
        assertThat(result, is(expected));
    }

    /**
     * Testing array with odd amount of elements.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2, 3, 4, 5});
        int[] expected = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
