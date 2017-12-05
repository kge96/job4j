package ru.job4j.models;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.12.2017.
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
