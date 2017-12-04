package ru.job4j.storages;

import ru.job4j.User;

/**
 * Interface for creating storage instances.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */
public interface Storage {
    /**
     * Should add user to storage.
     * @param user - user.
     */
    void add(User user);

}
