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
        return this.id;
    }

    /**
     * Get user name.
     * @return String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get user age.
     * @return int.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Get user city.
     * @return String.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Comparator.
     * @param o - object.
     * @return int.
     */
    @Override
    public int compareTo(User o) {
        int result = Integer.compare(this.age, o.getAge());
        return (result == 0) ? Integer.compare(this.id, o.getId()) : result;
    }

    /**
     * Compare objects.
     * @param o - original object.
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

        if (this.id != user.getId()) {
            return false;
        }
        return this.name != null ? this.name.equals(user.getName()) : user.getName() == null;
    }

    /**
     * Hash code.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
