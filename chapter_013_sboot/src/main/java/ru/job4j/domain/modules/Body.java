package ru.job4j.domain.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for creating carcatalog body type.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
@Entity
public class Body {
    /**
     * Body id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
