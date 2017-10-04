package ru.job4j.store;

/**
 * Interface.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 * @param <T> param.
 */
public interface Store<T extends Base> {
    /**
     * Must SimpleContainer new item.
     * @param model - item.
     * @return T - adder element.
     */
    T add(T model);

    /**
     * Must update item.
     * @param model - item.
     * @return - T - old item.
     */
    T update(T model);

    /**
     * Must delet specified item.
     * @param id - item.
     * @return boolean - if item was deleted and false if wasn't;
     */
    boolean delete(String id);
}
