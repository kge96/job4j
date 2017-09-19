package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing MergingArrays.
 * @author gkuznetsov.
 * @since 19.09.17.
 * @version 0.1.
 */

public class MergingArraysTest {
    /**
     * Test merging when first array less then second.
     */
    @Test
    public void whenTwoSortedArraysFirstLessThenToInOneSortedArray() {
        MergingArrays mergingArrays = new MergingArrays();
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {1, 2, 4, 6, 8};
        int[] result = mergingArrays.mergeArray(arr1, arr2);
        int[] expected = {1, 1, 2, 3, 4, 5, 6, 8};
        assertThat(result, is(expected));
    }
    /**
     * Test merging when second array less then first.
     */
    @Test
    public void whenTwoSortedArraysSecondLessThenToInOneSortedArray2() {
        MergingArrays mergingArrays = new MergingArrays();
        int[] arr1 = {1, 3, 5, 10, 11, 16, 22};
        int[] arr2 = {1, 2, 4, 6, 8};
        int[] result = mergingArrays.mergeArray(arr1, arr2);
        int[] expected = {1, 1, 2, 3, 4, 5, 6, 8, 10, 11, 16, 22};
        assertThat(result, is(expected));
    }
}
