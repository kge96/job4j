package ru.job4j.menu.interfaces;

/**
 * Interface for realization get method for returning item name.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public interface NameGettable extends ItemManager {
    /**
     * Return item name.
     * @return String.
     */
    String getName();
}
