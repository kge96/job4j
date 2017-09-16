package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing RotateArray.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */

public class TestRotateArray {
    /**
     * Testing array rotation, size 2x2.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{
                {1, 3},
                {2, 4},
        });
        int[][] expected = new int[][] {
                {3, 4},
                {1, 2},
        };
        assertThat(result, is(expected));
    }
    /**
     * Testing array rotation, size 3x3.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        });
        int[][] expected = new int[][] {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3},
        };
        assertThat(result, is(expected));
    }
    /**
     * Testing array rotation, size 5x5.
     */
    @Test
    public void whenRotateFiveRowFiveColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(new int[][]{
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        });
        int[][] expected = new int[][] {
                {13, 14, 15, 16},
                {9, 10, 11, 12},
                {5, 6, 7, 8},
                {1, 2, 3, 4}
        };
        assertThat(result, is(expected));
    }
}
