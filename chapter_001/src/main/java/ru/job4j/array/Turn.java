package ru.job4j.array;

/**
 * Класс который переворачивает массив.
 * @author gkuznetsov.
 * @since 16.09.17.
 * @version 0.1.
 */
public class Turn {
    /**
     * Получает на вход массив. Определяет центр и меняет местами зеркально расположенные элементы.
     * Например для массива длинной 4 зеркальные элементы будут иметь индексы 0 и 3, 1 и 2.
     * @param array - передаваемый массив.
     * @return int[].
     */
    public int[] back(int[] array) {
        int tmp;
        int center = array.length / 2;

        for (int i = 0; i < center; i++) {
            tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        return array;
    }
}
