package ru.job4j.carcatalog.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for creating carcatalog producer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
@Entity
public class Producer {
    /**
     * Producer id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Producer model.
     */
    private String mark;

    /**
     * Constructor default.
     */
    public Producer() {

    }

    /**
     * Constructor.
     * @param id - id.
     */
    public Producer(int id) {
        this.id = id;
    }

    /**
     * Constructor.
     * @param mark - mark.
     */
    public Producer(String mark) {
        this.mark = mark;
    }

    /**
     * Getter for model.
     * @return String.
     */
    public String getMark() {
        return mark;
    }

    /**
     * Setter for mark.
     * @param mark - model.
     */
    public void setMark(String mark) {
        this.mark = mark;
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
