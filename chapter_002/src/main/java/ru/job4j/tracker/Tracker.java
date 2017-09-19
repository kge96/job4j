package ru.job4j.tracker;

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
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] == null) {
                continue;
            } else if (items[i].getId().equals(item.getId())) {
                items[i] = item;
            }

        }
    }

    /**
     * This element delete selected element.
     * @param item - element.
     */
    public void delete(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] == null) {
                continue;
            }

            if (items[i].getId().equals(item.getId())) {
                items[i] = null;
            }

        }
    }

    /**
     * This method find all elements.
     * @return Item[].
     */
    public Item[] findAll() {
        Item[] newItem;
        int itemPosition = 0;
        int itemCounter = 0;

        for (Item itm : items) {
            if (itm != null) {
                itemCounter++;
            }
        }
        newItem = new Item[itemCounter];
        for (int i = 0; i < newItem.length; i++) {
            if (items[i] != null) {
                newItem[itemPosition++] = items[i];
            }
        }
        return newItem;
    }

    /**
     * This method find element by name.
     * @param key - name of element.
     * @return Item[].
     */
    public Item[] findByName(String key) {
        Item[] result;
        int itemPosition = 0;
        int itemCounter = 0;

        for (Item itm : items) {
            if (itm == null) {
                continue;
            }

            if (itm.getName().equals(key)) {
                itemCounter++;
            }
        }
        result = new Item[itemCounter];
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] == null) {
                continue;
            }

            if (items[i].getName().equals(key)) {
                result[itemPosition++] = items[i];
            }
        }
        return result;
    }

    /**
     * This method find element by Id.
     * @param id - element id.
     * @return Item.
     */
    public Item findById(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] == null) {
                continue;
            }

            if (items[i].getId().equals(id)) {
                return items[i];
            }
        }
        return null;
    }

    /**
     * This method return application array with null elements.
     * @return Item[].
     */
    public Item[] getItems() {
        return this.items;
    }
}
