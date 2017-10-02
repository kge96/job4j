package ru.job4j.arrayiteratos;

import java.util.Iterator;

/**
 * Class for creating TwodimensionalArrayIterator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class TwodimensionalArrayIterator implements Iterator {
    /**
     * The outer array index.
     */
    private int outer = 0;
    /**
     * The inner array index.
     */
    private int inner = 0;
    /**
     * This array.
     */
    private int[][] array;
    /**
     * Consructor of TwodimensionalArrayIterator.
     * @param array - original array.
     */
    public TwodimensionalArrayIterator(int[][] array) {
        this.array = array;
    }

    /**
     * Check is there next element in array.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return this.array.length - 1 > outer;
    }
    /**
     * Get next element.
     * @return Object.
     */
    @Override
    public Object next() {
        if (array[outer].length > inner) {
            return array[outer][inner++];
        } else {
            inner = 0;
            return array[++outer][inner++];
        }
    }

}
