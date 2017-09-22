package ru.job4j.tracker;

/**
 * Interface for actions.
 *
 * @author gkuznetsov.
 * @since 22.09.2017.
 * @version 0.1.
 */
public interface UserAction {
    /**
     * operation number in menu item.
     * @return int.
     */
    int key();

    /**
     * run method.
     * @param input - input.
     * @param tracker - input storage.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Return string for menu.
     * @return String.
     */
    String info();
}
