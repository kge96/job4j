package ru.job4j.productstorage.products;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public abstract class FoodDecorator implements Food {
    protected Food food;
    private String type;
    private boolean canReproduct;


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

    public boolean isReproducted() {
        return this.canReproduct;
    }

    public String getType() {
        return this.type;
    }
}
