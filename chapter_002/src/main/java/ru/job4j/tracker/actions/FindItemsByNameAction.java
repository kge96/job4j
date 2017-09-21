package ru.job4j.tracker.actions;

import ru.job4j.tracker.Action;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
/**
 * Class for search items by Name on tracker.
 *
 * @author gkuznetsov.
 * @since 21.09.17.
 * @version 0.1.
 */
public class FindItemsByNameAction implements Action {
    /**
     * Search items by name on tracker.
     * @param tracker - item storage.
     * @param input - messenger for ask question, get parameters and tell answer.
     */
    @Override
    public void execute(Tracker tracker, Input input) {
        String name = input.ask("Enter user name: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            input.print("Item not found\n");
        } else {
            input.print("Was founded " + items.length + " items: ");
            for (Item item : items) {
                input.print(ItemInfo.getInfo(item));
            }
        }
    }
}
