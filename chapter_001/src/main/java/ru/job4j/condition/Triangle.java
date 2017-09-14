package ru.job4j.condition;

/**
 * Class Класс для создания треугольника.
 * @author gkuznetsov.
 * @since 14.09.17.
 * @version 0.1.
 */
public class Triangle {
    /**
     * @param a - точка A.
     */
    private Point a;
    /**
     * @param b - точка B.
     */
    private Point b;
    /**
     * @param c - точка C.
     */
    private Point c;
    /**
     * Конструктор класса Triangle.
     * @param a - точка A.
     * @param b - точка B.
     * @param c - точка C.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Вычисляет расстояние между двумя точками.
     * @param left - левая точка.
     * @param right - правая точка.
     * @return double.
     */
    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow(left.getX() - right.getX(), 2) + Math.pow(left.getY() - right.getY(), 2));
    }

    /**
     * Вычисляет перимметр треугольника.
     * @param ab - сторона AB.
     * @param ac - сторона AC.
     * @param bc - сторона BC.
     * @return double.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Вычисляет площадь треугольника. Если невозможно возвращает -1.
     * @return double
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Проверяет возможно ли построить треугольник по указанным сторонам.
     * @param ab - сторона AB.
     * @param ac - сторона AC.
     * @param bc - сторона BC.
     * @return boolean.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + bc > ac && bc + ac > ab && ac + ab > bc;
    }
}