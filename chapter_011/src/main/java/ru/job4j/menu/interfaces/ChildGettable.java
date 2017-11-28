package ru.job4j.menu.interfaces;

import java.util.List;

/**
 * Interface for realization getters for child of item.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public interface ChildGettable extends ItemManager {
    /**
     * Return list of childs.
     * @return List.
     */
    List<? extends ItemManager> getChild();
}
