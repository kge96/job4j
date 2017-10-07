package ru.job4j.list;


/**
 * Class for creating SetArrayContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 * @param <E> - element type.
 */
public class SetArrayContainer<E> extends ArrayContainer<E> {
    /**
     * Constructor for SetArrayContainer with specified start size.
     * @param size - start size.
     */
    public SetArrayContainer(int size) {
        super(size);
    }

    /**
     * Add new element to collection.
     * @param e - element.
     */
    @Override
    public void add(E e) {
        if (!super.contains(e)) {
            super.add(e);
        }
    }
}
