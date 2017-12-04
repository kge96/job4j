package ru.job4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.storages.Storage;

/**
 * Class for creating user storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */
@Component
public class UserStorage {
    /**
     * User storage.
     */
   private final Storage storage;

    /**
     * Constructor.
     * @param storage - storage.
     */
    @Autowired
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    /**
     * Add user to storage.
     * @param user - user.
     */
    public void add(User user) {
        this.storage.add(user);
    }
}
