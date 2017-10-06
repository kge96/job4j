package ru.job4j.list;

/**
 * Class for creating SetLinkedContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 * @param <E> - type of element.
 */
public class SetLinkedContainer<E> extends LinkedContainer<E> {
    /**
     * Add new element to collection if there isn't in it.
     * @param element - element.
     */
    @Override
    public void add(E element) {
        if (!super.contains(element)) {
            super.add(element);
        }
    }

}
