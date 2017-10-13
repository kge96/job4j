package ru.job4j.tree;

/**
 * Interface SimpleTree.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 09.10.2017.
 * @param <E> - type of element.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add new element to ru.job4j.tree structure.
     * @param parent - parent.
     * @param child - child.
     * @return boolean.
     */
    boolean add(E parent, E child);
}
