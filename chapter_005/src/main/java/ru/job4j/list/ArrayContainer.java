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
    private Object[] container = new Object[5];
    /**
     * Current empty element position.
     */
    private int position = 0;

    /**
     * Add new element to array.
     * @param e - element.
     */
    @Override
    public void add(E e) {
        if (this.container.length > this.position) {
            this.container[position++] = e;
        } else {
            this.container = Arrays.copyOf(this.container, this.container.length * 3 / 2);
            this.container[position++] = e;
        }

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
