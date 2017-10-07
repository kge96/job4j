package ru.job4j.list;

/**
 * Class for creating QueueContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.10.2017.
 * @param <E> - type of element.
 */
public class QueueContainer<E> extends LinkedContainer<E> {
    /**
     * Add element to container.
     * @param value - value.
     */
    public void push(E value) {
        add(value);
    }

    /**
     * Get and remove first added element.
     * @return E - element.
     */
    public E poll() {
        E result = this.get(0);
        this.remove(result);
        return result;
    }
}
