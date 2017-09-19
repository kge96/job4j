package ru.job4j.array;


/**
 * Class for merging two sorted array into one.
 * @author gkuznetsov.
 * @since 19.08.17/
 * @version 0.1.
 */

public class MergingArrays {
    /**
     * Merge two sorted arrays into one sorted.
     * @param arr1 - frist array.
     * @param arr2 - second array.
     * @return int[].
     */
    public int[] mergeArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int indexArr1 = 0;
        int indexArr2 = 0;

        while (indexArr1 + indexArr2 < result.length) {
            if (indexArr1 > arr1.length - 1) {
                result[indexArr1 + indexArr2] = arr2[indexArr2++];
            } else if (indexArr2 > arr2.length - 1) {
                result[indexArr1 + indexArr2] = arr1[indexArr1++];
            } else if (arr1[indexArr1] > arr2[indexArr2]) {
                result[indexArr1 + indexArr2] = arr2[indexArr2++];
            } else {
                result[indexArr1 + indexArr2] = arr1[indexArr1++];
            }
        }
        return result;
    }

}
