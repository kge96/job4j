package ru.job4j.threads.storage;

/**
 * Class for creating Users.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 17.10.2017.
 */
public class User {
    /**
     * User ID.
     */
    private int id;
    /**
     * User amount.
     */
    private int amount;

    /**
     * User constructor.
     * @param id - id.
     * @param amount - amount.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Return user id.
     * @return int.
     */
    public int getId() {
        return id;
    }

    /**
     * Return user amount.
     * @return int.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set user amount.
     * @param amount - amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
