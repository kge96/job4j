package ru.job4j.immutablelist;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ByteArrayInputStream;

/**
 * Class for creating immutable list.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 14.12.2017.
 * @param <T> - object class.
 */
public final class ImmutableList<T extends Serializable> {
    /**
     * List.
     */
    private final T[] list;

    /**
     * Constructor.
     * @param list - array.
     */
    public ImmutableList(T[] list) {
        this.list = list;
    }

    /**
     * List size.
     * @return int.
     */
    public int size() {
        return list.length;
    }

    /**
     * Return deep clone of element from immutable list.
     * @param index - element index.
     * @return int.
     */
    public T getElement(int index) {
        return deepClone(this.getList()[index]);
    }

    /**
     * Return deep clone of list.
     * @return T[] - new array.
     */
    public T[] getList() {
        return (T[]) deepClone((T) list);
    }

    /**
     * Do deep clone of specified object.
     * @param obj - specified object.
     * @return T - new object.
     */
    private T deepClone(T obj) {
        T result = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            result = (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
