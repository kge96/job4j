package ru.job4j.arrayiteratos;

import java.util.Iterator;

/**
 * Class for creating iterator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class IntegerIt implements Iterator<Integer> {
    /**
     * An element index in array.
     */
    private int index = 0;
    /**
     * The origin array.
     */
    private int[] array;

    /**
     * IntegerIt constructor.
     * @param array - origin array.
     */
    public IntegerIt(int[] array) {
        this.array = array;
    }

    /**
     * Check the is there next element.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return this.array.length > this.index;
    }

    /**
     * Get the next element from array.
     * @return Integer.
     */
    @Override
    public Integer next() {
        return array[index++];
    }

}
