package ru.job4j.inheritance;
/**
 * Класс описывающий человека.
 * @author gkuznetsov.
 * @since 18.09.17.
 * @version 0.1.
 */
public class Person {
    /**
     * @name - имя носителя профессии.
     */
    private String name;

    /**
     * Конструктор класса.
     * @param name - имя человека.
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Возвращает имя человека.
     * @return String.
     */
    public String getName() {
        return name;
    }
}
