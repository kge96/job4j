package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class for creating dynamic array.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.10.2017.
 * @param <E> - element type.
 */
public class ArrayContainer<E> implements SimpleContainer<E> {
    /**
     * Elements storage.
     */
    private Object[] container;
    /**
     * Current empty element position.
     */
    private int position = 0;

    /**
     * Constructor for ArrayContainer with default size = 5.
     */
    public ArrayContainer() {
        this.container  = new Object[5];
    }

    /**
     * Constructor for ArrayContainer with specified size.
     * @param size - specified size.
     */
    public ArrayContainer(int size) {
        this.container  = new Object[size];
    }

    /**
     * Add new element to array.
     * @param e - element.
     */
    @Override
    public void add(E e) {
        if (this.container.length > this.position) {
            this.container[position++] = e;
        } else {
            this.container = Arrays.copyOf(this.container, this.container.length * 3 / 2 + 1);
            this.container[position++] = e;
        }

    }

    /**
     * Check that container contains specified element.
     * @param e - specified element.
     * @return boolean.
     */
    public boolean contains(E e) {
        for (Object elem : container) {
            if (e.equals((E) elem)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Get element from array.
     * @param index - element index.
     * @return E - element.
     */
    @Override
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Iterator for array.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private int itr = 0;
            @Override
            public boolean hasNext() {
                return container.length > itr;
            }

            @Override
            public E next() {
                return (E) container[itr++];
            }
        };
    }
}
