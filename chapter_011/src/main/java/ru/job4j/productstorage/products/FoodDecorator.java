package ru.job4j.productstorage.products;

/**
 * Class for creating food decorator.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public abstract class FoodDecorator implements Food {
    /**
     * Food.
     */
    private Food food;
    /**
     * Type.
     */
    private String type;
    /**
     * Flag.
     */
    private boolean canReproduct;

    /**
     * Constructor.
     * @param food - food.
     * @param type - type.
     * @param canReproduct - flag.
     */
    public FoodDecorator(Food food, String type, boolean canReproduct) {
        this.food = food;
        this.type = type;
        this.canReproduct = canReproduct;
    }

    @Override
    public long getExpirationDate() {
        return this.food.getExpirationDate();
    }

    @Override
    public long getCreationDate() {
        return this.food.getCreationDate();
    }

    @Override
    public void setDiscount(int discount) {
        this.food.setDiscount(discount);
    }

    @Override
    public int getPrice() {
        return this.food.getPrice();
    }

    /**
     * Return if product can be reproduct.
     * @return boolean.
     */
    public boolean isReproducted() {
        return this.canReproduct;
    }

    /**
     * Get product type.
     * @return String.
     */
    public String getType() {
        return this.type;
    }
}
