package ru.job4j.productstorage.storages;

import ru.job4j.productstorage.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class FredgeWarehouse extends SharedWarehouse {
    private List<Food> fredgeStorage = new ArrayList<>();

    public FredgeWarehouse(Storage sharedStorage) {
        super(sharedStorage);
    }

    @Override
    public void putProduct(Food food) {
        this.fredgeStorage.add(food);
    }

}
