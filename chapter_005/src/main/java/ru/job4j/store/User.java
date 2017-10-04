package ru.job4j.store;

/**
 * Class for creating instance of user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public class User extends Base {
    /**
     * User ID.
     */
    private String id;
    /**
     * User name.
     */
    private String name;

    /**
     * Constructor.
     * @param id - user ID.
     * @param name - user name.
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get user name.
     * @return String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get user ID.
     * @return String.
     */
    @Override
    String getId() {
        return this.id;
    }

    /**
     * Set user ID.
     * @param id - user ID.
     */
    @Override
    void setId(String id) {
        this.id = id;
    }

    /**
     * Method for comparison this object with object the same type.
     * @param o - an another object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.id.equals(user.getId());
    }

    /**
     * HashCode.
     * @return int.
     */
    @Override
    public int hashCode() {
        return this.id != null ? id.hashCode() : 0;
    }
}
