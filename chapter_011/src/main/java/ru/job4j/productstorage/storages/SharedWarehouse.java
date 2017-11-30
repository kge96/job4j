package ru.job4j.productstorage.storages;

import ru.job4j.productstorage.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating shared warehouse.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class SharedWarehouse extends ShareStorage {
    /**
     * Storage.
     */
    private List<Food> newWarehouse = new ArrayList<>();

    /**
     * Constructor.
     * @param sharedStorage - shared warehouse.
     */
    public SharedWarehouse(Storage sharedStorage) {
        super(sharedStorage);
    }

    @Override
    public void putProduct(Food food) {
        putToNewStorage(food);
    }

    /**
     * Method for put product to new storage.
     * @param food - food.
     */
    public void putToNewStorage(Food food) {
        this.newWarehouse.add(food);
    }
}
