package ru.job4j.ioc.storages;

import ru.job4j.ioc.User;

/**
 * Class for creating jdbc storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */
public class JdbcStorage implements Storage {
    /**
     * Data base address.
     */
    private String url = null;
    /**
     * JDBC driver.
     */
    private final String driver;

    public JdbcStorage(String url, String driver) {
        this.url = url;
        this.driver = driver;
    }


    @Override
    public void add(User user) {
        System.out.println("Storing to mem");
    }
}
