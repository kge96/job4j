package ru.job4j.condition;

/**
 * Class Класс для создания точки с координатами x,y.
 * @author gkuznetsov.
 * @since 14.09.17.
 * @version 0.1.
 */
public class Point {
    /**
     * @param x - координата x.
     */
    private int x;
    /**
     * @param y - координата y.
     */
    private int y;

    /**
     * Конструктор.
     * @param x - координата x.
     * @param y - координата y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату x.
     * @return int.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Возвращает координату y.
     * @return int.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Определяет принадлежит ли точка функции y(x) = a * x + b.
     * @param a - переменная функции.
     * @param b - переменная функции.
     * @return boolean
     */
    public boolean is(int a, int b) {
        return this.y == a * this.x + b;
    }
}