package ru.job4j.crudservlet;

/**
 * Class for creating user model.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 31.10.2017.
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User login.
     */
    private String login;
    /**
     * User email.
     */
    private String email;
    /**
     * Creation date.
     */
    private long createDate;

    /**
     * User constructor.
     * @param name - user name.
     * @param login - user login.
     * @param email - user email.
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = System.currentTimeMillis();
    }

    /**
     * User constructor.
     * @param name - user name.
     * @param login - user login.
     * @param email - user email.
     * @param createDate - creation date.
     */
    public User(String name, String login, String email, long createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Getter for name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for login.
     * @return String.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter for email.
     * @return String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for creation date.
     * @return long.
     */
    public long getCreated() {
        return createDate;
    }

    /**
     * Setter for name.
     * @param name - user name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for user login.
     * @param login - user login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Setter for email.
     * @param email - user email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter for creation date.
     * @param createDate - creation date.
     */
    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
