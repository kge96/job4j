package ru.job4j.inheritance;

/**
 * Класс описывающий профессию инженера.
 * @author gkuznetsov.
 * @since 18.09.17.
 * @version 0.1.
 */

public class Engineer extends Profession {
    /**
     * Конструктор класса.
     * @param name - имя носителя профессии.
     */
    public Engineer(String name) {
        super(name);
    }

    /**
     * Метод принятия нового сотрудника на работу.
     * @param specialist - сотрудник принимаемый на работу.
     * @return String.
     */
    public String getNewSpecialist(Person specialist) {
        return "Инженер " + this.getPersonName() + " берёт на работу " + specialist.getName() + "а";
    }

}
