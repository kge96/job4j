package ru.job4j.productstorage;

import ru.job4j.productstorage.products.Food;
import ru.job4j.productstorage.products.FoodDecorator;
import ru.job4j.productstorage.storages.*;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class SharedControlQuality {
    private ControlQuality controlQuality;
    private Storage fridge= new FredgeWarehouse(new Warehouse());
    private Storage sharedWarehouse;
    private Storage reproducer = new Reproducter();

    public SharedControlQuality(ControlQuality controlQuality) {
        this.controlQuality = controlQuality;
        this.sharedWarehouse = new SharedWarehouse((Storage) controlQuality.getWarehouseStorage());
    }

    public SharedControlQuality() {
        this.controlQuality = new ControlQuality();
        this.sharedWarehouse = new SharedWarehouse((Storage) controlQuality.getWarehouseStorage());
    }

    public void putProductToStorage(FoodDecorator food) {
        int num = chooseStorage(food);
        if (!food.isReproducted() && !("vegetables".equals(food.getType())) && num != 1) {
            controlQuality.putProductToStorage(food);
        } else {

            switch (num) {
                case 1:

            }
        }
    }

    private int chooseStorage(Food food) {
        int result = -1;
        long expiration = food.getExpirationDate() - food.getCreationDate();
        long today = System.currentTimeMillis() - food.getCreationDate();
        double consumption = 100 - (((double) expiration - today) / expiration) * 100;

        result = (consumption < 25) ? 1
                : (consumption > 25 && consumption < 75) ? 2
                : (consumption > 75 && consumption < 100) ? 3
                : (consumption > 75 && consumption < 100) ? 4
                : (consumption >= 100) ? 5 : -1;

        return result;
    }
}
