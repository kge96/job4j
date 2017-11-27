package ru.job4j.productstorage.storages;

import ru.job4j.productstorage.products.Food;

/**
 * Interface for creation storage elements.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public interface Storage {
    /**
     * Put product into the storage.
     * @param food - food.
     */
    void putProduct(Food food);
}
