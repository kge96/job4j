package ru.job4j.threads.treadsafe;

import ru.job4j.list.LinkedContainer;

import java.util.Iterator;

/**
 * Class for creating thread safe collection.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 17.10.2017.
 * @param <E> - element type.
 */
public class ThreadSafe<E> extends LinkedContainer<E> {
    /**
     * Lock object.
     */
    private Object read = new Object();
    /**
     * Lock object.
     */
    private Object write = new Object();

    /**
     * Add new element.
     * @param o - element.
     */
    @Override
    public void add(E o) {
        synchronized (write) {
            super.add(o);
        }

    }

    /**
     * Return element by index.
     * @param index - element index.
     * @return E.
     */
    @Override
    public E get(int index) {
        synchronized (read) {
            return super.get(index);
        }
    }

    /**
     * Remove specified element.
     * @param value - deleted values.
     * @return boolean.
     */
    @Override
    public boolean remove(E value) {
        synchronized (write) {
            return super.remove(value);
        }
    }

    /**
     * Return Node by value.
     * @param value - value.
     * @return Node.
     */
    @Override
    public Node get(E value) {
        synchronized (read) {
            return super.get(value);
        }
    }

    /**
     * Check that collection contains specified element.
     * @param value - value.
     * @return boolean.
     */
    @Override
    public synchronized boolean contains(E value) {
        return super.contains(value);

    }

    /**
     * Return collection size.
     * @return int.
     */
    @Override
    public int getSize() {
        synchronized (read) {
            return super.getSize();
        }
    }

    /**
     * Return iterator.
     * @return Iterator.
     */
    @Override
    public synchronized Iterator iterator() {
        return super.iterator();
    }
}
