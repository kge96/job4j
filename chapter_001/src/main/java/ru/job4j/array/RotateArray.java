package ru.job4j.array;

/**
 * Класс для переворачиавния двумерного массива.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */

public class RotateArray {
    /**
     * Переворачивает двумерный массив.
     * @param array - передаваемый массив.
     * @return int[][].
     */
    public int[][] rotate(int[][] array) {
        if (array.length < 2) {
            return array;
        }
        int barrier = 0;
        int center = array.length / 2;
        /*переворачиваем каждый массив(turn)*/
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < center; j++) {
                int tmp = array[i][j];
                array[i][j] = array[i][array.length - 1 - j];
                array[i][array.length - 1 - j] = tmp;
            }
        }
        /*меняем элементы местами адрес строки делаем адресом столбца и наоборот*/
        for (int i = barrier; i < array.length; i++) {
            for (int j = barrier; j < array.length; j++) {
                int tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
            barrier++;
        }
        return array;
    }
}
