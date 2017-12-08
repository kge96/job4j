package ru.job4j.domain.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for creating transmission type for carcatalog.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
@Entity
public class Transmission {
    /**
     * Transmission id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Transmission type.
     */
    private String type;

    /**
     * Default constructor.
     */
    public Transmission() {

    }

    /**
     * Constructor.
     * @param id - id.
     */
    public Transmission(int id) {
        this.id = id;
    }

    /**
     * Constructor.
     * @param type - type.
     */
    public Transmission(String type) {
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
     * Setter for transmission type.
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
