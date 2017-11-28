package ru.job4j.productstorage;

import ru.job4j.productstorage.products.Food;
import ru.job4j.productstorage.storages.Shop;
import ru.job4j.productstorage.storages.Trash;
import ru.job4j.productstorage.storages.Warehouse;

import java.util.List;

/**
 * Class for creating ControlQuality.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public class ControlQuality {
    /**
     * Shop object.
     */
    private Shop shop = new Shop();
    /**
     * Trash object.
     */
    private Trash trash = new Trash();
    /**
     * Warehouse object.
     */
    private Warehouse warehouse = new Warehouse();

    /**
     * Method for product distribution.
     * @param food - food.
     */
    public void putProductToStorage(Food food) {
        long expiration = food.getExpirationDate() - food.getCreationDate();
        long today = System.currentTimeMillis() - food.getCreationDate();
        double consumption = 100 - (((double) expiration - today) / expiration) * 100;

        int num = (consumption < 25) ? 1
                : (consumption > 25 && consumption < 75) ? 2
                : (consumption > 75 && consumption < 100) ? 3
                : (consumption > 75 && consumption < 100) ? 4
                : (consumption >= 100) ? 5 : -1;

        switch (num) {
            case 1:
                warehouse.putProduct(food);
                break;
            case 2:
                shop.putProduct(food);
                break;
            case 3:
                food.setDiscount(15);
                shop.putProduct(food);
                break;
            case 4:
                food.setDiscount(15);
                shop.putProduct(food);
                break;
            case 5:
                trash.putProduct(food);
                break;
            default:
                break;
        }
    }

    /**
     * Getter for trash list.
     * @return List.
     */
    public List<Food> getTrashStorage() {
        return trash.getFoodsList();
    }

    /**
     * Getter for shop list.
     * @return List.
     */
    public List<Food> getShopStorage() {
        return shop.getFoodsList();
    }

    /**
     * Getter for warehouse list.
     * @return List.
     */
    public List<Food> getWarehouseStorage() {
        return warehouse.getFoodsList();
    }
}
