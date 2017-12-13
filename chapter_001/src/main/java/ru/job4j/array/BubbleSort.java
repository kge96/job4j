package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для сортировки массива пузырьком.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */
public class BubbleSort {
    /**
     * Сортирует полученный массив пузырьком.
     * @param array - цедочисленный массив.
     * @return int[].
     */
    public int[] sort(int[] array) {
//        if (array.length < 1) {
//            return array;
//        }
//        for (int i = array.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (array[j] > array[j + 1]) {
//                    int tmp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = tmp;
//                }
//            }
//        }
//     return array;
        return Arrays.stream(array).sorted().toArray();
    }
}
