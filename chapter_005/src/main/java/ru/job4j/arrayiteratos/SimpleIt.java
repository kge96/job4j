package ru.job4j.arrayiteratos;

import java.util.Iterator;

/**
 * Class for creating simple numbers iterator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class SimpleIt implements Iterator {
    /**
     * An element index into array.
     */
    private int index = 0;
    /**
     * The original array.
     */
    private int[] array;

    /**
     * The SimpleIt constructor.
     * @param array - origin array.
     */
    public SimpleIt(int[] array) {
        this.array = array;
    }

    /**
     * Check the next element is simple.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        for (int i = index; i < array.length; i++) {
            if (isPrime(array[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the next item from array.
     * @return
     */
    @Override
    public Object next() {
        while (!isPrime(array[index]) && index < array.length - 1) {
            index++;
        }
        return array[index++];
    }

    /**
     * Check the number on a simple.
     * @param number - number.
     * @return boolean.
     */
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
