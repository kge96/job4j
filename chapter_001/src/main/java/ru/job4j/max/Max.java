package ru.job4j.max;

/**
 * Класс для вычисления максимума из 2ух чисел.
 *
 * @author kuznetsov.
 * @since 15.09.17.
 * @version 0.2.
 */
public class Max {
    /**
     * Возвращет максимальное число из 2ух переданных.
     * @param first первое число.
     * @param second - второе число.
     * @return int.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
    /**
     * Возвращет максимальное число из 3х переданных.
     * @param first первое число.
     * @param second - второе число.
     * @param third - третье число
     * @return int.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
