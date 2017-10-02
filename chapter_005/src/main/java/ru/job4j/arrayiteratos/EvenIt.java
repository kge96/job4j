package ru.job4j.arrayiteratos;

import java.util.Iterator;

/**
 * Class for creating the simple even number iterator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class EvenIt implements Iterator {
    /**
     * The element index.
     */
    private int index = 0;
    /**
     * The origin array.
     */
    private int[] array;

    /**
     * Constructor of even iterator.
     * @param array - array.
     */
    public EvenIt(int[] array) {
        this.array = array;
    }

    /**
     * Check is there next element in array.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     * Get next element.
     * @return Object.
     */
    @Override
    public Object next() {
        while (array[index] % 2 != 0) {
            index++;
        }
        return array[index++];
    }
}
