package ru.job4j.bank;

/**
 * Class for create user account.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 27.09.2017.
 */
public class Account {
    /**
     * Amount of money.
     */
    private double value;
    /**
     * bank account requisites.
     */
    private long requisites;

    /**
     * Constructor.
     * @param value - amount of money.
     * @param requisites - bank account requisites.
     */
    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Get amount of money.
     * @return long.
     */
    public double getValue() {
        return value;
    }

    /**
     * Set amount of money.
     * @param value - value.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Get account requisites.
     *
     * @return long.
     */
    public long getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (requisites ^ (requisites >>> 32));
        return result;
    }
}
