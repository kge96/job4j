package ru.job4j.store;

/**
 * Abstract base class.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public abstract class Base {
    /**
     * Must return instance ID.
     * @return String ID.
     */
    abstract String getId();

    /**
     * Must set user ID.
     * @param id - instance id.
     */
    abstract void setId(String id);
}
