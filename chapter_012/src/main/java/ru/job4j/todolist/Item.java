package ru.job4j.todolist;

import java.sql.Timestamp;

/**
 * Class for creating item.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 29.11.2017.
 */
public class Item {
    /**
     * Item id.
     */
    private int id;
    /**
     * Item description.
     */
    private String desc;
    /**
     * Item created date.
     */
    private Timestamp created;
    /**
     * Item status condition.
     */
    private boolean done;

    /**
     * Getter for id.
     * @return int.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter for id.
     * @param id - item id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for description item.
     * @return String.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Setter for description item.
     * @param desc - description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for creation date item.
     * @return String.
     */
    public Timestamp getCreated() {
        return this.created;
    }

    /**
     * Setter for created date.
     * @param created - created date.
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Getter for item item status condition.
     * @return boolean.
     */
    public boolean getDone() {
        return this.done;
    }

    /**
     * Setter for item status condition.
     * @param done - item status condition.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}
