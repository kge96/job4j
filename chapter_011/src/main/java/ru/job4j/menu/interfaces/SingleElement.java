package ru.job4j.menu.interfaces;

/**
 * Class for creation single element.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class SingleElement implements NameGettable, Actionable {
    /**
     * Element name.
     */
    private String name;

    @Override
    public void action() {
        System.out.println("Single action");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
