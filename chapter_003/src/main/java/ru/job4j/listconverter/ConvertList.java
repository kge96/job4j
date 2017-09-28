package ru.job4j.listconverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for converting list.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.09.2017.
 */
public class ConvertList {
    /**
     * Convert array to List.
     * @param array - original array.
     * @return List - list.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] outer : array) {
            for (int inner : outer) {
                list.add(inner);
            }
        }
        return list;
    }

    /**
     * Convert list to arry.
     * @param list - original list.
     * @param rows - count of lines in array.
     * @return int[][] - array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cols;

        if (list.size() % rows == 0) {
            cols = list.size() / rows;
        } else {
            cols = list.size() / rows + 1;
        }

        int[][] array = new int[rows][cols];

        int listIndex = 0;
        int arrIndex;
        for (int[] outer : array) {
            arrIndex = 0;
            for (int i : outer) {
                if (listIndex > list.size() - 1) {
                    outer[arrIndex++] = 0;
                } else {
                    outer[arrIndex++] = (list.get(listIndex) == null) ? 0 : list.get(listIndex);
                    listIndex++;
                }
            }

        }
        return array;
    }

    /**
     * Convert List of arrays to List of integer values from arrays.
     * @param list - original list of arrays.
     * @return List - list of integer value.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int i : arr) {
                result.add(i);
            }

        }
        return result;
    }
}
