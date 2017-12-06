package ru.job4j.carcatalog.modules;

import javax.persistence.*;

/**
 * Class for creating engine type for carcatalog.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 30.11.2017.
 */
@Entity(name = "engine")
public class Engine {
    /**
     * Engine id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Engine volume.
     */
    private String volume;
    /**
     * Fuel.
     */
    @ManyToOne
    @JoinColumn(name = "fuel_id")
    private Fuel fuel;

    /**
     * Default constructor.
     */
    public Engine() {

    }

    /**
     * Constructor.
     * @param id - id.
     */
    public Engine(int id) {
        this.id = id;
    }

    /**
     * Constructor.
     * @param id - id.
     * @param fuel - fuel.
     */
    public Engine(int id, Fuel fuel) {
        this.id = id;
    }
    /**
     * Constructor.
     * @param volume - volume.
     * @param fuel - fuel.
     */
    public Engine(String volume, Fuel fuel) {
        this.volume = volume;
        this.fuel = fuel;
    }

    /**
     * Getter for volume.
     * @return String.
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Setter for volume.
     * @param volume - volume.
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * Getter for Fuel.
     * @return Fuel
     */
    public Fuel getFuel() {
        return fuel;
    }

    /**
     * Setter for fuel.
     * @param fuel fuel.
     */
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    /**
     * Getter id.
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
