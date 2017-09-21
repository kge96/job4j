package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Class for created Tracker.
 * @author gkuznetsov.
 * @since 19.09.17.
 */

public class Tracker {
    /**
     * Items of application.
     */
    private Item[] items = new Item[100];

    /**
     * Position in which add application.
     */
    private int position = 0;

    /**
     * This method add new element in array Items.
     * @param item - element.
     * @return Item.
     */
    public Item add(Item item) {
        this.items[position++] = item;
        return item;
    }

    /**
     * This method update selected element.
     * @param item - element.
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
            }
        }
    }

    /**
     * This element delete selected element.
     * @param item - element.
     */
    public void delete(Item item) {
        for (int i = 0; i <= position; i++) {
            if (items[i].getId().equals(item.getId())) {
                items[i] = null;
                break;
            }
        }
        for (int i = 0; i <= position; i++) {
            if (items[i] == null && items[i + 1] != null && i != items.length - 1) {
                items[i] = items[i + 1];
                items[i + 1] = null;
            }
        }
        --position;
    }

    /**
     * This method find all elements.
     * @return Item[].
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * This method find element by name.
     * @param key - name of element.
     * @return Item[].
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int count = 0;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * This method find element by Id.
     * @param id - element id.
     * @return Item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item itm : items) {
            if (itm != null && itm.getId().equals(id)) {
                result = itm;
                break;
            }
        }
        return result;
    }

    /**
     * This method return application array with null elements.
     * @return Item[].
     */
    public Item[] getItems() {
        return this.items;
    }


}
