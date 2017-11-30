package ru.job4j.carcatalog.modules;

/**
 * Class for creating car body type.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
public class Body {
    /**
     * Body id.
     */
    private int id;
    /**
     * Body type.
     */
    private String type;

    /**
     * Default constructor.
     */
    public Body() {

    }

    /**
     * Constructor.
     * @param type - type.
     */
    public Body(String type) {
        this.type = type;
    }

    /**
     * Constructor id.
     * @param id - id.
     */
    public Body(int id) {
        this.id = id;
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
     * Getter for type.
     * @return int.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
}
