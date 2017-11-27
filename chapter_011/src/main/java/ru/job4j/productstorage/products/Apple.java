package ru.job4j.productstorage.products;

/**
 * Class for creating apple.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public class Apple implements Food {
    /**
     * Food name.
     */
    private String name;
    /**
     * Date of expiration.
     */
    private long expirationDate;
    /**
     * Date of creation.
     */
    private long createDate;
    /**
     * Product price.
     */
    private int prise;
    /**
     * Product discount.
     */
    private int discount;

    /**
     * Meet constructor.
     * @param name - product name.
     * @param expirationDate -expiration date.
     * @param createDate - creation date.
     * @param prise - product price.
     * @param discount - product discount.
     */
    public Apple(String name, long expirationDate, long createDate, int prise, int discount) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.createDate = createDate;
        this.discount = discount;
        this.prise = prise - prise * discount / 100;
    }

    @Override
    public long getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public long getCreationDate() {
        return this.createDate;
    }

    @Override
    public void setDiscount(int discount) {
        this.prise = this.prise - this.prise * discount / 100;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return this.prise;
    }
}
