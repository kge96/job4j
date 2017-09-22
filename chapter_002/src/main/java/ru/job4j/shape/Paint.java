package ru.job4j.shape;

/**
 * Class for painting shape.
 *
 * @author gkuznetsov.
 * @since 22.09.2017.
 * @version 0.1.
 */
public class Paint {
    /**
     * Draw shape.
     * @param shape - shape.
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}
