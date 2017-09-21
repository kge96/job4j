package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;

/**
 * Class for return info about item.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class ItemInfo {
    /**
     * Take item and return info about it.
     * @param item - item.
     * @return String.
     */
    public static String getInfo(Item item) {
        return "ID: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDesc() + ";";
    }
}
