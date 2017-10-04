package ru.job4j.generics;


import java.util.Arrays;
import java.util.Iterator;

/**
 * Class for creating simple array.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 * @param <T> - type of element.
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Array.
     */
    private Object[] array;
    /**
     * An index of elements in array.
     */
    private int index = 0;
    /**
     * Iterator index.
     */
    private int itr = 0;

    /**
     * Constructor.
     */
    public SimpleArray() {
        this.array = new Object[2];
    }

    /**
     * Constructor.
     * @param size - size of array.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Add elem to array.
     * @param value - value which need SimpleContainer to array.
     */
    public void add(T value) {
        if (this.index > this.array.length - 1) {
            this.array = Arrays.copyOf(this.array, this.array.length * 2);
        }
        this.array[index++] = value;
    }

    /**
     * Update element in array.
     * @param index - element index.
     * @param value - element value.
     */
    public void update(int index, T value) {
        array[index] = value;
    }

    /**
     * Return element.
     * @param position - element position.
     * @return <T> - element from array.
     */
    public T get(int position) {
        return (T) this.array[position];
    }

    /**
     * Delete element from array.
     * @param position - element position.
     */
    public void delete(int position) {
        if (this.array.length - 1 != position) {
            System.arraycopy(array, position + 1, array, position, this.array.length - position - 1);
        } else {
            this.array = Arrays.copyOf(array, this.array.length - 1);
        }
    }

    /**
     * Get the size of the array.
     * @return int size of the array.
     */
    public int size() {
        return this.array.length;
    }

    /**
     * Get index of specified element.
     * @param elem - element which index you need.
     * @return int.
     */
    public int getIndex(T elem) {
        for (Object item : array) {
            if (elem.equals(item)) {
                return Arrays.asList(array).indexOf(elem);
            }
        }
       return -1;
    }

    /**
     * Iterator for SimpleArray.
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        Object[] data = this.array;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return data.length > itr;
            }

            @Override
            public T next() {
                return (T) data[itr++];
            }
        };
    }
}