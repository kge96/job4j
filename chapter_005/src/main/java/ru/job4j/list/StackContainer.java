package ru.job4j.list;

/**
 * Class for creating StackContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.10.2017.
 * @param <E> - type of element.
 */
public class StackContainer<E> extends LinkedContainer<E> {
    /**
     * Add element to container.
     * @param value - value.
     */
    public void push(E value) {
        add(value);
    }
    /**
     * Get and remove last added element.
     * @return E - element.
     */
    public E poll() {
       E result = get(getSize() - 1);
       if (remove(result)) {
           return result;
       } else {
           return null;
       }
    }
}
