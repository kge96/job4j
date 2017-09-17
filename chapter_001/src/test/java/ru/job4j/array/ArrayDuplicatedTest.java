package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing ArrayDuplicated.
 * @author gkuznetsov.
 * @since 17.09.17.
 * @version 0.1.
 */

public class ArrayDuplicatedTest {
    /**
     * Testing array in which there are some duplicates.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Mike", "Rick", "John", "Joan", "Rick", "Mike", "Pit", "John"});
        String[] expected = new String[]{"Mike", "Rick", "John", "Joan", "Pit"};
        assertThat(result, is(expected));
    }
    /**
     * Testing array in which there are two duplicates.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Mike", "Rick", "Rick"});
        String[] expected = new String[]{"Mike", "Rick"};
        assertThat(result, is(expected));
    }
    /**
     * Testing array in which there are all duplicates.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate3() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Rick", "Rick", "Rick"});
        String[] expected = new String[]{"Rick"};
        assertThat(result, is(expected));
    }
}
