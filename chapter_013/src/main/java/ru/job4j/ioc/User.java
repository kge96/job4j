package ru.job4j.ioc;

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
     * User age.
     */
    private int age;
    /**
     * User passport.
     */
    private long passport;

    /**
     * Constructor.
     * @param name - name.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Constructor.
     * @param name - name.
     * @param age - age.
     * @param passport - passport.
     */
    public User(String name, int age, long passport) {
        this.name = name;
        this.age = age;
        this.passport = passport;
    }

    /**
     * Getter for user name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for age.
     * @return int.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for age.
     * @param age - age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter for pasport number.
     * @return long.
     */
    public long getPassport() {
        return passport;
    }

    /**
     * Setter for pasport number.
     * @param pasport - pasport.
     */
    public void setPassport(long pasport) {
        this.passport = pasport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (age != user.age) {
            return false;
        }
        if (passport != user.passport) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (int) (passport ^ (passport >>> 32));
        return result;
    }
}
