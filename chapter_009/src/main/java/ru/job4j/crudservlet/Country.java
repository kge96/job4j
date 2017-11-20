package ru.job4j.crudservlet;

/**
 * Class for creating country.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 20.11.2017.
 */
public class Country {
    /**
     * Country name.
     */
    private String country;

    /**
     * Constructor for country.
     * @param county - country.
     */
    public Country(String county) {
        this.country = county;
    }

    /**
     * Getter for country.
     * @return String.
     */
    public String getCounty() {
        return country;
    }
}
