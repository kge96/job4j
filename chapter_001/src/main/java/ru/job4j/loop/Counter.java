package ru.job4j.loop;

/**
 * Class Класс вычисляет сумму всех чётных чисел в заданном диапазоне от strt до finish.
 * @author gkuznetsov.
 * @since 15.09.17.
 * @version 0.1.
 */
public class Counter {
    /**
     * Метод вычисляет сумму всех чётных чисел принадлежащих интервалу от start до finish.
     * Порядок аргументов на вычисление не влияет. Значение start может быть больше finish.
     * @param start - начальное значение интервала.
     * @param finish - конечное значение интервала.
     * @return int.
     */
    public int add(int start, int finish) {
        int result = 0;
        int head, tail;

        if (start > finish) {
            head = finish;
            tail = start;
        } else {
            head = start;
            tail = finish;
        }

        for (int i = head; i <= tail; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
