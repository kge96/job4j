package ru.job4j.store;

import ru.job4j.generics.SimpleArray;

/**
 * Class for creating RoleStorage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public class RoleStore extends AbstractStore {
    /**
     * Constructor with default RoleStorage size = 5.
     */
    public RoleStore() {
        super(new SimpleArray(5));
    }

    /**
     * Constructor with specified size.
     * @param size - storage size.
     */
    public RoleStore(int size) {
        super(new SimpleArray(size));
    }

}
