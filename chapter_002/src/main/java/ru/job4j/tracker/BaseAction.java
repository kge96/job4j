package ru.job4j.tracker;

/**
 * Abstract class for actions.
 * @author gkuznetsov.
 * @since 24.09.17.
 * @version 0.1.
 */

public abstract class BaseAction implements UserAction {
    /**
     * Operation number.
     */
    private int key;
    /**
     * Operation name.
     */
    private String name;

    /**
     * Constructor.
     * @param name - operation name.
     * @param key - operation number.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * Return operation number.
     * @return int.
     */
    @Override
    public abstract int key();

    /**
     * Do operation.
     * @param input - input.
     * @param tracker - input storage.
     */
    @Override
    public abstract void execute(Input input, Tracker tracker);

    /**
     * Return information about operation.
     * @return String.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
