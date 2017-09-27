package ru.job4j.listconverter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class for testing list convrerter.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.09.2017.
 */
public class ConvertListTest {
    /**
     * Testing convertation array to List.
     */
    @Test
    public void whenConvertArrayThenReturnArrayList() {
        ConvertList cl = new ConvertList();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
        List<Integer> result = cl.toList(arr);
        List<Integer> expected = new LinkedList<>();
        for (int i = 1; i < 9; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }

    /**
     * Testing convertation LinkedList to array.
     */
    @Test
    public void whenConvertLinkedListThenReturnArray() {
        ConvertList cl = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            list.add(i);
        }
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[][] result = cl.toArray(list, 3);
        assertThat(result, is(expected));
    }
    /**
     * Testing convertation ArrayList to array.
     */
    @Test
    public void whenConvertArrayListThenReturnArray() {
        ConvertList cl = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] result = cl.toArray(list, 3);
        assertThat(result, is(expected));
    }

    /**
     * Testing convert list of integer arrays to list of integer values from arrays.
     */
    @Test
    public void whenConvertListOfArraysThenListOfIntegerValues() {
        ConvertList convertList = new ConvertList();
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5});
        List result = convertList.convert(list);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }
    /**
     * Testing convert list of integer arrays to list of integer values from arrays.
     */
    @Test
    public void whenConvertListOfArraysThenListOfIntegerValues2() {
        ConvertList convertList = new ConvertList();
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        list.add(new int[]{});
        List result = convertList.convert(list);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < 2; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }
    /**
     * Testing convertation ArrayList to array.
     */
    @Test
    public void whenConvertArrayListThenReturnArray2() {
        ConvertList cl = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
        int[][] expected = {{1, 2}, {3, 4}, {5, 0}};
        int[][] result = cl.toArray(list, 3);
        assertThat(result, is(expected));
    }
    /**
     * Testing convertation ArrayList to array.
     */
    @Test
    public void whenConvertArrayListThenReturnArray3() {
        ConvertList cl = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        int[][] expected = {{1}, {2}, {3}};
        int[][] result = cl.toArray(list, 3);
        assertThat(result, is(expected));
    }
}
