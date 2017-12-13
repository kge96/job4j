package ru.job4j.examples;

/**
 * Class for examples.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 12.12.2017.
 */
public class Person {
    /**
     * Person name.
     */
    private String name;
    /**
     * Person age.
     */
    private int age;
    /**
     * Person sex.
     */
    private Sex sex;

    /**
     * Constructor.
     * @param name - person name.
     * @param age - person age.
     * @param sex - person sex.
     */
    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * Getter for person name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for person age.
     * @return int.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for person sex.
     * @return sex.
     */
    public Sex getSex() {
        return sex;
    }
}
