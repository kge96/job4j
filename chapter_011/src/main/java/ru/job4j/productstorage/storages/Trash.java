package ru.job4j.productstorage.storages;

import ru.job4j.productstorage.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creation trash.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public class Trash implements Storage {
    /**
     * List for storage food.
     */
    private List<Food> foods = new ArrayList<>();

    @Override
    public void putProduct(Food food) {
        foods.add(food);
    }

    /**
     * Getter for list food.
     * @return List.
     */
    public List<Food> getFoodsList() {
        return this.foods;
    }
}
