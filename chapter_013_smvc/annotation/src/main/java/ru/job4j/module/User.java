package ru.job4j.module;

/**
 * Class for creating user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.12.2017.
 */
public class User {
    /**
     * User name.
     */
    private String name;

    /**
     * Constructor.
     * @param name name.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Getter for user name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for user name.
     * @param name user name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
