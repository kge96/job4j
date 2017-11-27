package ru.job4j.productstorage.products;

/**
 * Interface for creation food elements.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public interface Food {
    /**
     * Return expiration date.
     * @return long.
     */
    long getExpirationDate();

    /**
     * Returng creation date.
     * @return long.
     */
    long getCreationDate();

    /**
     * Set new discount.
     * @param discount - discount.
     */
    void setDiscount(int discount);

    /**
     * Return this price.
     * @return int.
     */
    int getPrice();
}
