package ru.job4j.menu.interfaces;

/**
 * Interface for realization action for menu item.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public interface Actionable extends ItemManager {
    /**
     * Menu item action.
     */
    void action();
}
