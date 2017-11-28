package ru.job4j.productstorage.storages;

import ru.job4j.productstorage.products.Food;

import java.util.LinkedList;
import java.util.List;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class Reproducter implements Storage {
    List<Food> foodToReproduct = new LinkedList<>();

    @Override
    public void putProduct(Food food) {
        foodToReproduct.add(food);
    }
}
