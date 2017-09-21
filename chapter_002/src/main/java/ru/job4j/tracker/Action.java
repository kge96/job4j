package ru.job4j.tracker;

/**
 * Interface for actions.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public interface Action {
    /**
     * Run action.
     * @param tracker - item storage.
     * @param input - messenger.
     */
    void execute(Tracker tracker, Input input);
}
