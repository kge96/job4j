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
     * UsersAddController date.
     */
    private long createDate;
    /**
     *User password.
     */
    private String password;
    /**
     * User role.
     */
    private String role;
    /**
     * Country.
     */
    private String country;
    /**
     * City.
     */
    private String city;


    /**
     * User constructor.
     * @param name - user name.
     * @param login - user login.
     * @param password - user password.
     * @param email - user email.
     * @param role - user role.
     * @param city - city.
     * @param country - country.
     */
    public User(String name, String login, String password, String email, String city, String country, String role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.city = city;
        this.country = country;
        this.role = role;
        this.createDate = System.currentTimeMillis();
    }

    /**
     * User constructor.
     * @param name - user name.
     * @param login - user login.
     * @param password - user password.
     * @param email - user email.
     * @param city - usr city.
     * @param country - usr country.
     * @param role - usr role.
     * @param createDate - creation date.
     */
    public User(String name, String login, String password, String email, String city, String country, String role, long createDate) {
        this(name, login, password, email, city, country, role);
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
     * Get user password.
     * @return String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for email.
     * @return String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for user country.
     * @return String.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter for user city.
     * @return String.
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter for creation date.
     * @return long.
     */
    public long getCreated() {
        return createDate;
    }

    /**
     * Get user Role.
     * @return String.
     */
    public String getRole() {
        return this.role;
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
     * Set user password.
     * @param password - password.
     */
    public void setPassword(String password) {
        this.password = password;
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
