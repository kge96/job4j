package ru.job4j.bank;

/**
 * Class user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 27.09.2017.
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User passport.
     */
    private long passport;

    /**
     * Constructor.
     * @param name - user name.
     * @param passport - user passport.
     */
    public User(String name, long passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Get user name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Get user passport.
     * @return int.
     */
    public long getPassport() {
        return passport;
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

        if (passport != user.passport) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (passport ^ (passport >>> 32));
        return result;
    }
}
