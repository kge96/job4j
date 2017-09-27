package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for created Tracker.
 * @author gkuznetsov.
 * @since 19.09.17.
 */

public class Tracker {
    /**
     * Items of application.
     */
    private ArrayList<Item> items = new ArrayList<>();


    /**
     * This method add new element in array Items.
     * @param item - element.
     * @return Item.
     */
    public Item add(Item item) {
        this.items.add(item);
        return item;
    }

    /**
     * This method update selected element.
     * @param item - element.
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                items.set(i, item);
                break;
            }
        }

//        for (int i = 0; i < position; i++) {
////            if (this.items[i].getId().equals(id)) {
////                this.items[i] = item;
////            }
//            if (this.items.get(i).getId().equals(id)) {
//                this.items.add(i, item);
//            }
//        }
    }

    /**
     * This element delete selected element.
     * @param item - element.
     */
    public void delete(Item item) {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(item.getId())) {
                it.remove();
                break;
            }
        }
    }

    /**
     * This method find all elements.
     * @return Item[].
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item itm : items) {
            if (itm != null) {
                result.add(itm);
            }
        }
        return result;
    }

    /**
     * This method find element by name.
     * @param key - name of element.
     * @return Item[].
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item itm : items) {
            if (itm.getName().equals(key)) {
                result.add(itm);
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
        Item result = null;
        for (Item itm : items) {
            if (itm != null && itm.getId().equals(id)) {
                result = itm;
                break;
            }
        }
        return result;
    }
}
