package ru.job4j.inheritance;

/**
 * Класс для общих полей и методов профессий.
 * @author gkuznetsov.
 * @since 18.09.17.
 * @version 0.1.
 */

public class Profession {
    /**
     * @param university - название учебного заведения.
     */
    private String university;
    /**
     * @param specialty - Название специальности.
     */
    private String specialty;
    /**
     * @param workExperience - стаж работы.
     */
    private int workExperience;
    /**
     * @param personName - имя носителя профессии.
     */
    private String personName;

    /**
     * Конструктор класса.
     * @param personName - имя.
     */
    public Profession(String personName) {
        this.personName = personName;
    }

    /**
     * Возвращает имя учебного заведения.
     * @return String.
     */
    public String getUniversity() {
        return this.university;
    }

    /**
     * Возвращает название специальности.
     * @return String.
     */
    public String getSpecialty() {
        return this.specialty;
    }

    /**
     * Возвращает опыт работы в годах.
     * @return int.
     */
    public int getWorkExperience() {
        return  this.workExperience;
    }

    /**
     * Возвращает имя.
     * @return String.
     */
    public String getPersonName() {
        return  this.personName;
    }
}
