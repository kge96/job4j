package ru.job4j.storages;

import ru.job4j.User;

/**
 * Class for creating jdbc storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */
public class JdbcStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("Storing to mem");
    }
}
