package ru.job4j.array;

import java.util.Arrays;

/**
 * Class for remove duplicated values at String arrays.
 * @author gkuznetsov.
 * @since 17.09.17.
 * @version 0.1.
 */
public class ArrayDuplicate {
    /**
     * Drop duplicates in array.
     * @param array - массив строк.
     * @return String[].
     */
    public String[] remove(String[] array) {
//        int barrier = 0;
//        for (int i = 0; i < array.length - barrier; i++) {
//            for (int j = 0; j < array.length - barrier; j++) {
//                if (array[j].equals(array[i]) && j != i) {
//                    String tmp = array[array.length - 1 - barrier];
//                    array[array.length - 1 - barrier] = array[j];
//                    array[j] = tmp;
//                    barrier++;
//                }
//            }
//        }

//        return Arrays.copyOf(array, array.length - barrier);

        return Arrays.stream(array).distinct().toArray(String[]::new);
    }
}