package ru.job4j.store;

import ru.job4j.generics.SimpleArray;

/**
 * Class for creating users storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public class UserStore extends AbstractStore {
    /**
     * Constructor with default UserStorage size = 5.
     */
    public UserStore() {
        super(new SimpleArray(5));
    }

    /**
     * Constructor with specified UserStorage size.
     * @param size - UserStorage size.
     */
    public UserStore(int size) {
        super(new SimpleArray(size));
    }

}
