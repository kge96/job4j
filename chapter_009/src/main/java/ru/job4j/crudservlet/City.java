package ru.job4j.crudservlet;

/**
 * Class for creating city.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 20.11.2017.
 */
public class City {
    /**
     * City name.
     */
    private String city;

    /**
     * City constructor.
     * @param city - city.
     */
    public City(String city) {
        this.city = city;
    }

    /**
     * Getter for city.
     * @return String.
     */
    public String getCity() {
        return city;
    }
}
