package ru.job4j.inheritance;

/**
 * Класс описывающий профессию учителя.
 * @author gkuznetsov.
 * @since 18.09.17.
 * @version 0.1.
 */
public class Teacher extends Profession {
    /**
     * Конструктор класса.
     * @param name - имя носителя профессии.
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * Описывает процесс обучения.
     * @param student - студент.
     * @return String.
     */
    public String teachStudent(Person student) {
        return "Учитель " + this.getPersonName() + " учит " + student.getName() + "а";
    }
}
