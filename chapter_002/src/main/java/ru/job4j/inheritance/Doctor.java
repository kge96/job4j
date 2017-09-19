package ru.job4j.inheritance;

/**
 * Класс описывающий профессию доктора.
 * @author gkuznetsov.
 * @since 18.09.17.
 * @version 0.1.
 */

public class Doctor extends Profession {
    /**
     * Конструктор класса.
     * @param name - имя носителя профессии.
     */
    public Doctor(String name) {
        super(name);
    }

    /**
     * Метод описывающий лечение пациента.
     * @param patient - пациент.
     * @return String.
     */
    public String treatPatient(Person patient) {
        return  "Доктор " + this.getPersonName() + " лечит " + patient.getName() + "а";
    }

}
