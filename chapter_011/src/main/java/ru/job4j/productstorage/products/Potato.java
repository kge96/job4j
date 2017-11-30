package ru.job4j.productstorage.products;

/**
 * Class for creating potato.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class Potato extends FoodDecorator {
    /**
     * Constructor.
     * @param food - food.
     * @param type - type.
     * @param canReproduct - flag.
     */
    public Potato(Food food, String type, boolean canReproduct) {
        super(food, type, canReproduct);
    }

    @Override
    public long getExpirationDate() {
        return super.getExpirationDate();
    }

    @Override
    public long getCreationDate() {
        return super.getCreationDate();
    }

    @Override
    public void setDiscount(int discount) {
        super.setDiscount(discount);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public boolean isReproducted() {
        return super.isReproducted();
    }


}
