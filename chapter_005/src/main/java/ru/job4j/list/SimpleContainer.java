package ru.job4j.list;

/**
 * Interface for list.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.10.2017.
 * @param <E> - element type.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Must add element to collection.
     * @param e - The element wich need added.
     */
    void add(E e);

    /**
     * Must return element.
     * @param index - element index.
     * @return E.
     */
    E get(int index);

}
