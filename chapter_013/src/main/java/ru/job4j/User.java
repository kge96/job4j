package ru.job4j;

/**
 * Class for creating user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */
public class User {
    /**
     * User name.
     */
    private String name;

    /**
     * Constructor.
     * @param name - name.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Getter for user name.
     * @return String.
     */
    public String getName() {
        return name;
    }
}
