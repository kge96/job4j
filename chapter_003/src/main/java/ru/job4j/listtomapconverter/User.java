package ru.job4j.listtomapconverter;


/**
 * Class for creating user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.09.2017.
 */
public class User implements Comparable<User> {
    /**
     * User ID.
     */
    private int id;
    /**
     * User name.
     */
    private String name;
    /**
     * User city.
     */
    private String city;
    /**
     * User age.
     */
    private int age;

    /**
     * Constructor.
     * @param id - id.
     * @param name - user name.
     * @param city - user city.
     * @param age - user age.
     */
    public User(int id, int age, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Get user ID.
     * @return int.
     */
    public int getId() {
        return id;
    }

    /**
     * Get user name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Get user age.
     * @return int.
     */
    public int getAge() {
        return age;
    }

    /**
     * Get user city.
     * @return String.
     */
    public String getCity() {
        return city;
    }

    /**
     *Equals.
     * @param o - object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (!name.equals(user.name)) {
            return false;
        }
        return city.equals(user.city);
    }

    /**
     * Comparator.
     * @param o - object.
     * @return int.
     */
    @Override
    public int compareTo(User o) {
        return (this.age < o.getAge()) ? -1 : (this.age > o.age) ? 1 : 0;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
