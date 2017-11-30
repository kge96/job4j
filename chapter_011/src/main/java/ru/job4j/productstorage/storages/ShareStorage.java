package ru.job4j.productstorage.storages;

import ru.job4j.productstorage.products.Food;

/**
 * Class for creating new storages.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public abstract class ShareStorage implements Storage {
    /**
     * Shared storage.
     */
    private Storage sharedStorage;

    /**
     * Constructor.
     * @param sharedStorage - shared storage.
     */
    public ShareStorage(Storage sharedStorage) {
        this.sharedStorage = sharedStorage;
    }

    @Override
    public void putProduct(Food food) {
        sharedStorage.putProduct(food);
    }
}
