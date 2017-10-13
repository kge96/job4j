package ru.job4j.orderbook;

/**
 * Class for creating order.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 11.10.2017.
 */
public class Order {
    /**
     * Book name.
     */
    private String book;
    /**
     * Operation name.
     */
    private String operation;
    /**
     * Operation ID.
     */
    private long orderId;
    /**
     * Volume name.
     */
    private int volume;
    /**
     * Price.
     */
    private double price;

    /**
     * Order constructor.
     * @param book - book name.
     * @param operation - operation name.
     * @param orderId - order ID.
     * @param volume - volume name.
     * @param price - book price.
     */
    public Order(String book, String operation, long orderId, int volume, double price) {
        this.book = book;
        this.operation = operation;
        this.orderId = orderId;
        this.volume = volume;
        this.price = price;
    }

    /**
     * Return book.
     * @return String.
     */
    public String getBook() {
        return book;
    }

    /**
     * Return operation.
     * @return String.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Return order ID.
     * @return long.
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Return volume.
     * @return int.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Set volume.
     * @param volume - volume.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Return order price.
     * @return double.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Equals method.
     * @param o - object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        if (Double.compare(order.price, price) != 0) {
            return false;
        }
        if (book != null ? !book.equals(order.book) : order.book != null) {
            return false;
        }
        return operation != null ? operation.equals(order.operation) : order.operation == null;
    }

    /**
     * Hash code.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = book != null ? book.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + volume;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
