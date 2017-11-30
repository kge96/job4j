package ru.job4j.carcatalog.modules;

/**
 * Class for creating fuel type for engine.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
public class Fuel {
    /**
     * Fuel id.
     */
    private int id;
    /**
     * Fuel type.
     */
    private String type;

    /**
     * Default constructor.
     */
    public Fuel() {

    }

    /**
     * Constructor.
     * @param id - id.
     */
    public Fuel(int id) {
        this.id = id;
    }

    /**
     * Constructor.
     * @param type - type.
     */
    public Fuel(String type) {
        this.type = type;
    }

    /**
     * Getter for type.
     * @return String.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type.
     * @param type - type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for id.
     * @return int.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
}
