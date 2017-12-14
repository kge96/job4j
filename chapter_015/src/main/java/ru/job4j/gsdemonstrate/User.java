package ru.job4j.gsdemonstrate;

/**
 * Class for creating user.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.12.2017.
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
     * User height.
     */
    private double height;

    /**
     * Constructor.
     * @param name - user naem.
     * @param age - user age.
     * @param height - height.
     */
    public User(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("\nUser %s age - %s was destroed\n", this.name, this.age);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", height=" + height
                + '}';
    }
}
