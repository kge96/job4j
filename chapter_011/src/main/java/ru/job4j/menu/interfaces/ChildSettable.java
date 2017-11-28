package ru.job4j.menu.interfaces;

/**
 * Interface for realization setters for child of the item.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public interface ChildSettable extends ItemManager {
    /**
     * Set child to the element.
     * @param item - item.
     */
    void setChild(ItemManager item);
    /**
     * Set child to the element.
     * @param item - item.
     * @param position - position.
     */

    void setChild(ItemManager item, int position);
}
