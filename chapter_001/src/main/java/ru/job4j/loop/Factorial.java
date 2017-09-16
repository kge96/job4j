package ru.job4j.loop;

/**
 * Класс для вычисления факториала.
 * @author gkuznetsov.
 * @since 15.09.17.
 * @version 0.1.
 */
public class Factorial {
    /**
     * Метод возвращает факториал числа n.
     * n должно быть больше 0.
     * @param n - число > 0.
     * @return long.
     */
    public int calc(int n) {
        int result = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n < 0) {
            return -1;
        }
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}