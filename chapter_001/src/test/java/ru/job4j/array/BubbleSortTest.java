package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing BubbleSort.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */

public class BubbleSortTest {
    /**
     * Массив из 10 элементов.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] resultBubbleSort = bubbleSort.sort(new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        int[] expectedBubbleSort = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(resultBubbleSort, is(expectedBubbleSort));
    }

    /**
     * Массив из одного элемента.
     */
    @Test
    public void whenSortArrayWithOneElementsThenReturnSame() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] resultBubbleSort = bubbleSort.sort(new int[] {1});
        int[] expectedBubbleSort = new int[]{1};
        assertThat(resultBubbleSort, is(expectedBubbleSort));
    }

    /**
     * Пустой массив.
     */
    @Test
    public void whenSortEmptyArrayThenReturnSame() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] resultBubbleSort = bubbleSort.sort(new int[] {});
        int[] expectedBubbleSort = new int[]{};
        assertThat(resultBubbleSort, is(expectedBubbleSort));
    }
}
